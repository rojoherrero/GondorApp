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

package org.rojoherrero.gondor.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Drug. This utility wraps
 * {@link org.rojoherrero.gondor.service.impl.DrugLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DrugLocalService
 * @see org.rojoherrero.gondor.service.base.DrugLocalServiceBaseImpl
 * @see org.rojoherrero.gondor.service.impl.DrugLocalServiceImpl
 * @generated
 */
@ProviderType
public class DrugLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.rojoherrero.gondor.service.impl.DrugLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of drugs.
	*
	* @return the number of drugs
	*/
	public static int getDrugsCount() {
		return getService().getDrugsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.rojoherrero.gondor.model.impl.DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.rojoherrero.gondor.model.impl.DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the drugs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.rojoherrero.gondor.model.impl.DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @return the range of drugs
	*/
	public static java.util.List<org.rojoherrero.gondor.model.Drug> getDrugs(
		int start, int end) {
		return getService().getDrugs(start, end);
	}

	/**
	* Returns all the drugs matching the UUID and company.
	*
	* @param uuid the UUID of the drugs
	* @param companyId the primary key of the company
	* @return the matching drugs, or an empty list if no matches were found
	*/
	public static java.util.List<org.rojoherrero.gondor.model.Drug> getDrugsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getDrugsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of drugs matching the UUID and company.
	*
	* @param uuid the UUID of the drugs
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching drugs, or an empty list if no matches were found
	*/
	public static java.util.List<org.rojoherrero.gondor.model.Drug> getDrugsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<org.rojoherrero.gondor.model.Drug> orderByComparator) {
		return getService()
				   .getDrugsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
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

	/**
	* Adds the drug to the database. Also notifies the appropriate model listeners.
	*
	* @param drug the drug
	* @return the drug that was added
	*/
	public static org.rojoherrero.gondor.model.Drug addDrug(
		org.rojoherrero.gondor.model.Drug drug) {
		return getService().addDrug(drug);
	}

	/**
	* Creates a new drug with the primary key. Does not add the drug to the database.
	*
	* @param drugId the primary key for the new drug
	* @return the new drug
	*/
	public static org.rojoherrero.gondor.model.Drug createDrug(long drugId) {
		return getService().createDrug(drugId);
	}

	/**
	* Deletes the drug with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param drugId the primary key of the drug
	* @return the drug that was removed
	* @throws PortalException if a drug with the primary key could not be found
	*/
	public static org.rojoherrero.gondor.model.Drug deleteDrug(long drugId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteDrug(drugId);
	}

	/**
	* Deletes the drug from the database. Also notifies the appropriate model listeners.
	*
	* @param drug the drug
	* @return the drug that was removed
	*/
	public static org.rojoherrero.gondor.model.Drug deleteDrug(
		org.rojoherrero.gondor.model.Drug drug) {
		return getService().deleteDrug(drug);
	}

	public static org.rojoherrero.gondor.model.Drug fetchDrug(long drugId) {
		return getService().fetchDrug(drugId);
	}

	/**
	* Returns the drug matching the UUID and group.
	*
	* @param uuid the drug's UUID
	* @param groupId the primary key of the group
	* @return the matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public static org.rojoherrero.gondor.model.Drug fetchDrugByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchDrugByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the drug with the primary key.
	*
	* @param drugId the primary key of the drug
	* @return the drug
	* @throws PortalException if a drug with the primary key could not be found
	*/
	public static org.rojoherrero.gondor.model.Drug getDrug(long drugId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDrug(drugId);
	}

	/**
	* Returns the drug matching the UUID and group.
	*
	* @param uuid the drug's UUID
	* @param groupId the primary key of the group
	* @return the matching drug
	* @throws PortalException if a matching drug could not be found
	*/
	public static org.rojoherrero.gondor.model.Drug getDrugByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDrugByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the drug in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param drug the drug
	* @return the drug that was updated
	*/
	public static org.rojoherrero.gondor.model.Drug updateDrug(
		org.rojoherrero.gondor.model.Drug drug) {
		return getService().updateDrug(drug);
	}

	public static DrugLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DrugLocalService, DrugLocalService> _serviceTracker =
		ServiceTrackerFactory.open(DrugLocalService.class);
}