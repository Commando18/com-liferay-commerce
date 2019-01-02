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

package com.liferay.commerce.frontend.internal.application;

import com.liferay.commerce.frontend.ClayTableDataJSONBuilder;
import com.liferay.commerce.frontend.CommerceDataProviderRegistry;
import com.liferay.commerce.frontend.CommerceDataSetDataProvider;
import com.liferay.commerce.frontend.FilterFactory;
import com.liferay.commerce.frontend.FilterFactoryRegistry;
import com.liferay.commerce.frontend.Pagination;
import com.liferay.commerce.frontend.internal.application.context.provider.PaginationContextProvider;
import com.liferay.commerce.frontend.internal.application.context.provider.SortContextProvider;
import com.liferay.portal.events.EventsProcessorUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.util.PropsValues;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Marco Leo
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/commerce-data-set",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=CommerceDataSet.Rest",
		"auth.verifier.auth.verifier.PortalSessionAuthVerifier.urls.includes=/*",
		"auth.verifier.guest.allowed=true", "liferay.oauth2=false"
	},
	service = Application.class
)
public class CommerceDataSetDataProviderApplication extends Application {

	@GET
	@Path("/{groupId}/{tableName}/{dataProvider}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(
		@PathParam("groupId") long groupId,
		@PathParam("tableName") String tableName,
		@PathParam("dataProvider") String dataProvider,
		@Context UriInfo uriInfo, @Context Pagination pagination,
		@Context Sort sort, @Context HttpServletRequest httpServletRequest,
		@Context HttpServletResponse httpServletResponse) {

		CommerceDataSetDataProvider commerceDataProvider =
			_commerceDataProviderRegistry.getCommerceDataProvider(dataProvider);

		FilterFactory filterFactory = _filterFactoryRegistry.getFilterFactory(
			dataProvider);

		try {
			EventsProcessorUtil.process(
				PropsKeys.SERVLET_SERVICE_EVENTS_PRE,
				PropsValues.SERVLET_SERVICE_EVENTS_PRE, httpServletRequest,
				httpServletResponse);

			List<Object> items = commerceDataProvider.getItems(
				groupId, filterFactory.create(httpServletRequest), pagination,
				sort);

			String json = _clayTableDataJSONBuilder.build(
				groupId, tableName, items, httpServletRequest);

			return Response.ok(
				json, MediaType.APPLICATION_JSON
			).build();
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return Response.status(
			Response.Status.NOT_FOUND
		).build();
	}

	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<>();

		singletons.add(_paginationContextProvider);
		singletons.add(_sortContextProvider);
		singletons.add(this);

		return singletons;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommerceDataSetDataProviderApplication.class);

	@Reference
	private ClayTableDataJSONBuilder _clayTableDataJSONBuilder;

	@Reference
	private CommerceDataProviderRegistry _commerceDataProviderRegistry;

	@Reference
	private FilterFactoryRegistry _filterFactoryRegistry;

	@Reference
	private PaginationContextProvider _paginationContextProvider;

	@Reference
	private Portal _portal;

	@Reference
	private SortContextProvider _sortContextProvider;

}