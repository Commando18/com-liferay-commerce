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

package com.liferay.commerce.headless.admin.site.setting.internal.exception;

import com.liferay.commerce.exception.CommerceWarehouseActiveException;
import com.liferay.commerce.openapi.core.exception.BaseExceptionMapper;
import com.liferay.commerce.openapi.core.exception.RESTError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=CommerceHeadlessAdminSiteSetting.Rest)",
		JaxrsWhiteboardConstants.JAX_RS_EXTENSION + "=true"
	},
	service = ExceptionMapper.class
)
@Provider
public class CommerceWarehouseActiveExceptionMapper
	extends BaseExceptionMapper<CommerceWarehouseActiveException> {

	@Override
	public int getErrorCode() {
		return RESTError.WAREHOUSE_ACTIVE_ERROR.getErrorCode();
	}

	@Override
	public String getErrorDescription() {
		return RESTError.WAREHOUSE_ACTIVE_ERROR.getErrorDescription();
	}

	@Override
	public Response.Status getStatus() {
		return RESTError.WAREHOUSE_ACTIVE_ERROR.getStatus();
	}

}