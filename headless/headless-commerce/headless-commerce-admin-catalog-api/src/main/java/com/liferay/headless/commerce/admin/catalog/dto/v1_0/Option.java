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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;
import java.util.Objects;

import javax.annotation.Generated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
@GraphQLName("Option")
@JsonFilter("Liferay.Vulcan")
@Schema(requiredProperties = {"fieldType", "key", "name", "optionId"})
@XmlRootElement(name = "Option")
public class Option {

	public static enum FieldType {

		SELECT("select"), RADIO("radio"), DATE("date"), CHECKBOX("checkbox"),
		CHECKBOX_MULTIPLE("checkbox_multiple"), NUMERIC("numeric");

		@JsonCreator
		public static FieldType create(String value) {
			for (FieldType fieldType : values()) {
				if (Objects.equals(fieldType.getValue(), value)) {
					return fieldType;
				}
			}

			return null;
		}

		@JsonValue
		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private FieldType(String value) {
			_value = value;
		}

		private final String _value;

	}

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

	public Boolean getFacetable() {
		return facetable;
	}

	public void setFacetable(Boolean facetable) {
		this.facetable = facetable;
	}

	@JsonIgnore
	public void setFacetable(
		UnsafeSupplier<Boolean, Exception> facetableUnsafeSupplier) {

		try {
			facetable = facetableUnsafeSupplier.get();
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
	protected Boolean facetable;

	public FieldType getFieldType() {
		return fieldType;
	}

	@JsonIgnore
	public String getFieldTypeAsString() {
		if (fieldType == null) {
			return null;
		}

		return fieldType.toString();
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	@JsonIgnore
	public void setFieldType(
		UnsafeSupplier<FieldType, Exception> fieldTypeUnsafeSupplier) {

		try {
			fieldType = fieldTypeUnsafeSupplier.get();
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
	protected FieldType fieldType;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@JsonIgnore
	public void setKey(UnsafeSupplier<String, Exception> keyUnsafeSupplier) {
		try {
			key = keyUnsafeSupplier.get();
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
	@NotEmpty
	protected String key;

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

	public Double getPriority() {
		return priority;
	}

	public void setPriority(Double priority) {
		this.priority = priority;
	}

	@JsonIgnore
	public void setPriority(
		UnsafeSupplier<Double, Exception> priorityUnsafeSupplier) {

		try {
			priority = priorityUnsafeSupplier.get();
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
	protected Double priority;

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	@JsonIgnore
	public void setRequired(
		UnsafeSupplier<Boolean, Exception> requiredUnsafeSupplier) {

		try {
			required = requiredUnsafeSupplier.get();
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
	protected Boolean required;

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

	public Boolean getSkuContributor() {
		return skuContributor;
	}

	public void setSkuContributor(Boolean skuContributor) {
		this.skuContributor = skuContributor;
	}

	@JsonIgnore
	public void setSkuContributor(
		UnsafeSupplier<Boolean, Exception> skuContributorUnsafeSupplier) {

		try {
			skuContributor = skuContributorUnsafeSupplier.get();
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
	protected Boolean skuContributor;

	public OptionValue[] getValues() {
		return values;
	}

	public void setValues(OptionValue[] values) {
		this.values = values;
	}

	@JsonIgnore
	public void setValues(
		UnsafeSupplier<OptionValue[], Exception> valuesUnsafeSupplier) {

		try {
			values = valuesUnsafeSupplier.get();
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
	protected OptionValue[] values;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Option)) {
			return false;
		}

		Option option = (Option)object;

		return Objects.equals(toString(), option.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		sb.append("\"description\": ");

		if (description == null) {
			sb.append("null");
		}
		else {
			sb.append(description);
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

		sb.append("\"facetable\": ");

		if (facetable == null) {
			sb.append("null");
		}
		else {
			sb.append(facetable);
		}

		sb.append(", ");

		sb.append("\"fieldType\": ");

		if (fieldType == null) {
			sb.append("null");
		}
		else {
			sb.append("\"");
			sb.append(fieldType);
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

		sb.append("\"key\": ");

		if (key == null) {
			sb.append("null");
		}
		else {
			sb.append("\"");
			sb.append(key);
			sb.append("\"");
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

		sb.append("\"priority\": ");

		if (priority == null) {
			sb.append("null");
		}
		else {
			sb.append(priority);
		}

		sb.append(", ");

		sb.append("\"required\": ");

		if (required == null) {
			sb.append("null");
		}
		else {
			sb.append(required);
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

		sb.append("\"skuContributor\": ");

		if (skuContributor == null) {
			sb.append("null");
		}
		else {
			sb.append(skuContributor);
		}

		sb.append(", ");

		sb.append("\"values\": ");

		if (values == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < values.length; i++) {
				sb.append(values[i]);

				if ((i + 1) < values.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

}