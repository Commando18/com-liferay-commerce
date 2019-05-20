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

package com.liferay.commerce.order.content.web.internal.frontend.util;

import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.currency.model.CommerceMoney;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.order.CommerceOrderHelper;
import com.liferay.commerce.order.content.web.internal.model.Order;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletQName;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.text.DateFormat;
import java.text.Format;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Alessio Antonio Rendina
 */
public class CommerceOrderClayTableUtil {

	public static String getOrderDetailURL(
			long commerceOrderId, CommerceOrderHelper commerceOrderHelper,
			ThemeDisplay themeDisplay)
		throws PortalException {

		String friendlyURL = commerceOrderHelper.getFriendlyURL(
			commerceOrderId, themeDisplay);

		StringBundler sb = new StringBundler(5);

		sb.append(friendlyURL);
		sb.append(CharPool.QUESTION);
		sb.append(PortletQName.PUBLIC_RENDER_PARAMETER_NAMESPACE);
		sb.append("backURL=");
		sb.append(themeDisplay.getURLCurrent());

		return sb.toString();
	}

	public static List<Order> getOrders(
			List<CommerceOrder> commerceOrders,
			CommerceOrderHelper commerceOrderHelper, ThemeDisplay themeDisplay)
		throws PortalException {

		List<Order> orders = new ArrayList<>();

		for (CommerceOrder commerceOrder : commerceOrders) {
			String amount = StringPool.BLANK;

			CommerceMoney totalMoney = commerceOrder.getTotalMoney();

			if (totalMoney != null) {
				amount = totalMoney.format(themeDisplay.getLocale());
			}

			Format dateFormat = FastDateFormatFactoryUtil.getDate(
				DateFormat.MEDIUM, themeDisplay.getLocale(),
				themeDisplay.getTimeZone());

			ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", themeDisplay.getLocale(),
				CommerceOrderClayTableUtil.class);

			String commerceOrderStatusLabel = LanguageUtil.get(
				resourceBundle,
				CommerceOrderConstants.getOrderStatusLabel(
					commerceOrder.getOrderStatus()));

			String workflowStatusLabel = LanguageUtil.get(
				resourceBundle,
				WorkflowConstants.getStatusLabel(commerceOrder.getStatus()));

			orders.add(
				new Order(
					commerceOrder.getCommerceOrderId(),
					commerceOrder.getCommerceAccountName(),
					dateFormat.format(commerceOrder.getCreateDate()),
					commerceOrder.getUserName(), commerceOrderStatusLabel,
					workflowStatusLabel, amount,
					getOrderDetailURL(
						commerceOrder.getCommerceOrderId(), commerceOrderHelper,
						themeDisplay)));
		}

		return orders;
	}

	public static String getViewShipmentURL(
			long commerceOrderItemId, ThemeDisplay themeDisplay)
		throws Exception {

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		PortletURL portletURL = PortletURLFactoryUtil.create(
			themeDisplay.getRequest(), portletDisplay.getId(),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcRenderCommandName", "viewCommerceOrderShipments");
		portletURL.setParameter(
			"commerceOrderItemId", String.valueOf(commerceOrderItemId));
		portletURL.setWindowState(LiferayWindowState.POP_UP);

		portletURL.setParameter(
			PortletQName.PUBLIC_RENDER_PARAMETER_NAMESPACE + "backURL",
			themeDisplay.getURLCurrent());

		return portletURL.toString();
	}

}