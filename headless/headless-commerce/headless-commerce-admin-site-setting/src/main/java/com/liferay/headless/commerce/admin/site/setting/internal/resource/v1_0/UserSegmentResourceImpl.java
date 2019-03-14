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

package com.liferay.headless.commerce.admin.site.setting.internal.resource.v1_0;

import com.liferay.commerce.openapi.core.annotation.AsyncSupported;
import com.liferay.commerce.openapi.core.annotation.Status;
import com.liferay.commerce.openapi.core.context.Async;
import com.liferay.commerce.openapi.core.context.Pagination;
import com.liferay.commerce.openapi.core.model.CollectionDTO;
import com.liferay.headless.commerce.admin.site.setting.internal.resource.util.v1_0.UserSegmentCriterionHelper;
import com.liferay.headless.commerce.admin.site.setting.internal.resource.util.v1_0.UserSegmentHelper;
import com.liferay.headless.commerce.admin.site.setting.model.v1_0.UserSegmentCriterionDTO;
import com.liferay.headless.commerce.admin.site.setting.model.v1_0.UserSegmentDTO;
import com.liferay.headless.commerce.admin.site.setting.resource.v1_0.UserSegmentResource;
import com.liferay.oauth2.provider.scope.RequiresScope;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Alessio Antonio Rendina
 * @author Zoltán Takács
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=HeadlessCommerceAdminSiteSetting.Rest)",
		JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true", "api.version=v1.0"
	},
	scope = ServiceScope.PROTOTYPE, service = UserSegmentResource.class
)
public class UserSegmentResourceImpl implements UserSegmentResource {

	@Override
	@RequiresScope("HeadlessCommerceAdminSiteSetting.write")
	public Response deleteUserSegment(Long id) throws Exception {
		_userSegmentHelper.deleteUserSegment(id);

		Response.ResponseBuilder responseBuilder = Response.noContent();

		return responseBuilder.build();
	}

	@Override
	@RequiresScope("HeadlessCommerceAdminSiteSetting.write")
	public Response deleteUserSegmentCriterion(Long id, Long criterionId)
		throws Exception {

		_userSegmentCriterionHelper.deleteUserSegmentCriterion(criterionId);

		Response.ResponseBuilder responseBuilder = Response.noContent();

		return responseBuilder.build();
	}

	@Override
	@RequiresScope("HeadlessCommerceAdminSiteSetting.read")
	public UserSegmentDTO getUserSegment(Long id) throws Exception {
		return _userSegmentHelper.getUserSegmentDTO(id);
	}

	@Override
	@RequiresScope("HeadlessCommerceAdminSiteSetting.read")
	public CollectionDTO<UserSegmentCriterionDTO> getUserSegmentCriteria(
			Long id, Pagination pagination)
		throws Exception {

		return _userSegmentCriterionHelper.getUserSegmentCriterionDTOs(
			GetterUtil.getLong(id), pagination);
	}

	@Override
	@RequiresScope("HeadlessCommerceAdminSiteSetting.read")
	public UserSegmentCriterionDTO getUserSegmentCriterion(
			Long id, Long criterionId)
		throws Exception {

		return _userSegmentCriterionHelper.getUserSegmentCriterionDTO(
			criterionId);
	}

	@AsyncSupported
	@Override
	@RequiresScope("HeadlessCommerceAdminSiteSetting.write")
	public Response updateUserSegment(Long id, UserSegmentDTO userSegmentDTO)
		throws Exception {

		if (_async.isEnabled()) {
			new Thread(
				() -> {
					try {
						_userSegmentHelper.updateUserSegment(
							id, userSegmentDTO, _user);
					}
					catch (PortalException pe) {
						_log.error(pe, pe);
					}
				}
			).start();

			return null;
		}

		_userSegmentHelper.updateUserSegment(id, userSegmentDTO, _user);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.build();
	}

	@AsyncSupported
	@Override
	@RequiresScope("HeadlessCommerceAdminSiteSetting.write")
	public UserSegmentCriterionDTO updateUserSegmentCriterion(
			Long id, Long criterionId,
			UserSegmentCriterionDTO userSegmentCriterionDTO)
		throws Exception {

		if (_async.isEnabled()) {
			new Thread(
				() -> {
					try {
						_userSegmentCriterionHelper.updateUserSegmentCriterion(
							criterionId, userSegmentCriterionDTO, _user);
					}
					catch (PortalException pe) {
						_log.error(pe, pe);
					}
				}
			).start();

			return null;
		}

		return _userSegmentCriterionHelper.updateUserSegmentCriterion(
			criterionId, userSegmentCriterionDTO, _user);
	}

	@AsyncSupported
	@Override
	@RequiresScope("HeadlessCommerceAdminSiteSetting.write")
	@Status(Response.Status.CREATED)
	public UserSegmentCriterionDTO upsertUserSegmentCriterion(
			Long id, UserSegmentCriterionDTO userSegmentCriterionDTO)
		throws Exception {

		if (_async.isEnabled()) {
			new Thread(
				() -> {
					try {
						_userSegmentCriterionHelper.upsertUserSegmentCriterion(
							GetterUtil.getLong(id), userSegmentCriterionDTO,
							_user);
					}
					catch (PortalException pe) {
						_log.error(pe, pe);
					}
				}
			).start();

			return null;
		}

		return _userSegmentCriterionHelper.upsertUserSegmentCriterion(
			GetterUtil.getLong(id), userSegmentCriterionDTO, _user);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserSegmentResourceImpl.class);

	@Context
	private Async _async;

	@Context
	private User _user;

	@Reference
	private UserSegmentCriterionHelper _userSegmentCriterionHelper;

	@Reference
	private UserSegmentHelper _userSegmentHelper;

}