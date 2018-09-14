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

package com.liferay.commerce.product.service.impl;

import com.liferay.commerce.product.constants.CPActionKeys;
import com.liferay.commerce.product.constants.CPConstants;
import com.liferay.commerce.product.model.CPSubscriptionEntry;
import com.liferay.commerce.product.service.base.CPSubscriptionEntryServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * @author Alessio Antonio Rendina
 */
public class CPSubscriptionEntryServiceImpl
	extends CPSubscriptionEntryServiceBaseImpl {

	@Override
	public void deleteCPSubscriptionEntry(long cpSubscriptionEntryId)
		throws PortalException {

		CPSubscriptionEntry cpSubscriptionEntry =
			cpSubscriptionEntryLocalService.getCPSubscriptionEntry(
				cpSubscriptionEntryId);

		_portletResourcePermission.check(
			getPermissionChecker(), cpSubscriptionEntry.getGroupId(),
			CPActionKeys.MANAGE_COMMERCE_PRODUCT_SUBSCRIPTIONS);

		cpSubscriptionEntryLocalService.deleteCPSubscriptionEntry(
			cpSubscriptionEntryId);
	}

	@Override
	public CPSubscriptionEntry fetchCPSubscriptionEntry(
			long cpSubscriptionEntryId)
		throws PortalException {

		CPSubscriptionEntry cpSubscriptionEntry =
			cpSubscriptionEntryLocalService.fetchCPSubscriptionEntry(
				cpSubscriptionEntryId);

		if (cpSubscriptionEntry != null) {
			_portletResourcePermission.check(
				getPermissionChecker(), cpSubscriptionEntry.getGroupId(),
				CPActionKeys.MANAGE_COMMERCE_PRODUCT_SUBSCRIPTIONS);
		}

		return cpSubscriptionEntry;
	}

	@Override
	public List<CPSubscriptionEntry> getCPSubscriptionEntries(
			long groupId, long userId, int start, int end,
			OrderByComparator<CPSubscriptionEntry> orderByComparator)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CPActionKeys.MANAGE_COMMERCE_PRODUCT_SUBSCRIPTIONS);

		return cpSubscriptionEntryLocalService.getCPSubscriptionEntries(
			groupId, userId, start, end, orderByComparator);
	}

	@Override
	public int getCPSubscriptionEntriesCount(long groupId, long userId)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CPActionKeys.MANAGE_COMMERCE_PRODUCT_SUBSCRIPTIONS);

		return cpSubscriptionEntryLocalService.getCPSubscriptionEntriesCount(
			groupId, userId);
	}

	@Override
	public BaseModelSearchResult<CPSubscriptionEntry>
			searchCPSubscriptionEntries(
				long companyId, long groupId, Boolean active, String keywords,
				int start, int end, Sort sort)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId,
			CPActionKeys.MANAGE_COMMERCE_PRODUCT_SUBSCRIPTIONS);

		return cpSubscriptionEntryLocalService.searchCPSubscriptionEntries(
			companyId, groupId, active, keywords, start, end, sort);
	}

	@Override
	public CPSubscriptionEntry updateCommercePriceEntry(
			long cpSubscriptionEntryId, long subscriptionCycleLength,
			String subscriptionCyclePeriod, long maxSubscriptionCyclesNumber,
			boolean active, ServiceContext serviceContext)
		throws PrincipalException {

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			CPActionKeys.MANAGE_COMMERCE_PRODUCT_SUBSCRIPTIONS);

		return cpSubscriptionEntryLocalService.updateCPSubscriptionEntry(
			cpSubscriptionEntryId, subscriptionCycleLength,
			subscriptionCyclePeriod, maxSubscriptionCyclesNumber, active);
	}

	private static volatile PortletResourcePermission
		_portletResourcePermission =
			PortletResourcePermissionFactory.getInstance(
				CPSubscriptionEntryServiceImpl.class,
				"_portletResourcePermission", CPConstants.RESOURCE_NAME);

}