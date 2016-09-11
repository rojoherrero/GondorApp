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

package org.rojoherrero.gondor.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Drug}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Drug
 * @generated
 */
@ProviderType
public class DrugWrapper implements Drug, ModelWrapper<Drug> {
	public DrugWrapper(Drug drug) {
		_drug = drug;
	}

	@Override
	public Class<?> getModelClass() {
		return Drug.class;
	}

	@Override
	public String getModelClassName() {
		return Drug.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("drugId", getDrugId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("drugName", getDrugName());
		attributes.put("drugQuantity", getDrugQuantity());
		attributes.put("drugType", getDrugType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long drugId = (Long)attributes.get("drugId");

		if (drugId != null) {
			setDrugId(drugId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String drugName = (String)attributes.get("drugName");

		if (drugName != null) {
			setDrugName(drugName);
		}

		Double drugQuantity = (Double)attributes.get("drugQuantity");

		if (drugQuantity != null) {
			setDrugQuantity(drugQuantity);
		}

		String drugType = (String)attributes.get("drugType");

		if (drugType != null) {
			setDrugType(drugType);
		}
	}

	@Override
	public Drug toEscapedModel() {
		return new DrugWrapper(_drug.toEscapedModel());
	}

	@Override
	public Drug toUnescapedModel() {
		return new DrugWrapper(_drug.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _drug.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _drug.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _drug.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _drug.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Drug> toCacheModel() {
		return _drug.toCacheModel();
	}

	/**
	* Returns the drug quantity of this drug.
	*
	* @return the drug quantity of this drug
	*/
	@Override
	public double getDrugQuantity() {
		return _drug.getDrugQuantity();
	}

	@Override
	public int compareTo(Drug drug) {
		return _drug.compareTo(drug);
	}

	@Override
	public int hashCode() {
		return _drug.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _drug.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DrugWrapper((Drug)_drug.clone());
	}

	/**
	* Returns the drug name of this drug.
	*
	* @return the drug name of this drug
	*/
	@Override
	public java.lang.String getDrugName() {
		return _drug.getDrugName();
	}

	/**
	* Returns the drug type of this drug.
	*
	* @return the drug type of this drug
	*/
	@Override
	public java.lang.String getDrugType() {
		return _drug.getDrugType();
	}

	/**
	* Returns the user name of this drug.
	*
	* @return the user name of this drug
	*/
	@Override
	public java.lang.String getUserName() {
		return _drug.getUserName();
	}

	/**
	* Returns the user uuid of this drug.
	*
	* @return the user uuid of this drug
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _drug.getUserUuid();
	}

	/**
	* Returns the uuid of this drug.
	*
	* @return the uuid of this drug
	*/
	@Override
	public java.lang.String getUuid() {
		return _drug.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _drug.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _drug.toXmlString();
	}

	/**
	* Returns the create date of this drug.
	*
	* @return the create date of this drug
	*/
	@Override
	public Date getCreateDate() {
		return _drug.getCreateDate();
	}

	/**
	* Returns the modified date of this drug.
	*
	* @return the modified date of this drug
	*/
	@Override
	public Date getModifiedDate() {
		return _drug.getModifiedDate();
	}

	/**
	* Returns the company ID of this drug.
	*
	* @return the company ID of this drug
	*/
	@Override
	public long getCompanyId() {
		return _drug.getCompanyId();
	}

	/**
	* Returns the drug ID of this drug.
	*
	* @return the drug ID of this drug
	*/
	@Override
	public long getDrugId() {
		return _drug.getDrugId();
	}

	/**
	* Returns the group ID of this drug.
	*
	* @return the group ID of this drug
	*/
	@Override
	public long getGroupId() {
		return _drug.getGroupId();
	}

	/**
	* Returns the primary key of this drug.
	*
	* @return the primary key of this drug
	*/
	@Override
	public long getPrimaryKey() {
		return _drug.getPrimaryKey();
	}

	/**
	* Returns the user ID of this drug.
	*
	* @return the user ID of this drug
	*/
	@Override
	public long getUserId() {
		return _drug.getUserId();
	}

	@Override
	public void persist() {
		_drug.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_drug.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this drug.
	*
	* @param companyId the company ID of this drug
	*/
	@Override
	public void setCompanyId(long companyId) {
		_drug.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this drug.
	*
	* @param createDate the create date of this drug
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_drug.setCreateDate(createDate);
	}

	/**
	* Sets the drug ID of this drug.
	*
	* @param drugId the drug ID of this drug
	*/
	@Override
	public void setDrugId(long drugId) {
		_drug.setDrugId(drugId);
	}

	/**
	* Sets the drug name of this drug.
	*
	* @param drugName the drug name of this drug
	*/
	@Override
	public void setDrugName(java.lang.String drugName) {
		_drug.setDrugName(drugName);
	}

	/**
	* Sets the drug quantity of this drug.
	*
	* @param drugQuantity the drug quantity of this drug
	*/
	@Override
	public void setDrugQuantity(double drugQuantity) {
		_drug.setDrugQuantity(drugQuantity);
	}

	/**
	* Sets the drug type of this drug.
	*
	* @param drugType the drug type of this drug
	*/
	@Override
	public void setDrugType(java.lang.String drugType) {
		_drug.setDrugType(drugType);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_drug.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_drug.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_drug.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this drug.
	*
	* @param groupId the group ID of this drug
	*/
	@Override
	public void setGroupId(long groupId) {
		_drug.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this drug.
	*
	* @param modifiedDate the modified date of this drug
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_drug.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_drug.setNew(n);
	}

	/**
	* Sets the primary key of this drug.
	*
	* @param primaryKey the primary key of this drug
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_drug.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_drug.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this drug.
	*
	* @param userId the user ID of this drug
	*/
	@Override
	public void setUserId(long userId) {
		_drug.setUserId(userId);
	}

	/**
	* Sets the user name of this drug.
	*
	* @param userName the user name of this drug
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_drug.setUserName(userName);
	}

	/**
	* Sets the user uuid of this drug.
	*
	* @param userUuid the user uuid of this drug
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_drug.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this drug.
	*
	* @param uuid the uuid of this drug
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_drug.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DrugWrapper)) {
			return false;
		}

		DrugWrapper drugWrapper = (DrugWrapper)obj;

		if (Objects.equals(_drug, drugWrapper._drug)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _drug.getStagedModelType();
	}

	@Override
	public Drug getWrappedModel() {
		return _drug;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _drug.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _drug.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_drug.resetOriginalValues();
	}

	private final Drug _drug;
}