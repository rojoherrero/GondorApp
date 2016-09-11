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

package org.rojoherrero.gondor.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import org.rojoherrero.gondor.model.Drug;

import java.util.List;

/**
 * The persistence utility for the drug service. This utility wraps {@link org.rojoherrero.gondor.service.persistence.impl.DrugPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DrugPersistence
 * @see org.rojoherrero.gondor.service.persistence.impl.DrugPersistenceImpl
 * @generated
 */
@ProviderType
public class DrugUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Drug drug) {
		getPersistence().clearCache(drug);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Drug> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Drug> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Drug> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Drug> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Drug update(Drug drug) {
		return getPersistence().update(drug);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Drug update(Drug drug, ServiceContext serviceContext) {
		return getPersistence().update(drug, serviceContext);
	}

	/**
	* Returns all the drugs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching drugs
	*/
	public static List<Drug> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the drugs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @return the range of matching drugs
	*/
	public static List<Drug> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the drugs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching drugs
	*/
	public static List<Drug> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Drug> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the drugs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching drugs
	*/
	public static List<Drug> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Drug> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first drug in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public static Drug findByUuid_First(java.lang.String uuid,
		OrderByComparator<Drug> orderByComparator)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first drug in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public static Drug fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Drug> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last drug in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public static Drug findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Drug> orderByComparator)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last drug in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public static Drug fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Drug> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the drugs before and after the current drug in the ordered set where uuid = &#63;.
	*
	* @param drugId the primary key of the current drug
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next drug
	* @throws NoSuchDrugException if a drug with the primary key could not be found
	*/
	public static Drug[] findByUuid_PrevAndNext(long drugId,
		java.lang.String uuid, OrderByComparator<Drug> orderByComparator)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence()
				   .findByUuid_PrevAndNext(drugId, uuid, orderByComparator);
	}

	/**
	* Removes all the drugs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of drugs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching drugs
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the drug where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDrugException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public static Drug findByUUID_G(java.lang.String uuid, long groupId)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the drug where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public static Drug fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the drug where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public static Drug fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the drug where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the drug that was removed
	*/
	public static Drug removeByUUID_G(java.lang.String uuid, long groupId)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of drugs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching drugs
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the drugs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching drugs
	*/
	public static List<Drug> findByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the drugs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @return the range of matching drugs
	*/
	public static List<Drug> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the drugs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching drugs
	*/
	public static List<Drug> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Drug> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the drugs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching drugs
	*/
	public static List<Drug> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Drug> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first drug in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public static Drug findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Drug> orderByComparator)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first drug in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public static Drug fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Drug> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last drug in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public static Drug findByUuid_C_Last(java.lang.String uuid, long companyId,
		OrderByComparator<Drug> orderByComparator)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last drug in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public static Drug fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Drug> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the drugs before and after the current drug in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param drugId the primary key of the current drug
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next drug
	* @throws NoSuchDrugException if a drug with the primary key could not be found
	*/
	public static Drug[] findByUuid_C_PrevAndNext(long drugId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Drug> orderByComparator)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(drugId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the drugs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of drugs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching drugs
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the drugs where drugType = &#63;.
	*
	* @param drugType the drug type
	* @return the matching drugs
	*/
	public static List<Drug> findBydrugType(java.lang.String drugType) {
		return getPersistence().findBydrugType(drugType);
	}

	/**
	* Returns a range of all the drugs where drugType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param drugType the drug type
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @return the range of matching drugs
	*/
	public static List<Drug> findBydrugType(java.lang.String drugType,
		int start, int end) {
		return getPersistence().findBydrugType(drugType, start, end);
	}

	/**
	* Returns an ordered range of all the drugs where drugType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param drugType the drug type
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching drugs
	*/
	public static List<Drug> findBydrugType(java.lang.String drugType,
		int start, int end, OrderByComparator<Drug> orderByComparator) {
		return getPersistence()
				   .findBydrugType(drugType, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the drugs where drugType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param drugType the drug type
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching drugs
	*/
	public static List<Drug> findBydrugType(java.lang.String drugType,
		int start, int end, OrderByComparator<Drug> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBydrugType(drugType, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first drug in the ordered set where drugType = &#63;.
	*
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public static Drug findBydrugType_First(java.lang.String drugType,
		OrderByComparator<Drug> orderByComparator)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence().findBydrugType_First(drugType, orderByComparator);
	}

	/**
	* Returns the first drug in the ordered set where drugType = &#63;.
	*
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public static Drug fetchBydrugType_First(java.lang.String drugType,
		OrderByComparator<Drug> orderByComparator) {
		return getPersistence()
				   .fetchBydrugType_First(drugType, orderByComparator);
	}

	/**
	* Returns the last drug in the ordered set where drugType = &#63;.
	*
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public static Drug findBydrugType_Last(java.lang.String drugType,
		OrderByComparator<Drug> orderByComparator)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence().findBydrugType_Last(drugType, orderByComparator);
	}

	/**
	* Returns the last drug in the ordered set where drugType = &#63;.
	*
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public static Drug fetchBydrugType_Last(java.lang.String drugType,
		OrderByComparator<Drug> orderByComparator) {
		return getPersistence().fetchBydrugType_Last(drugType, orderByComparator);
	}

	/**
	* Returns the drugs before and after the current drug in the ordered set where drugType = &#63;.
	*
	* @param drugId the primary key of the current drug
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next drug
	* @throws NoSuchDrugException if a drug with the primary key could not be found
	*/
	public static Drug[] findBydrugType_PrevAndNext(long drugId,
		java.lang.String drugType, OrderByComparator<Drug> orderByComparator)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence()
				   .findBydrugType_PrevAndNext(drugId, drugType,
			orderByComparator);
	}

	/**
	* Removes all the drugs where drugType = &#63; from the database.
	*
	* @param drugType the drug type
	*/
	public static void removeBydrugType(java.lang.String drugType) {
		getPersistence().removeBydrugType(drugType);
	}

	/**
	* Returns the number of drugs where drugType = &#63;.
	*
	* @param drugType the drug type
	* @return the number of matching drugs
	*/
	public static int countBydrugType(java.lang.String drugType) {
		return getPersistence().countBydrugType(drugType);
	}

	/**
	* Caches the drug in the entity cache if it is enabled.
	*
	* @param drug the drug
	*/
	public static void cacheResult(Drug drug) {
		getPersistence().cacheResult(drug);
	}

	/**
	* Caches the drugs in the entity cache if it is enabled.
	*
	* @param drugs the drugs
	*/
	public static void cacheResult(List<Drug> drugs) {
		getPersistence().cacheResult(drugs);
	}

	/**
	* Creates a new drug with the primary key. Does not add the drug to the database.
	*
	* @param drugId the primary key for the new drug
	* @return the new drug
	*/
	public static Drug create(long drugId) {
		return getPersistence().create(drugId);
	}

	/**
	* Removes the drug with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param drugId the primary key of the drug
	* @return the drug that was removed
	* @throws NoSuchDrugException if a drug with the primary key could not be found
	*/
	public static Drug remove(long drugId)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence().remove(drugId);
	}

	public static Drug updateImpl(Drug drug) {
		return getPersistence().updateImpl(drug);
	}

	/**
	* Returns the drug with the primary key or throws a {@link NoSuchDrugException} if it could not be found.
	*
	* @param drugId the primary key of the drug
	* @return the drug
	* @throws NoSuchDrugException if a drug with the primary key could not be found
	*/
	public static Drug findByPrimaryKey(long drugId)
		throws org.rojoherrero.gondor.exception.NoSuchDrugException {
		return getPersistence().findByPrimaryKey(drugId);
	}

	/**
	* Returns the drug with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param drugId the primary key of the drug
	* @return the drug, or <code>null</code> if a drug with the primary key could not be found
	*/
	public static Drug fetchByPrimaryKey(long drugId) {
		return getPersistence().fetchByPrimaryKey(drugId);
	}

	public static java.util.Map<java.io.Serializable, Drug> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the drugs.
	*
	* @return the drugs
	*/
	public static List<Drug> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the drugs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @return the range of drugs
	*/
	public static List<Drug> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the drugs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of drugs
	*/
	public static List<Drug> findAll(int start, int end,
		OrderByComparator<Drug> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the drugs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DrugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of drugs
	* @param end the upper bound of the range of drugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of drugs
	*/
	public static List<Drug> findAll(int start, int end,
		OrderByComparator<Drug> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the drugs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of drugs.
	*
	* @return the number of drugs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DrugPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DrugPersistence, DrugPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DrugPersistence.class);
}