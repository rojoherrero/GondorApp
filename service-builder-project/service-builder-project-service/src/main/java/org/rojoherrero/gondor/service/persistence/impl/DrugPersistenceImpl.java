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

package org.rojoherrero.gondor.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.rojoherrero.gondor.exception.NoSuchDrugException;
import org.rojoherrero.gondor.model.Drug;
import org.rojoherrero.gondor.model.impl.DrugImpl;
import org.rojoherrero.gondor.model.impl.DrugModelImpl;
import org.rojoherrero.gondor.service.persistence.DrugPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the drug service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DrugPersistence
 * @see org.rojoherrero.gondor.service.persistence.DrugUtil
 * @generated
 */
@ProviderType
public class DrugPersistenceImpl extends BasePersistenceImpl<Drug>
	implements DrugPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DrugUtil} to access the drug persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DrugImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, DrugImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, DrugImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, DrugImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, DrugImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DrugModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the drugs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching drugs
	 */
	@Override
	public List<Drug> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Drug> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Drug> findByUuid(String uuid, int start, int end,
		OrderByComparator<Drug> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Drug> findByUuid(String uuid, int start, int end,
		OrderByComparator<Drug> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Drug> list = null;

		if (retrieveFromCache) {
			list = (List<Drug>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Drug drug : list) {
					if (!Objects.equals(uuid, drug.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DRUG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DrugModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Drug>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Drug>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first drug in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drug
	 * @throws NoSuchDrugException if a matching drug could not be found
	 */
	@Override
	public Drug findByUuid_First(String uuid,
		OrderByComparator<Drug> orderByComparator) throws NoSuchDrugException {
		Drug drug = fetchByUuid_First(uuid, orderByComparator);

		if (drug != null) {
			return drug;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDrugException(msg.toString());
	}

	/**
	 * Returns the first drug in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drug, or <code>null</code> if a matching drug could not be found
	 */
	@Override
	public Drug fetchByUuid_First(String uuid,
		OrderByComparator<Drug> orderByComparator) {
		List<Drug> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last drug in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drug
	 * @throws NoSuchDrugException if a matching drug could not be found
	 */
	@Override
	public Drug findByUuid_Last(String uuid,
		OrderByComparator<Drug> orderByComparator) throws NoSuchDrugException {
		Drug drug = fetchByUuid_Last(uuid, orderByComparator);

		if (drug != null) {
			return drug;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDrugException(msg.toString());
	}

	/**
	 * Returns the last drug in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drug, or <code>null</code> if a matching drug could not be found
	 */
	@Override
	public Drug fetchByUuid_Last(String uuid,
		OrderByComparator<Drug> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Drug> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Drug[] findByUuid_PrevAndNext(long drugId, String uuid,
		OrderByComparator<Drug> orderByComparator) throws NoSuchDrugException {
		Drug drug = findByPrimaryKey(drugId);

		Session session = null;

		try {
			session = openSession();

			Drug[] array = new DrugImpl[3];

			array[0] = getByUuid_PrevAndNext(session, drug, uuid,
					orderByComparator, true);

			array[1] = drug;

			array[2] = getByUuid_PrevAndNext(session, drug, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Drug getByUuid_PrevAndNext(Session session, Drug drug,
		String uuid, OrderByComparator<Drug> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DRUG_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DrugModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(drug);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Drug> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drugs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Drug drug : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(drug);
		}
	}

	/**
	 * Returns the number of drugs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching drugs
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DRUG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "drug.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "drug.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(drug.uuid IS NULL OR drug.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, DrugImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			DrugModelImpl.UUID_COLUMN_BITMASK |
			DrugModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the drug where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDrugException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching drug
	 * @throws NoSuchDrugException if a matching drug could not be found
	 */
	@Override
	public Drug findByUUID_G(String uuid, long groupId)
		throws NoSuchDrugException {
		Drug drug = fetchByUUID_G(uuid, groupId);

		if (drug == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDrugException(msg.toString());
		}

		return drug;
	}

	/**
	 * Returns the drug where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching drug, or <code>null</code> if a matching drug could not be found
	 */
	@Override
	public Drug fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the drug where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching drug, or <code>null</code> if a matching drug could not be found
	 */
	@Override
	public Drug fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Drug) {
			Drug drug = (Drug)result;

			if (!Objects.equals(uuid, drug.getUuid()) ||
					(groupId != drug.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DRUG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Drug> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Drug drug = list.get(0);

					result = drug;

					cacheResult(drug);

					if ((drug.getUuid() == null) ||
							!drug.getUuid().equals(uuid) ||
							(drug.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, drug);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Drug)result;
		}
	}

	/**
	 * Removes the drug where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the drug that was removed
	 */
	@Override
	public Drug removeByUUID_G(String uuid, long groupId)
		throws NoSuchDrugException {
		Drug drug = findByUUID_G(uuid, groupId);

		return remove(drug);
	}

	/**
	 * Returns the number of drugs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching drugs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DRUG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "drug.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "drug.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(drug.uuid IS NULL OR drug.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "drug.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, DrugImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, DrugImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			DrugModelImpl.UUID_COLUMN_BITMASK |
			DrugModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the drugs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching drugs
	 */
	@Override
	public List<Drug> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Drug> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Drug> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Drug> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Drug> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Drug> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Drug> list = null;

		if (retrieveFromCache) {
			list = (List<Drug>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Drug drug : list) {
					if (!Objects.equals(uuid, drug.getUuid()) ||
							(companyId != drug.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DRUG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DrugModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Drug>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Drug>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Drug findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Drug> orderByComparator) throws NoSuchDrugException {
		Drug drug = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (drug != null) {
			return drug;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDrugException(msg.toString());
	}

	/**
	 * Returns the first drug in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drug, or <code>null</code> if a matching drug could not be found
	 */
	@Override
	public Drug fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Drug> orderByComparator) {
		List<Drug> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Drug findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Drug> orderByComparator) throws NoSuchDrugException {
		Drug drug = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (drug != null) {
			return drug;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDrugException(msg.toString());
	}

	/**
	 * Returns the last drug in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drug, or <code>null</code> if a matching drug could not be found
	 */
	@Override
	public Drug fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Drug> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Drug> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Drug[] findByUuid_C_PrevAndNext(long drugId, String uuid,
		long companyId, OrderByComparator<Drug> orderByComparator)
		throws NoSuchDrugException {
		Drug drug = findByPrimaryKey(drugId);

		Session session = null;

		try {
			session = openSession();

			Drug[] array = new DrugImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, drug, uuid, companyId,
					orderByComparator, true);

			array[1] = drug;

			array[2] = getByUuid_C_PrevAndNext(session, drug, uuid, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Drug getByUuid_C_PrevAndNext(Session session, Drug drug,
		String uuid, long companyId, OrderByComparator<Drug> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DRUG_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DrugModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(drug);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Drug> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drugs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Drug drug : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(drug);
		}
	}

	/**
	 * Returns the number of drugs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching drugs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DRUG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "drug.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "drug.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(drug.uuid IS NULL OR drug.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "drug.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DRUGTYPE = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, DrugImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydrugType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRUGTYPE =
		new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, DrugImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydrugType",
			new String[] { String.class.getName() },
			DrugModelImpl.DRUGTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DRUGTYPE = new FinderPath(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydrugType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the drugs where drugType = &#63;.
	 *
	 * @param drugType the drug type
	 * @return the matching drugs
	 */
	@Override
	public List<Drug> findBydrugType(String drugType) {
		return findBydrugType(drugType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Drug> findBydrugType(String drugType, int start, int end) {
		return findBydrugType(drugType, start, end, null);
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
	@Override
	public List<Drug> findBydrugType(String drugType, int start, int end,
		OrderByComparator<Drug> orderByComparator) {
		return findBydrugType(drugType, start, end, orderByComparator, true);
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
	@Override
	public List<Drug> findBydrugType(String drugType, int start, int end,
		OrderByComparator<Drug> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRUGTYPE;
			finderArgs = new Object[] { drugType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DRUGTYPE;
			finderArgs = new Object[] { drugType, start, end, orderByComparator };
		}

		List<Drug> list = null;

		if (retrieveFromCache) {
			list = (List<Drug>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Drug drug : list) {
					if (!Objects.equals(drugType, drug.getDrugType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DRUG_WHERE);

			boolean bindDrugType = false;

			if (drugType == null) {
				query.append(_FINDER_COLUMN_DRUGTYPE_DRUGTYPE_1);
			}
			else if (drugType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DRUGTYPE_DRUGTYPE_3);
			}
			else {
				bindDrugType = true;

				query.append(_FINDER_COLUMN_DRUGTYPE_DRUGTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DrugModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDrugType) {
					qPos.add(drugType);
				}

				if (!pagination) {
					list = (List<Drug>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Drug>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first drug in the ordered set where drugType = &#63;.
	 *
	 * @param drugType the drug type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drug
	 * @throws NoSuchDrugException if a matching drug could not be found
	 */
	@Override
	public Drug findBydrugType_First(String drugType,
		OrderByComparator<Drug> orderByComparator) throws NoSuchDrugException {
		Drug drug = fetchBydrugType_First(drugType, orderByComparator);

		if (drug != null) {
			return drug;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("drugType=");
		msg.append(drugType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDrugException(msg.toString());
	}

	/**
	 * Returns the first drug in the ordered set where drugType = &#63;.
	 *
	 * @param drugType the drug type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drug, or <code>null</code> if a matching drug could not be found
	 */
	@Override
	public Drug fetchBydrugType_First(String drugType,
		OrderByComparator<Drug> orderByComparator) {
		List<Drug> list = findBydrugType(drugType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last drug in the ordered set where drugType = &#63;.
	 *
	 * @param drugType the drug type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drug
	 * @throws NoSuchDrugException if a matching drug could not be found
	 */
	@Override
	public Drug findBydrugType_Last(String drugType,
		OrderByComparator<Drug> orderByComparator) throws NoSuchDrugException {
		Drug drug = fetchBydrugType_Last(drugType, orderByComparator);

		if (drug != null) {
			return drug;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("drugType=");
		msg.append(drugType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDrugException(msg.toString());
	}

	/**
	 * Returns the last drug in the ordered set where drugType = &#63;.
	 *
	 * @param drugType the drug type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drug, or <code>null</code> if a matching drug could not be found
	 */
	@Override
	public Drug fetchBydrugType_Last(String drugType,
		OrderByComparator<Drug> orderByComparator) {
		int count = countBydrugType(drugType);

		if (count == 0) {
			return null;
		}

		List<Drug> list = findBydrugType(drugType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Drug[] findBydrugType_PrevAndNext(long drugId, String drugType,
		OrderByComparator<Drug> orderByComparator) throws NoSuchDrugException {
		Drug drug = findByPrimaryKey(drugId);

		Session session = null;

		try {
			session = openSession();

			Drug[] array = new DrugImpl[3];

			array[0] = getBydrugType_PrevAndNext(session, drug, drugType,
					orderByComparator, true);

			array[1] = drug;

			array[2] = getBydrugType_PrevAndNext(session, drug, drugType,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Drug getBydrugType_PrevAndNext(Session session, Drug drug,
		String drugType, OrderByComparator<Drug> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DRUG_WHERE);

		boolean bindDrugType = false;

		if (drugType == null) {
			query.append(_FINDER_COLUMN_DRUGTYPE_DRUGTYPE_1);
		}
		else if (drugType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DRUGTYPE_DRUGTYPE_3);
		}
		else {
			bindDrugType = true;

			query.append(_FINDER_COLUMN_DRUGTYPE_DRUGTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DrugModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDrugType) {
			qPos.add(drugType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(drug);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Drug> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drugs where drugType = &#63; from the database.
	 *
	 * @param drugType the drug type
	 */
	@Override
	public void removeBydrugType(String drugType) {
		for (Drug drug : findBydrugType(drugType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(drug);
		}
	}

	/**
	 * Returns the number of drugs where drugType = &#63;.
	 *
	 * @param drugType the drug type
	 * @return the number of matching drugs
	 */
	@Override
	public int countBydrugType(String drugType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DRUGTYPE;

		Object[] finderArgs = new Object[] { drugType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DRUG_WHERE);

			boolean bindDrugType = false;

			if (drugType == null) {
				query.append(_FINDER_COLUMN_DRUGTYPE_DRUGTYPE_1);
			}
			else if (drugType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DRUGTYPE_DRUGTYPE_3);
			}
			else {
				bindDrugType = true;

				query.append(_FINDER_COLUMN_DRUGTYPE_DRUGTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDrugType) {
					qPos.add(drugType);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DRUGTYPE_DRUGTYPE_1 = "drug.drugType IS NULL";
	private static final String _FINDER_COLUMN_DRUGTYPE_DRUGTYPE_2 = "drug.drugType = ?";
	private static final String _FINDER_COLUMN_DRUGTYPE_DRUGTYPE_3 = "(drug.drugType IS NULL OR drug.drugType = '')";

	public DrugPersistenceImpl() {
		setModelClass(Drug.class);
	}

	/**
	 * Caches the drug in the entity cache if it is enabled.
	 *
	 * @param drug the drug
	 */
	@Override
	public void cacheResult(Drug drug) {
		entityCache.putResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugImpl.class, drug.getPrimaryKey(), drug);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { drug.getUuid(), drug.getGroupId() }, drug);

		drug.resetOriginalValues();
	}

	/**
	 * Caches the drugs in the entity cache if it is enabled.
	 *
	 * @param drugs the drugs
	 */
	@Override
	public void cacheResult(List<Drug> drugs) {
		for (Drug drug : drugs) {
			if (entityCache.getResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
						DrugImpl.class, drug.getPrimaryKey()) == null) {
				cacheResult(drug);
			}
			else {
				drug.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all drugs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DrugImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the drug.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Drug drug) {
		entityCache.removeResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugImpl.class, drug.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DrugModelImpl)drug);
	}

	@Override
	public void clearCache(List<Drug> drugs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Drug drug : drugs) {
			entityCache.removeResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
				DrugImpl.class, drug.getPrimaryKey());

			clearUniqueFindersCache((DrugModelImpl)drug);
		}
	}

	protected void cacheUniqueFindersCache(DrugModelImpl drugModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					drugModelImpl.getUuid(), drugModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				drugModelImpl);
		}
		else {
			if ((drugModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						drugModelImpl.getUuid(), drugModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					drugModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(DrugModelImpl drugModelImpl) {
		Object[] args = new Object[] {
				drugModelImpl.getUuid(), drugModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((drugModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					drugModelImpl.getOriginalUuid(),
					drugModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new drug with the primary key. Does not add the drug to the database.
	 *
	 * @param drugId the primary key for the new drug
	 * @return the new drug
	 */
	@Override
	public Drug create(long drugId) {
		Drug drug = new DrugImpl();

		drug.setNew(true);
		drug.setPrimaryKey(drugId);

		String uuid = PortalUUIDUtil.generate();

		drug.setUuid(uuid);

		drug.setCompanyId(companyProvider.getCompanyId());

		return drug;
	}

	/**
	 * Removes the drug with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param drugId the primary key of the drug
	 * @return the drug that was removed
	 * @throws NoSuchDrugException if a drug with the primary key could not be found
	 */
	@Override
	public Drug remove(long drugId) throws NoSuchDrugException {
		return remove((Serializable)drugId);
	}

	/**
	 * Removes the drug with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the drug
	 * @return the drug that was removed
	 * @throws NoSuchDrugException if a drug with the primary key could not be found
	 */
	@Override
	public Drug remove(Serializable primaryKey) throws NoSuchDrugException {
		Session session = null;

		try {
			session = openSession();

			Drug drug = (Drug)session.get(DrugImpl.class, primaryKey);

			if (drug == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDrugException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(drug);
		}
		catch (NoSuchDrugException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Drug removeImpl(Drug drug) {
		drug = toUnwrappedModel(drug);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(drug)) {
				drug = (Drug)session.get(DrugImpl.class, drug.getPrimaryKeyObj());
			}

			if (drug != null) {
				session.delete(drug);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (drug != null) {
			clearCache(drug);
		}

		return drug;
	}

	@Override
	public Drug updateImpl(Drug drug) {
		drug = toUnwrappedModel(drug);

		boolean isNew = drug.isNew();

		DrugModelImpl drugModelImpl = (DrugModelImpl)drug;

		if (Validator.isNull(drug.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			drug.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (drug.getCreateDate() == null)) {
			if (serviceContext == null) {
				drug.setCreateDate(now);
			}
			else {
				drug.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!drugModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				drug.setModifiedDate(now);
			}
			else {
				drug.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (drug.isNew()) {
				session.save(drug);

				drug.setNew(false);
			}
			else {
				drug = (Drug)session.merge(drug);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DrugModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((drugModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { drugModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { drugModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((drugModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						drugModelImpl.getOriginalUuid(),
						drugModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						drugModelImpl.getUuid(), drugModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((drugModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRUGTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { drugModelImpl.getOriginalDrugType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DRUGTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRUGTYPE,
					args);

				args = new Object[] { drugModelImpl.getDrugType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DRUGTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DRUGTYPE,
					args);
			}
		}

		entityCache.putResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
			DrugImpl.class, drug.getPrimaryKey(), drug, false);

		clearUniqueFindersCache(drugModelImpl);
		cacheUniqueFindersCache(drugModelImpl, isNew);

		drug.resetOriginalValues();

		return drug;
	}

	protected Drug toUnwrappedModel(Drug drug) {
		if (drug instanceof DrugImpl) {
			return drug;
		}

		DrugImpl drugImpl = new DrugImpl();

		drugImpl.setNew(drug.isNew());
		drugImpl.setPrimaryKey(drug.getPrimaryKey());

		drugImpl.setUuid(drug.getUuid());
		drugImpl.setDrugId(drug.getDrugId());
		drugImpl.setGroupId(drug.getGroupId());
		drugImpl.setCompanyId(drug.getCompanyId());
		drugImpl.setUserId(drug.getUserId());
		drugImpl.setUserName(drug.getUserName());
		drugImpl.setCreateDate(drug.getCreateDate());
		drugImpl.setModifiedDate(drug.getModifiedDate());
		drugImpl.setDrugName(drug.getDrugName());
		drugImpl.setDrugQuantity(drug.getDrugQuantity());
		drugImpl.setDrugType(drug.getDrugType());

		return drugImpl;
	}

	/**
	 * Returns the drug with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the drug
	 * @return the drug
	 * @throws NoSuchDrugException if a drug with the primary key could not be found
	 */
	@Override
	public Drug findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDrugException {
		Drug drug = fetchByPrimaryKey(primaryKey);

		if (drug == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDrugException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return drug;
	}

	/**
	 * Returns the drug with the primary key or throws a {@link NoSuchDrugException} if it could not be found.
	 *
	 * @param drugId the primary key of the drug
	 * @return the drug
	 * @throws NoSuchDrugException if a drug with the primary key could not be found
	 */
	@Override
	public Drug findByPrimaryKey(long drugId) throws NoSuchDrugException {
		return findByPrimaryKey((Serializable)drugId);
	}

	/**
	 * Returns the drug with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the drug
	 * @return the drug, or <code>null</code> if a drug with the primary key could not be found
	 */
	@Override
	public Drug fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
				DrugImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Drug drug = (Drug)serializable;

		if (drug == null) {
			Session session = null;

			try {
				session = openSession();

				drug = (Drug)session.get(DrugImpl.class, primaryKey);

				if (drug != null) {
					cacheResult(drug);
				}
				else {
					entityCache.putResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
						DrugImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
					DrugImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return drug;
	}

	/**
	 * Returns the drug with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param drugId the primary key of the drug
	 * @return the drug, or <code>null</code> if a drug with the primary key could not be found
	 */
	@Override
	public Drug fetchByPrimaryKey(long drugId) {
		return fetchByPrimaryKey((Serializable)drugId);
	}

	@Override
	public Map<Serializable, Drug> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Drug> map = new HashMap<Serializable, Drug>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Drug drug = fetchByPrimaryKey(primaryKey);

			if (drug != null) {
				map.put(primaryKey, drug);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
					DrugImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Drug)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DRUG_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Drug drug : (List<Drug>)q.list()) {
				map.put(drug.getPrimaryKeyObj(), drug);

				cacheResult(drug);

				uncachedPrimaryKeys.remove(drug.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DrugModelImpl.ENTITY_CACHE_ENABLED,
					DrugImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the drugs.
	 *
	 * @return the drugs
	 */
	@Override
	public List<Drug> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Drug> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Drug> findAll(int start, int end,
		OrderByComparator<Drug> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Drug> findAll(int start, int end,
		OrderByComparator<Drug> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Drug> list = null;

		if (retrieveFromCache) {
			list = (List<Drug>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DRUG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DRUG;

				if (pagination) {
					sql = sql.concat(DrugModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Drug>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Drug>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the drugs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Drug drug : findAll()) {
			remove(drug);
		}
	}

	/**
	 * Returns the number of drugs.
	 *
	 * @return the number of drugs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DRUG);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DrugModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the drug persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DrugImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DRUG = "SELECT drug FROM Drug drug";
	private static final String _SQL_SELECT_DRUG_WHERE_PKS_IN = "SELECT drug FROM Drug drug WHERE drugId IN (";
	private static final String _SQL_SELECT_DRUG_WHERE = "SELECT drug FROM Drug drug WHERE ";
	private static final String _SQL_COUNT_DRUG = "SELECT COUNT(drug) FROM Drug drug";
	private static final String _SQL_COUNT_DRUG_WHERE = "SELECT COUNT(drug) FROM Drug drug WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "drug.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Drug exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Drug exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DrugPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}