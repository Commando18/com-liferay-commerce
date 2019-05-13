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

package com.liferay.commerce.inventory.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CommerceInventoryWarehouseItem. This utility wraps
 * {@link com.liferay.commerce.inventory.service.impl.CommerceInventoryWarehouseItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Luca Pellizzon
 * @see CommerceInventoryWarehouseItemLocalService
 * @see com.liferay.commerce.inventory.service.base.CommerceInventoryWarehouseItemLocalServiceBaseImpl
 * @see com.liferay.commerce.inventory.service.impl.CommerceInventoryWarehouseItemLocalServiceImpl
 * @generated
 */
@ProviderType
public class CommerceInventoryWarehouseItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.commerce.inventory.service.impl.CommerceInventoryWarehouseItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the commerce inventory warehouse item to the database. Also notifies the appropriate model listeners.
	*
	* @param commerceInventoryWarehouseItem the commerce inventory warehouse item
	* @return the commerce inventory warehouse item that was added
	*/
	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem addCommerceInventoryWarehouseItem(
		com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem commerceInventoryWarehouseItem) {
		return getService()
				   .addCommerceInventoryWarehouseItem(commerceInventoryWarehouseItem);
	}

	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem addCommerceWarehouseItem(
		long commerceWarehouseId, String sku, int quantity, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCommerceWarehouseItem(commerceWarehouseId, sku,
			quantity, userId);
	}

	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem addStockQuantity(
		long commerceWarehouseItemId, int quantity)
		throws com.liferay.commerce.inventory.exception.NoSuchInventoryWarehouseItemException {
		return getService().addStockQuantity(commerceWarehouseItemId, quantity);
	}

	/**
	* Creates a new commerce inventory warehouse item with the primary key. Does not add the commerce inventory warehouse item to the database.
	*
	* @param commerceInventoryWarehouseItemId the primary key for the new commerce inventory warehouse item
	* @return the new commerce inventory warehouse item
	*/
	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem createCommerceInventoryWarehouseItem(
		long commerceInventoryWarehouseItemId) {
		return getService()
				   .createCommerceInventoryWarehouseItem(commerceInventoryWarehouseItemId);
	}

	/**
	* Deletes the commerce inventory warehouse item from the database. Also notifies the appropriate model listeners.
	*
	* @param commerceInventoryWarehouseItem the commerce inventory warehouse item
	* @return the commerce inventory warehouse item that was removed
	*/
	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem deleteCommerceInventoryWarehouseItem(
		com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem commerceInventoryWarehouseItem) {
		return getService()
				   .deleteCommerceInventoryWarehouseItem(commerceInventoryWarehouseItem);
	}

	/**
	* Deletes the commerce inventory warehouse item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commerceInventoryWarehouseItemId the primary key of the commerce inventory warehouse item
	* @return the commerce inventory warehouse item that was removed
	* @throws PortalException if a commerce inventory warehouse item with the primary key could not be found
	*/
	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem deleteCommerceInventoryWarehouseItem(
		long commerceInventoryWarehouseItemId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteCommerceInventoryWarehouseItem(commerceInventoryWarehouseItemId);
	}

	public static void deleteCommerceWarehouseItems(long commerceWarehouseId) {
		getService().deleteCommerceWarehouseItems(commerceWarehouseId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem fetchCommerceInventoryWarehouseItem(
		long commerceInventoryWarehouseItemId) {
		return getService()
				   .fetchCommerceInventoryWarehouseItem(commerceInventoryWarehouseItemId);
	}

	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem fetchCommerceWarehouseItem(
		long commerceWarehouseId, String sku) {
		return getService().fetchCommerceWarehouseItem(commerceWarehouseId, sku);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the commerce inventory warehouse item with the primary key.
	*
	* @param commerceInventoryWarehouseItemId the primary key of the commerce inventory warehouse item
	* @return the commerce inventory warehouse item
	* @throws PortalException if a commerce inventory warehouse item with the primary key could not be found
	*/
	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem getCommerceInventoryWarehouseItem(
		long commerceInventoryWarehouseItemId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getCommerceInventoryWarehouseItem(commerceInventoryWarehouseItemId);
	}

	/**
	* Returns a range of all the commerce inventory warehouse items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of commerce inventory warehouse items
	* @param end the upper bound of the range of commerce inventory warehouse items (not inclusive)
	* @return the range of commerce inventory warehouse items
	*/
	public static java.util.List<com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem> getCommerceInventoryWarehouseItems(
		int start, int end) {
		return getService().getCommerceInventoryWarehouseItems(start, end);
	}

	/**
	* Returns the number of commerce inventory warehouse items.
	*
	* @return the number of commerce inventory warehouse items
	*/
	public static int getCommerceInventoryWarehouseItemsCount() {
		return getService().getCommerceInventoryWarehouseItemsCount();
	}

	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem getCommerceWarehouseItem(
		long commerceWarehouseId, String sku)
		throws com.liferay.commerce.inventory.exception.NoSuchInventoryWarehouseItemException {
		return getService().getCommerceWarehouseItem(commerceWarehouseId, sku);
	}

	public static java.util.List<com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem> getCommerceWarehouseItems(
		String sku) {
		return getService().getCommerceWarehouseItems(sku);
	}

	public static java.util.List<com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem> getCommerceWarehouseItemsByCommerceWarehouseId(
		long commerceWarehouseId) {
		return getService()
				   .getCommerceWarehouseItemsByCommerceWarehouseId(commerceWarehouseId);
	}

	public static int getCommerceWarehouseItemsCount(String sku) {
		return getService().getCommerceWarehouseItemsCount(sku);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int getStockQuantityByGroupIdAndSku(long companyId,
		long groupId, String sku) {
		return getService()
				   .getStockQuantityByGroupIdAndSku(companyId, groupId, sku);
	}

	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem removeStockQuantity(
		long commerceWarehouseItemId, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .removeStockQuantity(commerceWarehouseItemId, quantity);
	}

	/**
	* Updates the commerce inventory warehouse item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commerceInventoryWarehouseItem the commerce inventory warehouse item
	* @return the commerce inventory warehouse item that was updated
	*/
	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem updateCommerceInventoryWarehouseItem(
		com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem commerceInventoryWarehouseItem) {
		return getService()
				   .updateCommerceInventoryWarehouseItem(commerceInventoryWarehouseItem);
	}

	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem updateCommerceWarehouseItem(
		long commerceWarehouseItemId, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateCommerceWarehouseItem(commerceWarehouseItemId,
			quantity);
	}

	public static CommerceInventoryWarehouseItemLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CommerceInventoryWarehouseItemLocalService, CommerceInventoryWarehouseItemLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CommerceInventoryWarehouseItemLocalService.class);

		ServiceTracker<CommerceInventoryWarehouseItemLocalService, CommerceInventoryWarehouseItemLocalService> serviceTracker =
			new ServiceTracker<CommerceInventoryWarehouseItemLocalService, CommerceInventoryWarehouseItemLocalService>(bundle.getBundleContext(),
				CommerceInventoryWarehouseItemLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}