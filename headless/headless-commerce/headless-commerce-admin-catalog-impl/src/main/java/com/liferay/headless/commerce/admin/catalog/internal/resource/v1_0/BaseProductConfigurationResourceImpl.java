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

package com.liferay.headless.commerce.admin.catalog.internal.resource.v1_0;

import com.liferay.headless.commerce.admin.catalog.dto.v1_0.ProductConfiguration;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductConfigurationResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseProductConfigurationResourceImpl
	implements ProductConfigurationResource {

	@Override
	@GET
	@Path("/products/{id}/configuration/")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ProductConfiguration")})
	public ProductConfiguration getProductIdConfiguration(
			@NotNull @PathParam("id") Long id)
		throws Exception {

		return new ProductConfiguration();
	}

	@Override
	@Consumes("application/json")
	@PATCH
	@Path("/products/{id}/configuration/")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ProductConfiguration")})
	public Response patchProductIdConfiguration(
			@NotNull @PathParam("id") Long id,
			ProductConfiguration productConfiguration)
		throws Exception {

		Response.ResponseBuilder responseBuilder = Response.ok();

		return responseBuilder.build();
	}

	@Override
	@GET
	@Path(
		"/products/by-externalReferenceCode/{externalReferenceCode}/configuration/"
	)
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ProductConfiguration")})
	public ProductConfiguration getProductByExternalReferenceCodeConfiguration(
			@NotNull @PathParam("externalReferenceCode") String
				externalReferenceCode)
		throws Exception {

		return new ProductConfiguration();
	}

	@Override
	@Consumes("application/json")
	@PATCH
	@Path(
		"/products/by-externalReferenceCode/{externalReferenceCode}/configuration/"
	)
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ProductConfiguration")})
	public Response patchProductByExternalReferenceCodeConfiguration(
			@NotNull @PathParam("externalReferenceCode") String
				externalReferenceCode,
			ProductConfiguration productConfiguration)
		throws Exception {

		Response.ResponseBuilder responseBuilder = Response.ok();

		return responseBuilder.build();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(
		ProductConfiguration productConfiguration,
		ProductConfiguration existingProductConfiguration) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}