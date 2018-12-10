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

package com.liferay.commerce.cart.taglib.servlet.taglib;

import com.liferay.commerce.cart.taglib.servlet.taglib.internal.js.loader.modules.extender.npm.NPMResolverProvider;
import com.liferay.commerce.cart.taglib.servlet.taglib.internal.servlet.ServletContextUtil;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.order.CommerceOrderHelper;
import com.liferay.commerce.order.CommerceOrderHttpHelper;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.frontend.taglib.soy.servlet.taglib.ComponentRendererTag;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.jsp.PageContext;

/**
 * @author Marco Leo
 */
public class MiniCartTag extends ComponentRendererTag {

	@Override
	public int doStartTag() {
		CommerceContext commerceContext = (CommerceContext)request.getAttribute(
			CommerceWebKeys.COMMERCE_CONTEXT);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			CommerceOrder commerceOrder = commerceContext.getCommerceOrder();

			String portalURL = PortalUtil.getPortalURL(request);

			putValue("isOpen", false);
			putValue("isDisabled", false);

			PortletURL commerceCartPortletURL =
				commerceOrderHttpHelper.getCommerceCartPortletURL(request);

			putValue("detailsUrl", commerceCartPortletURL.toString());

			List<ObjectValuePair<Long, String>> workflowTransitions =
				commerceOrderHelper.getWorkflowTransitions(
					themeDisplay.getUserId(), commerceOrder);

			if (workflowTransitions.isEmpty()) {
				PortletURL commerceCheckoutPortletURL =
					commerceOrderHttpHelper.getCommerceCheckoutPortletURL(
						request);

				putValue("checkoutUrl", commerceCheckoutPortletURL.toString());
			}

			putValue("productsCount", 0);
			putValue("cartAPI", portalURL + "/o/commerce-cart");

			if (commerceOrder != null) {
				putValue("cartId", commerceOrder.getCommerceOrderId());
			}

			putValue("products", new ArrayList<>());
			putValue(
				"spritemap",
				themeDisplay.getPathThemeImages() + "/commerce-icons.svg");

			setTemplateNamespace("Cart.render");
		}
		catch (PortalException pe) {
			if (_log.isDebugEnabled()) {
				_log.debug(pe, pe);
			}

			return SKIP_BODY;
		}

		return super.doStartTag();
	}

	@Override
	public String getModule() {
		NPMResolver npmResolver = NPMResolverProvider.getNPMResolver();

		if (npmResolver == null) {
			return StringPool.BLANK;
		}

		return npmResolver.resolveModuleName(
			"commerce-cart-taglib/mini_cart/Cart.es");
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		commerceOrderHelper = ServletContextUtil.getCommerceOrderHelper();
		commerceOrderHttpHelper =
			ServletContextUtil.getCommerceOrderHttpHelper();
	}

	protected CommerceOrderHelper commerceOrderHelper;
	protected CommerceOrderHttpHelper commerceOrderHttpHelper;

	private static final Log _log = LogFactoryUtil.getLog(MiniCartTag.class);

}