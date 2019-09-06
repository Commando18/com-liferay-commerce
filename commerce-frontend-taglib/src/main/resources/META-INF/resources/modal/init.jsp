<%--
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
--%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %>

<liferay-theme:defineObjects />

<%
	String url = (String)request.getAttribute("liferay-commerce:modal:url");
	String size = (String)request.getAttribute("liferay-commerce:modal:size");
	String title = (String)request.getAttribute("liferay-commerce:modal:title");
	String spritemap = (String)request.getAttribute("liferay-commerce:modal:spritemap");
	String triggerId = (String)request.getAttribute("liferay-commerce:modal:triggerId");
	Boolean showSubmit = (Boolean)request.getAttribute("liferay-commerce:modal:showSubmit");
	String submitLabel = (String)request.getAttribute("liferay-commerce:modal:submitLabel");
	Boolean closeOnSubmit = (Boolean)request.getAttribute("liferay-commerce:modal:closeOnSubmit");
	Boolean submitAvailableAtLoading = (Boolean)request.getAttribute("liferay-commerce:modal:submitAvailableAtLoading");
	Boolean showDelete = (Boolean)request.getAttribute("liferay-commerce:modal:showDelete");
	String deleteLabel = (String)request.getAttribute("liferay-commerce:modal:deleteLabel");
	Boolean showCancel = (Boolean)request.getAttribute("liferay-commerce:modal:showCancel");
	String cancelLabel = (String)request.getAttribute("liferay-commerce:modal:cancelLabel");
	String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_modal") + StringPool.UNDERLINE;

	String modalId = randomNamespace + "modal-root";
%>