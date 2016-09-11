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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.rojoherrero.gondor.exception.NoSuchDrugException;
import org.rojoherrero.gondor.model.Drug;

/**
 * The persistence interface for the drug service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.rojoherrero.gondor.service.persistence.impl.DrugPersistenceImpl
 * @see DrugUtil
 * @generated
 */
@ProviderType
public interface DrugPersistence extends BasePersistence<Drug> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DrugUtil} to access the drug persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the drugs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching drugs
	*/
	public java.util.List<Drug> findByUuid(java.lang.String uuid);

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
	public java.util.List<Drug> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Drug> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

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
	public java.util.List<Drug> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first drug in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public Drug findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException;

	/**
	* Returns the first drug in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public Drug fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

	/**
	* Returns the last drug in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public Drug findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException;

	/**
	* Returns the last drug in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public Drug fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

	/**
	* Returns the drugs before and after the current drug in the ordered set where uuid = &#63;.
	*
	* @param drugId the primary key of the current drug
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next drug
	* @throws NoSuchDrugException if a drug with the primary key could not be found
	*/
	public Drug[] findByUuid_PrevAndNext(long drugId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException;

	/**
	* Removes all the drugs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of drugs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching drugs
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the drug where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDrugException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public Drug findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchDrugException;

	/**
	* Returns the drug where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public Drug fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the drug where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public Drug fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the drug where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the drug that was removed
	*/
	public Drug removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchDrugException;

	/**
	* Returns the number of drugs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching drugs
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the drugs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching drugs
	*/
	public java.util.List<Drug> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Drug> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Drug> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

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
	public java.util.List<Drug> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first drug in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public Drug findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException;

	/**
	* Returns the first drug in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public Drug fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

	/**
	* Returns the last drug in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public Drug findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException;

	/**
	* Returns the last drug in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public Drug fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

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
	public Drug[] findByUuid_C_PrevAndNext(long drugId, java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException;

	/**
	* Removes all the drugs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of drugs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching drugs
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the drugs where drugType = &#63;.
	*
	* @param drugType the drug type
	* @return the matching drugs
	*/
	public java.util.List<Drug> findBydrugType(java.lang.String drugType);

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
	public java.util.List<Drug> findBydrugType(java.lang.String drugType,
		int start, int end);

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
	public java.util.List<Drug> findBydrugType(java.lang.String drugType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

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
	public java.util.List<Drug> findBydrugType(java.lang.String drugType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first drug in the ordered set where drugType = &#63;.
	*
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public Drug findBydrugType_First(java.lang.String drugType,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException;

	/**
	* Returns the first drug in the ordered set where drugType = &#63;.
	*
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public Drug fetchBydrugType_First(java.lang.String drugType,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

	/**
	* Returns the last drug in the ordered set where drugType = &#63;.
	*
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug
	* @throws NoSuchDrugException if a matching drug could not be found
	*/
	public Drug findBydrugType_Last(java.lang.String drugType,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException;

	/**
	* Returns the last drug in the ordered set where drugType = &#63;.
	*
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drug, or <code>null</code> if a matching drug could not be found
	*/
	public Drug fetchBydrugType_Last(java.lang.String drugType,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

	/**
	* Returns the drugs before and after the current drug in the ordered set where drugType = &#63;.
	*
	* @param drugId the primary key of the current drug
	* @param drugType the drug type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next drug
	* @throws NoSuchDrugException if a drug with the primary key could not be found
	*/
	public Drug[] findBydrugType_PrevAndNext(long drugId,
		java.lang.String drugType,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException;

	/**
	* Removes all the drugs where drugType = &#63; from the database.
	*
	* @param drugType the drug type
	*/
	public void removeBydrugType(java.lang.String drugType);

	/**
	* Returns the number of drugs where drugType = &#63;.
	*
	* @param drugType the drug type
	* @return the number of matching drugs
	*/
	public int countBydrugType(java.lang.String drugType);

	/**
	* Caches the drug in the entity cache if it is enabled.
	*
	* @param drug the drug
	*/
	public void cacheResult(Drug drug);

	/**
	* Caches the drugs in the entity cache if it is enabled.
	*
	* @param drugs the drugs
	*/
	public void cacheResult(java.util.List<Drug> drugs);

	/**
	* Creates a new drug with the primary key. Does not add the drug to the database.
	*
	* @param drugId the primary key for the new drug
	* @return the new drug
	*/
	public Drug create(long drugId);

	/**
	* Removes the drug with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param drugId the primary key of the drug
	* @return the drug that was removed
	* @throws NoSuchDrugException if a drug with the primary key could not be found
	*/
	public Drug remove(long drugId) throws NoSuchDrugException;

	public Drug updateImpl(Drug drug);

	/**
	* Returns the drug with the primary key or throws a {@link NoSuchDrugException} if it could not be found.
	*
	* @param drugId the primary key of the drug
	* @return the drug
	* @throws NoSuchDrugException if a drug with the primary key could not be found
	*/
	public Drug findByPrimaryKey(long drugId) throws NoSuchDrugException;

	/**
	* Returns the drug with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param drugId the primary key of the drug
	* @return the drug, or <code>null</code> if a drug with the primary key could not be found
	*/
	public Drug fetchByPrimaryKey(long drugId);

	@Override
	public java.util.Map<java.io.Serializable, Drug> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the drugs.
	*
	* @return the drugs
	*/
	public java.util.List<Drug> findAll();

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
	public java.util.List<Drug> findAll(int start, int end);

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
	public java.util.List<Drug> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator);

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
	public java.util.List<Drug> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drug> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the drugs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of drugs.
	*
	* @return the number of drugs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}