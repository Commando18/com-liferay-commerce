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

package com.liferay.commerce.openapi.admin.model.v2_0;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.annotation.Generated;

/**
 * @author Igor Beslic
 */
@Generated(value = "OSGiRESTModuleGenerator")
@JacksonXmlRootElement(localName = "Address")
public class AddressDTO {

	public String getCity() {
		return _city;
	}

	public Long getCommerceCountryId() {
		return _commerceCountryId;
	}

	public Long getCommerceRegionId() {
		return _commerceRegionId;
	}

	public String getDescription() {
		return _description;
	}

	public Long getId() {
		return _id;
	}

	public Double getLatitude() {
		return _latitude;
	}

	public Double getLongitude() {
		return _longitude;
	}

	public String getName() {
		return _name;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public String getStreet1() {
		return _street1;
	}

	public String getStreet2() {
		return _street2;
	}

	public String getStreet3() {
		return _street3;
	}

	public String getZip() {
		return _zip;
	}

	public Boolean isDefaultBilling() {
		return _defaultBilling;
	}

	public Boolean isDefaultShipping() {
		return _defaultShipping;
	}

	public void setCity(String city) {
		_city = city;
	}

	public void setCommerceCountryId(Long commerceCountryId) {
		_commerceCountryId = commerceCountryId;
	}

	public void setCommerceRegionId(Long commerceRegionId) {
		_commerceRegionId = commerceRegionId;
	}

	public void setDefaultBilling(Boolean defaultBilling) {
		_defaultBilling = defaultBilling;
	}

	public void setDefaultShipping(Boolean defaultShipping) {
		_defaultShipping = defaultShipping;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setId(Long id) {
		_id = id;
	}

	public void setLatitude(Double latitude) {
		_latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		_longitude = longitude;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public void setStreet1(String street1) {
		_street1 = street1;
	}

	public void setStreet2(String street2) {
		_street2 = street2;
	}

	public void setStreet3(String street3) {
		_street3 = street3;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	private String _city;
	private Long _commerceCountryId;
	private Long _commerceRegionId;
	private Boolean _defaultBilling;
	private Boolean _defaultShipping;
	private String _description;
	private Long _id;
	private Double _latitude;
	private Double _longitude;
	private String _name;
	private String _phoneNumber;
	private String _street1;
	private String _street2;
	private String _street3;
	private String _zip;

}