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

package com.liferay.commerce.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.service.CPInstanceLocalServiceUtil;
import com.liferay.commerce.service.CommerceOrderItemLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alessio Antonio Rendina
 */
@ProviderType
public class CPSubscriptionEntryImpl extends CPSubscriptionEntryBaseImpl {

	public CPSubscriptionEntryImpl() {
	}

	@Override
	public CommerceOrderItem fetchCommerceOrderItem() {
		return CommerceOrderItemLocalServiceUtil.fetchCommerceOrderItem(
			getCommerceOrderItemId());
	}

	@Override
	public CPDefinition getCPDefinition() throws PortalException {
		CPInstance cpInstance = getCPInstance();

		return cpInstance.getCPDefinition();
	}

	@Override
	public long getCPDefinitionId() throws PortalException {
		CPInstance cpInstance = getCPInstance();

		return cpInstance.getCPDefinitionId();
	}

	@Override
	public CPInstance getCPInstance() throws PortalException {
		return CPInstanceLocalServiceUtil.getCPInstance(getCPInstanceId());
	}

}