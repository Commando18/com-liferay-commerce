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

package com.liferay.commerce.inventory.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommerceInventoryWarehouseGroupRel service. Represents a row in the &quot;CIWarehouseGroupRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseGroupRelModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseGroupRelImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CommerceInventoryWarehouseGroupRel
 * @see com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseGroupRelImpl
 * @see com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseGroupRelModelImpl
 * @generated
 */
@ProviderType
public interface CommerceInventoryWarehouseGroupRelModel extends BaseModel<CommerceInventoryWarehouseGroupRel>,
	GroupedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce inventory warehouse group rel model instance should use the {@link CommerceInventoryWarehouseGroupRel} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce inventory warehouse group rel.
	 *
	 * @return the primary key of this commerce inventory warehouse group rel
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce inventory warehouse group rel.
	 *
	 * @param primaryKey the primary key of this commerce inventory warehouse group rel
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce inventory warehouse group rel ID of this commerce inventory warehouse group rel.
	 *
	 * @return the commerce inventory warehouse group rel ID of this commerce inventory warehouse group rel
	 */
	public long getCommerceInventoryWarehouseGroupRelId();

	/**
	 * Sets the commerce inventory warehouse group rel ID of this commerce inventory warehouse group rel.
	 *
	 * @param commerceInventoryWarehouseGroupRelId the commerce inventory warehouse group rel ID of this commerce inventory warehouse group rel
	 */
	public void setCommerceInventoryWarehouseGroupRelId(
		long commerceInventoryWarehouseGroupRelId);

	/**
	 * Returns the group ID of this commerce inventory warehouse group rel.
	 *
	 * @return the group ID of this commerce inventory warehouse group rel
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this commerce inventory warehouse group rel.
	 *
	 * @param groupId the group ID of this commerce inventory warehouse group rel
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this commerce inventory warehouse group rel.
	 *
	 * @return the company ID of this commerce inventory warehouse group rel
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce inventory warehouse group rel.
	 *
	 * @param companyId the company ID of this commerce inventory warehouse group rel
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce inventory warehouse group rel.
	 *
	 * @return the user ID of this commerce inventory warehouse group rel
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce inventory warehouse group rel.
	 *
	 * @param userId the user ID of this commerce inventory warehouse group rel
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce inventory warehouse group rel.
	 *
	 * @return the user uuid of this commerce inventory warehouse group rel
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce inventory warehouse group rel.
	 *
	 * @param userUuid the user uuid of this commerce inventory warehouse group rel
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce inventory warehouse group rel.
	 *
	 * @return the user name of this commerce inventory warehouse group rel
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce inventory warehouse group rel.
	 *
	 * @param userName the user name of this commerce inventory warehouse group rel
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce inventory warehouse group rel.
	 *
	 * @return the create date of this commerce inventory warehouse group rel
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce inventory warehouse group rel.
	 *
	 * @param createDate the create date of this commerce inventory warehouse group rel
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce inventory warehouse group rel.
	 *
	 * @return the modified date of this commerce inventory warehouse group rel
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce inventory warehouse group rel.
	 *
	 * @param modifiedDate the modified date of this commerce inventory warehouse group rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the commerce warehouse ID of this commerce inventory warehouse group rel.
	 *
	 * @return the commerce warehouse ID of this commerce inventory warehouse group rel
	 */
	public long getCommerceWarehouseId();

	/**
	 * Sets the commerce warehouse ID of this commerce inventory warehouse group rel.
	 *
	 * @param commerceWarehouseId the commerce warehouse ID of this commerce inventory warehouse group rel
	 */
	public void setCommerceWarehouseId(long commerceWarehouseId);

	/**
	 * Returns the primary of this commerce inventory warehouse group rel.
	 *
	 * @return the primary of this commerce inventory warehouse group rel
	 */
	public boolean getPrimary();

	/**
	 * Returns <code>true</code> if this commerce inventory warehouse group rel is primary.
	 *
	 * @return <code>true</code> if this commerce inventory warehouse group rel is primary; <code>false</code> otherwise
	 */
	public boolean isPrimary();

	/**
	 * Sets whether this commerce inventory warehouse group rel is primary.
	 *
	 * @param primary the primary of this commerce inventory warehouse group rel
	 */
	public void setPrimary(boolean primary);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		CommerceInventoryWarehouseGroupRel commerceInventoryWarehouseGroupRel);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceInventoryWarehouseGroupRel> toCacheModel();

	@Override
	public CommerceInventoryWarehouseGroupRel toEscapedModel();

	@Override
	public CommerceInventoryWarehouseGroupRel toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}