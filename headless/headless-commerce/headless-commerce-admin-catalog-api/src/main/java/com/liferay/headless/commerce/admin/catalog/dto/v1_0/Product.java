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

package com.liferay.headless.commerce.admin.catalog.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;
import java.util.Objects;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
@GraphQLName("Product")
@JsonFilter("Liferay.Vulcan")
@Schema(requiredProperties = {"active", "name", "productTypeName"})
@XmlRootElement(name = "Product")
public class Product {

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@JsonIgnore
	public void setActive(
		UnsafeSupplier<Boolean, Exception> activeUnsafeSupplier) {

		try {
			active = activeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Boolean active;

	public Attachment[] getAttachments() {
		return attachments;
	}

	public void setAttachments(Attachment[] attachments) {
		this.attachments = attachments;
	}

	@JsonIgnore
	public void setAttachments(
		UnsafeSupplier<Attachment[], Exception> attachmentsUnsafeSupplier) {

		try {
			attachments = attachmentsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Attachment[] attachments;

	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

	@JsonIgnore
	public void setCategories(
		UnsafeSupplier<Category[], Exception> categoriesUnsafeSupplier) {

		try {
			categories = categoriesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Category[] categories;

	public ProductConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(ProductConfiguration configuration) {
		this.configuration = configuration;
	}

	@JsonIgnore
	public void setConfiguration(
		UnsafeSupplier<ProductConfiguration, Exception>
			configurationUnsafeSupplier) {

		try {
			configuration = configurationUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected ProductConfiguration configuration;

	public String getDefaultSku() {
		return defaultSku;
	}

	public void setDefaultSku(String defaultSku) {
		this.defaultSku = defaultSku;
	}

	@JsonIgnore
	public void setDefaultSku(
		UnsafeSupplier<String, Exception> defaultSkuUnsafeSupplier) {

		try {
			defaultSku = defaultSkuUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String defaultSku;

	public Map<String, String> getDescription() {
		return description;
	}

	public void setDescription(Map<String, String> description) {
		this.description = description;
	}

	@JsonIgnore
	public void setDescription(
		UnsafeSupplier<Map<String, String>, Exception>
			descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Map<String, String> description;

	public Map<String, ?> getExpando() {
		return expando;
	}

	public void setExpando(Map<String, ?> expando) {
		this.expando = expando;
	}

	@JsonIgnore
	public void setExpando(
		UnsafeSupplier<Map<String, ?>, Exception> expandoUnsafeSupplier) {

		try {
			expando = expandoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Map<String, ?> expando;

	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}

	@JsonIgnore
	public void setExternalReferenceCode(
		UnsafeSupplier<String, Exception> externalReferenceCodeUnsafeSupplier) {

		try {
			externalReferenceCode = externalReferenceCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String externalReferenceCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long id;

	public Attachment[] getImages() {
		return images;
	}

	public void setImages(Attachment[] images) {
		this.images = images;
	}

	@JsonIgnore
	public void setImages(
		UnsafeSupplier<Attachment[], Exception> imagesUnsafeSupplier) {

		try {
			images = imagesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Attachment[] images;

	public Map<String, String> getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(Map<String, String> metaDescription) {
		this.metaDescription = metaDescription;
	}

	@JsonIgnore
	public void setMetaDescription(
		UnsafeSupplier<Map<String, String>, Exception>
			metaDescriptionUnsafeSupplier) {

		try {
			metaDescription = metaDescriptionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Map<String, String> metaDescription;

	public Map<String, String> getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(Map<String, String> metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

	@JsonIgnore
	public void setMetaKeyword(
		UnsafeSupplier<Map<String, String>, Exception>
			metaKeywordUnsafeSupplier) {

		try {
			metaKeyword = metaKeywordUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Map<String, String> metaKeyword;

	public Map<String, String> getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(Map<String, String> metaTitle) {
		this.metaTitle = metaTitle;
	}

	@JsonIgnore
	public void setMetaTitle(
		UnsafeSupplier<Map<String, String>, Exception>
			metaTitleUnsafeSupplier) {

		try {
			metaTitle = metaTitleUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Map<String, String> metaTitle;

	public Map<String, String> getName() {
		return name;
	}

	public void setName(Map<String, String> name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(
		UnsafeSupplier<Map<String, String>, Exception> nameUnsafeSupplier) {

		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Map<String, String> name;

	public ProductOption[] getOptions() {
		return options;
	}

	public void setOptions(ProductOption[] options) {
		this.options = options;
	}

	@JsonIgnore
	public void setOptions(
		UnsafeSupplier<ProductOption[], Exception> optionsUnsafeSupplier) {

		try {
			options = optionsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected ProductOption[] options;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@JsonIgnore
	public void setProductId(
		UnsafeSupplier<Long, Exception> productIdUnsafeSupplier) {

		try {
			productId = productIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long productId;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@JsonIgnore
	public void setProductType(
		UnsafeSupplier<String, Exception> productTypeUnsafeSupplier) {

		try {
			productType = productTypeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String productType;

	public RelatedProduct[] getRelatedProducts() {
		return relatedProducts;
	}

	public void setRelatedProducts(RelatedProduct[] relatedProducts) {
		this.relatedProducts = relatedProducts;
	}

	@JsonIgnore
	public void setRelatedProducts(
		UnsafeSupplier<RelatedProduct[], Exception>
			relatedProductsUnsafeSupplier) {

		try {
			relatedProducts = relatedProductsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected RelatedProduct[] relatedProducts;

	public ProductShippingConfiguration getShippingConfiguration() {
		return shippingConfiguration;
	}

	public void setShippingConfiguration(
		ProductShippingConfiguration shippingConfiguration) {

		this.shippingConfiguration = shippingConfiguration;
	}

	@JsonIgnore
	public void setShippingConfiguration(
		UnsafeSupplier<ProductShippingConfiguration, Exception>
			shippingConfigurationUnsafeSupplier) {

		try {
			shippingConfiguration = shippingConfigurationUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected ProductShippingConfiguration shippingConfiguration;

	public Map<String, String> getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(Map<String, String> shortDescription) {
		this.shortDescription = shortDescription;
	}

	@JsonIgnore
	public void setShortDescription(
		UnsafeSupplier<Map<String, String>, Exception>
			shortDescriptionUnsafeSupplier) {

		try {
			shortDescription = shortDescriptionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Map<String, String> shortDescription;

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	@JsonIgnore
	public void setSiteId(
		UnsafeSupplier<Long, Exception> siteIdUnsafeSupplier) {

		try {
			siteId = siteIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long siteId;

	public Sku[] getSkus() {
		return skus;
	}

	public void setSkus(Sku[] skus) {
		this.skus = skus;
	}

	@JsonIgnore
	public void setSkus(UnsafeSupplier<Sku[], Exception> skusUnsafeSupplier) {
		try {
			skus = skusUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Sku[] skus;

	public ProductSubscriptionConfiguration getSubscriptionConfiguration() {
		return subscriptionConfiguration;
	}

	public void setSubscriptionConfiguration(
		ProductSubscriptionConfiguration subscriptionConfiguration) {

		this.subscriptionConfiguration = subscriptionConfiguration;
	}

	@JsonIgnore
	public void setSubscriptionConfiguration(
		UnsafeSupplier<ProductSubscriptionConfiguration, Exception>
			subscriptionConfigurationUnsafeSupplier) {

		try {
			subscriptionConfiguration =
				subscriptionConfigurationUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected ProductSubscriptionConfiguration subscriptionConfiguration;

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@JsonIgnore
	public void setTags(
		UnsafeSupplier<String[], Exception> tagsUnsafeSupplier) {

		try {
			tags = tagsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] tags;

	public ProductTaxConfiguration getTaxConfiguration() {
		return taxConfiguration;
	}

	public void setTaxConfiguration(ProductTaxConfiguration taxConfiguration) {
		this.taxConfiguration = taxConfiguration;
	}

	@JsonIgnore
	public void setTaxConfiguration(
		UnsafeSupplier<ProductTaxConfiguration, Exception>
			taxConfigurationUnsafeSupplier) {

		try {
			taxConfiguration = taxConfigurationUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected ProductTaxConfiguration taxConfiguration;

	public Map<String, String> getUrls() {
		return urls;
	}

	public void setUrls(Map<String, String> urls) {
		this.urls = urls;
	}

	@JsonIgnore
	public void setUrls(
		UnsafeSupplier<Map<String, String>, Exception> urlsUnsafeSupplier) {

		try {
			urls = urlsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Map<String, String> urls;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Product)) {
			return false;
		}

		Product product = (Product)object;

		return Objects.equals(toString(), product.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		sb.append("\"active\": ");

		if (active == null) {
			sb.append("null");
		}
		else {
			sb.append(active);
		}

		sb.append(", ");

		sb.append("\"attachments\": ");

		if (attachments == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < attachments.length; i++) {
				sb.append(attachments[i]);

				if ((i + 1) < attachments.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append(", ");

		sb.append("\"categories\": ");

		if (categories == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < categories.length; i++) {
				sb.append(categories[i]);

				if ((i + 1) < categories.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append(", ");

		sb.append("\"configuration\": ");

		if (configuration == null) {
			sb.append("null");
		}
		else {
			sb.append(configuration);
		}

		sb.append(", ");

		sb.append("\"defaultSku\": ");

		if (defaultSku == null) {
			sb.append("null");
		}
		else {
			sb.append("\"");
			sb.append(defaultSku);
			sb.append("\"");
		}

		sb.append(", ");

		sb.append("\"description\": ");

		if (description == null) {
			sb.append("null");
		}
		else {
			sb.append(description);
		}

		sb.append(", ");

		sb.append("\"expando\": ");

		if (expando == null) {
			sb.append("null");
		}
		else {
			sb.append(expando);
		}

		sb.append(", ");

		sb.append("\"externalReferenceCode\": ");

		if (externalReferenceCode == null) {
			sb.append("null");
		}
		else {
			sb.append("\"");
			sb.append(externalReferenceCode);
			sb.append("\"");
		}

		sb.append(", ");

		sb.append("\"id\": ");

		if (id == null) {
			sb.append("null");
		}
		else {
			sb.append(id);
		}

		sb.append(", ");

		sb.append("\"images\": ");

		if (images == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < images.length; i++) {
				sb.append(images[i]);

				if ((i + 1) < images.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append(", ");

		sb.append("\"metaDescription\": ");

		if (metaDescription == null) {
			sb.append("null");
		}
		else {
			sb.append(metaDescription);
		}

		sb.append(", ");

		sb.append("\"metaKeyword\": ");

		if (metaKeyword == null) {
			sb.append("null");
		}
		else {
			sb.append(metaKeyword);
		}

		sb.append(", ");

		sb.append("\"metaTitle\": ");

		if (metaTitle == null) {
			sb.append("null");
		}
		else {
			sb.append(metaTitle);
		}

		sb.append(", ");

		sb.append("\"name\": ");

		if (name == null) {
			sb.append("null");
		}
		else {
			sb.append(name);
		}

		sb.append(", ");

		sb.append("\"options\": ");

		if (options == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < options.length; i++) {
				sb.append(options[i]);

				if ((i + 1) < options.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append(", ");

		sb.append("\"productId\": ");

		if (productId == null) {
			sb.append("null");
		}
		else {
			sb.append(productId);
		}

		sb.append(", ");

		sb.append("\"productType\": ");

		if (productType == null) {
			sb.append("null");
		}
		else {
			sb.append("\"");
			sb.append(productType);
			sb.append("\"");
		}

		sb.append(", ");

		sb.append("\"relatedProducts\": ");

		if (relatedProducts == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < relatedProducts.length; i++) {
				sb.append(relatedProducts[i]);

				if ((i + 1) < relatedProducts.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append(", ");

		sb.append("\"shippingConfiguration\": ");

		if (shippingConfiguration == null) {
			sb.append("null");
		}
		else {
			sb.append(shippingConfiguration);
		}

		sb.append(", ");

		sb.append("\"shortDescription\": ");

		if (shortDescription == null) {
			sb.append("null");
		}
		else {
			sb.append(shortDescription);
		}

		sb.append(", ");

		sb.append("\"siteId\": ");

		if (siteId == null) {
			sb.append("null");
		}
		else {
			sb.append(siteId);
		}

		sb.append(", ");

		sb.append("\"skus\": ");

		if (skus == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < skus.length; i++) {
				sb.append(skus[i]);

				if ((i + 1) < skus.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append(", ");

		sb.append("\"subscriptionConfiguration\": ");

		if (subscriptionConfiguration == null) {
			sb.append("null");
		}
		else {
			sb.append(subscriptionConfiguration);
		}

		sb.append(", ");

		sb.append("\"tags\": ");

		if (tags == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < tags.length; i++) {
				sb.append("\"");
				sb.append(tags[i]);
				sb.append("\"");

				if ((i + 1) < tags.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append(", ");

		sb.append("\"taxConfiguration\": ");

		if (taxConfiguration == null) {
			sb.append("null");
		}
		else {
			sb.append(taxConfiguration);
		}

		sb.append(", ");

		sb.append("\"urls\": ");

		if (urls == null) {
			sb.append("null");
		}
		else {
			sb.append(urls);
		}

		sb.append("}");

		return sb.toString();
	}

}