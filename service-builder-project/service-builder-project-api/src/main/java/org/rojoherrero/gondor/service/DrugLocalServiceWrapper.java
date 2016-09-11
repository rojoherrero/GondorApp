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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DrugLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DrugLocalService
 * @generated
 */
@ProviderType
public class DrugLocalServiceWrapper implements DrugLocalService,
	ServiceWrapper<DrugLocalService> {
	public DrugLocalServiceWrapper(DrugLocalService drugLocalService) {
		_drugLocalService = drugLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _drugLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _drugLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _drugLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _drugLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _drugLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _drugLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of drugs.
	*
	* @return the number of drugs
	*/
	@Override
	public int getDrugsCount() {
		return _drugLocalService.getDrugsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _drugLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _drugLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _drugLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _drugLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<org.rojoherrero.gondor.model.Drug> getDrugs(
		int start, int end) {
		return _drugLocalService.getDrugs(start, end);
	}

	/**
	* Returns all the drugs matching the UUID and company.
	*
	* @param uuid the UUID of the drugs
	* @param companyId the primary key of the company
	* @return the matching drugs, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<org.rojoherrero.gondor.model.Drug> getDrugsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _drugLocalService.getDrugsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<org.rojoherrero.gondor.model.Drug> getDrugsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<org.rojoherrero.gondor.model.Drug> orderByComparator) {
		return _drugLocalService.getDrugsByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _drugLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _drugLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the drug to the database. Also notifies the appropriate model listeners.
	*
	* @param drug the drug
	* @return the drug that was added
	*/
	@Override
	public org.rojoherrero.gondor.model.Drug addDrug(
		org.rojoherrero.gondor.model.Drug drug) {
		return _drugLocalService.addDrug(drug);
	}

	/**
	* Creates a new drug with the primary key. Does not add the drug to the database.
	*
	* @param drugId the primary key for the new drug
	* @return the new drug
	*/
	@Override
	public org.rojoherrero.gondor.model.Drug createDrug(long drugId) {
		return _drugLocalService.createDrug(drugId);
	}

	/**
	* Deletes the drug with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param drugId the primary key of the drug
	* @return the drug that was removed
	* @throws PortalException if a drug with the primary key could not be found
	*/
	@Override
	public org.rojoherrero.gondor.model.Drug deleteDrug(long drugId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _drugLocalService.deleteDrug(drugId);
	}

	/**
	* Deletes the drug from the database. Also notifies the appropriate model listeners.
	*
	* @param drug the drug
	* @return the drug that was removed
	*/
	@Override
	public org.rojoherrero.gondor.model.Drug deleteDrug(
		org.rojoherrero.gondor.model.Drug drug) {
		return _drugLocalService.deleteDrug(drug);
	}

	@Override
	public org.rojoherrero.gondor.model.Drug fetchDrug(long drugId) {
		return _drugLocalService.fetchDrug(drugId);
	}

	/**
	* Returns the drug matching the UUID and group.
	*
	* @param uuid the drug's UUID
	* @param groupId the primary key of the group
	* @return the matching drug, or <code>null</code> if a matching drug could not be found
	*/
	@Override
	public org.rojoherrero.gondor.model.Drug fetchDrugByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _drugLocalService.fetchDrugByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the drug with the primary key.
	*
	* @param drugId the primary key of the drug
	* @return the drug
	* @throws PortalException if a drug with the primary key could not be found
	*/
	@Override
	public org.rojoherrero.gondor.model.Drug getDrug(long drugId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _drugLocalService.getDrug(drugId);
	}

	/**
	* Returns the drug matching the UUID and group.
	*
	* @param uuid the drug's UUID
	* @param groupId the primary key of the group
	* @return the matching drug
	* @throws PortalException if a matching drug could not be found
	*/
	@Override
	public org.rojoherrero.gondor.model.Drug getDrugByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _drugLocalService.getDrugByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the drug in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param drug the drug
	* @return the drug that was updated
	*/
	@Override
	public org.rojoherrero.gondor.model.Drug updateDrug(
		org.rojoherrero.gondor.model.Drug drug) {
		return _drugLocalService.updateDrug(drug);
	}

	@Override
	public DrugLocalService getWrappedService() {
		return _drugLocalService;
	}

	@Override
	public void setWrappedService(DrugLocalService drugLocalService) {
		_drugLocalService = drugLocalService;
	}

	private DrugLocalService _drugLocalService;
}