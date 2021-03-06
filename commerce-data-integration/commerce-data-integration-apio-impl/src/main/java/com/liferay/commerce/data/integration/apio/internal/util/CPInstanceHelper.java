/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.data.integration.apio.internal.util;

import com.liferay.commerce.data.integration.apio.identifier.ClassPKExternalReferenceCode;
import com.liferay.commerce.data.integration.apio.internal.exceptions.ConflictException;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.service.CPDefinitionService;
import com.liferay.commerce.product.service.CPInstanceLocalService;
import com.liferay.commerce.product.service.CPInstanceService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rodrigo Guedes de Souza
 * @author Zoltán Takács
 */
@Component(immediate = true, service = CPInstanceHelper.class)
public class CPInstanceHelper {

	public ClassPKExternalReferenceCode
		cpInstanceIdToClassPKExternalReferenceCode(long cpDefinitionId) {

		try {
			CPInstance cpInstance = _cpInstanceService.fetchCPInstance(
				cpDefinitionId);

			return cpInstanceToClassPKExternalReferenceCode(cpInstance);
		}
		catch (PortalException pe) {
			_log.error(
				"Unable to find CPInstance with ID " + cpDefinitionId, pe);
		}

		return null;
	}

	public ClassPKExternalReferenceCode
		cpInstanceToClassPKExternalReferenceCode(CPInstance cpInstance) {

		if (cpInstance != null) {
			return ClassPKExternalReferenceCode.create(
				cpInstance.getCPInstanceId(),
				cpInstance.getExternalReferenceCode());
		}

		return null;
	}

	public void deleteCPInstance(ClassPKExternalReferenceCode cpInstanceCPKERC)
		throws PortalException {

		CPInstance cpInstance = getCPInstanceByClassPKExternalReferenceCode(
			cpInstanceCPKERC);

		if (cpInstance != null) {
			_cpInstanceService.deleteCPInstance(cpInstance.getCPInstanceId());

			long cpDefinitionId = cpInstance.getCPDefinitionId();

			int total = _cpInstanceService.getCPDefinitionInstancesCount(
				cpDefinitionId, WorkflowConstants.STATUS_ANY);

			if (total == 0) {
				_cpDefinitionService.deleteCPDefinition(cpDefinitionId);
			}
		}
	}

	public CPInstance getCPInstanceByClassPKExternalReferenceCode(
		ClassPKExternalReferenceCode cpInstanceClassPKExternalReferenceCode) {

		long cpInstanceId = cpInstanceClassPKExternalReferenceCode.getClassPK();

		if (cpInstanceId > 0) {
			return _cpInstanceLocalService.fetchCPInstance(cpInstanceId);
		}
		else {
			String externalReferenceCode =
				cpInstanceClassPKExternalReferenceCode.
					getExternalReferenceCode();

			return _cpInstanceLocalService.fetchByExternalReferenceCode(
				CompanyThreadLocal.getCompanyId(), externalReferenceCode);
		}
	}

	public CPInstance updateCPInstance(
			ClassPKExternalReferenceCode cpInstanceCPKERC, String sku,
			String gtin, String manufacturerPartNumber, boolean purchasable,
			double width, double height, double depth, double weight,
			double cost, double price, double promoPrice, boolean published,
			Date displayDate, Date expirationDate, boolean neverExpire,
			String externalReference, User currentUser)
		throws PortalException {

		CPInstance cpInstance = getCPInstanceByClassPKExternalReferenceCode(
			cpInstanceCPKERC);

		ClassPKExternalReferenceCode cpDefinitionCPKERC =
			_cpDefinitionHelper.cpDefinitionIdToclassPKExternalReferenceCode(
				cpInstance.getCPDefinitionId());

		return upsertCPInstance(
			cpDefinitionCPKERC, sku, gtin, manufacturerPartNumber, purchasable,
			width, height, depth, weight, cost, price, promoPrice, published,
			displayDate, expirationDate, neverExpire, externalReference,
			cpInstance.getCPInstanceId(), currentUser);
	}

	public CPInstance upsertCPInstance(
			ClassPKExternalReferenceCode cpDefinitionCPKERC, String sku,
			String gtin, String manufacturerPartNumber, boolean purchasable,
			double width, double height, double depth, double weight,
			double cost, double price, double promoPrice, boolean published,
			Date displayDate, Date expirationDate, boolean neverExpire,
			String externalReference, long cpInstanceId, User currentUser)
		throws PortalException {

		CPDefinition cpDefinition =
			_cpDefinitionHelper.getCPDefinitionByClassPKExternalReferenceCode(
				cpDefinitionCPKERC);

		return upsertCPInstance(
			cpDefinition.getGroupId(), cpDefinition.getCPDefinitionId(), sku,
			gtin, manufacturerPartNumber, purchasable, width, height, depth,
			weight, cost, price, promoPrice, published, displayDate,
			expirationDate, neverExpire, externalReference, false, null, null,
			null, null, null, null, true, null, cpInstanceId, currentUser);
	}

	public CPInstance upsertCPInstance(
			long groupId, long cpDefinitionId, String sku, String gtin,
			String manufacturerPartNumber, boolean purchasable, double width,
			double height, double depth, double weight, double cost,
			double price, double promoPrice, boolean published,
			Date displayDate, Date expirationDate, boolean neverExpire,
			String externalReference, Boolean upsertProductIfNotExist,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> shortDescriptionMap, String productTypeName,
			String productExternalReferenceCode, long[] assetCategoryIds,
			boolean active, String defaultSku, long cpInstanceId,
			User currentUser)
		throws PortalException {

		if (productExternalReferenceCode != null) {
			CPDefinition cpDefinition = null;

			if (upsertProductIfNotExist) {
				cpDefinition = _cpDefinitionHelper.upsertCPDefinition(
					groupId, titleMap, descriptionMap, shortDescriptionMap,
					productTypeName, assetCategoryIds,
					productExternalReferenceCode, defaultSku, active, 0,
					currentUser);
			}
			else {
				cpDefinition =
					_cpDefinitionLocalService.fetchByExternalReferenceCode(
						currentUser.getCompanyId(),
						productExternalReferenceCode);
			}

			if (cpDefinition == null) {
				throw new ConflictException(
					"Product definition with external reference code: " +
						productExternalReferenceCode + " not found",
					Response.Status.CONFLICT);
			}

			cpDefinitionId = cpDefinition.getCPDefinitionId();
		}

		ServiceContext serviceContext = _serviceContextHelper.getServiceContext(
			groupId, new long[0], currentUser);

		Calendar displayCalendar = CalendarFactoryUtil.getCalendar(
			serviceContext.getTimeZone());

		if (displayDate != null) {
			displayCalendar.setTime(displayDate);
		}
		else {
			displayCalendar.add(Calendar.YEAR, -1);
		}

		int displayDateMonth = displayCalendar.get(Calendar.MONTH);
		int displayDateDay = displayCalendar.get(Calendar.DAY_OF_MONTH);
		int displayDateYear = displayCalendar.get(Calendar.YEAR);
		int displayDateHour = displayCalendar.get(Calendar.HOUR);
		int displayDateMinute = displayCalendar.get(Calendar.MINUTE);
		int displayDateAmPm = displayCalendar.get(Calendar.AM_PM);

		if (displayDateAmPm == Calendar.PM) {
			displayDateHour += 12;
		}

		Calendar expirationCalendar = CalendarFactoryUtil.getCalendar(
			serviceContext.getTimeZone());

		if (expirationDate != null) {
			expirationCalendar.setTime(expirationDate);
		}
		else {
			expirationCalendar.add(Calendar.YEAR, -1);
		}

		int expirationDateMonth = expirationCalendar.get(Calendar.MONTH);
		int expirationDateDay = expirationCalendar.get(Calendar.DAY_OF_MONTH);
		int expirationDateYear = expirationCalendar.get(Calendar.YEAR);
		int expirationDateHour = expirationCalendar.get(Calendar.HOUR);
		int expirationDateMinute = expirationCalendar.get(Calendar.MINUTE);
		int expirationDateAmPm = expirationCalendar.get(Calendar.AM_PM);

		if (expirationDateAmPm == Calendar.PM) {
			expirationDateHour += 12;
		}

		CPInstance cpInstance = null;

		// Update

		if (cpInstanceId > 0) {
			cpInstance = _cpInstanceService.updateCPInstance(
				cpInstanceId, sku, gtin, manufacturerPartNumber, purchasable,
				published, displayDateMonth, displayDateDay, displayDateYear,
				displayDateHour, displayDateMinute, expirationDateMonth,
				expirationDateDay, expirationDateYear, expirationDateHour,
				expirationDateMinute, neverExpire, serviceContext);
		}
		else {

			// Upsert

			cpInstance = _cpInstanceService.upsertCPInstance(
				cpDefinitionId, sku, gtin, manufacturerPartNumber, purchasable,
				null, width, height, depth, weight, new BigDecimal(price),
				new BigDecimal(promoPrice), new BigDecimal(cost), published,
				externalReference, displayDateMonth, displayDateDay,
				displayDateYear, displayDateHour, displayDateMinute,
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, neverExpire,
				serviceContext);
		}

		return cpInstance;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CPInstanceHelper.class);

	@Reference
	private CPDefinitionHelper _cpDefinitionHelper;

	@Reference
	private CPDefinitionLocalService _cpDefinitionLocalService;

	@Reference
	private CPDefinitionService _cpDefinitionService;

	@Reference
	private CPInstanceLocalService _cpInstanceLocalService;

	@Reference
	private CPInstanceService _cpInstanceService;

	@Reference
	private ServiceContextHelper _serviceContextHelper;

}