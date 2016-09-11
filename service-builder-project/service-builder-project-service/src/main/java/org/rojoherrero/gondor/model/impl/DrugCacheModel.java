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

package org.rojoherrero.gondor.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.rojoherrero.gondor.model.Drug;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Drug in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Drug
 * @generated
 */
@ProviderType
public class DrugCacheModel implements CacheModel<Drug>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DrugCacheModel)) {
			return false;
		}

		DrugCacheModel drugCacheModel = (DrugCacheModel)obj;

		if (drugId == drugCacheModel.drugId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, drugId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", drugId=");
		sb.append(drugId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", drugName=");
		sb.append(drugName);
		sb.append(", drugQuantity=");
		sb.append(drugQuantity);
		sb.append(", drugType=");
		sb.append(drugType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Drug toEntityModel() {
		DrugImpl drugImpl = new DrugImpl();

		if (uuid == null) {
			drugImpl.setUuid(StringPool.BLANK);
		}
		else {
			drugImpl.setUuid(uuid);
		}

		drugImpl.setDrugId(drugId);
		drugImpl.setGroupId(groupId);
		drugImpl.setCompanyId(companyId);
		drugImpl.setUserId(userId);

		if (userName == null) {
			drugImpl.setUserName(StringPool.BLANK);
		}
		else {
			drugImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			drugImpl.setCreateDate(null);
		}
		else {
			drugImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			drugImpl.setModifiedDate(null);
		}
		else {
			drugImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (drugName == null) {
			drugImpl.setDrugName(StringPool.BLANK);
		}
		else {
			drugImpl.setDrugName(drugName);
		}

		drugImpl.setDrugQuantity(drugQuantity);

		if (drugType == null) {
			drugImpl.setDrugType(StringPool.BLANK);
		}
		else {
			drugImpl.setDrugType(drugType);
		}

		drugImpl.resetOriginalValues();

		return drugImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		drugId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		drugName = objectInput.readUTF();

		drugQuantity = objectInput.readDouble();
		drugType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(drugId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (drugName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(drugName);
		}

		objectOutput.writeDouble(drugQuantity);

		if (drugType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(drugType);
		}
	}

	public String uuid;
	public long drugId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String drugName;
	public double drugQuantity;
	public String drugType;
}