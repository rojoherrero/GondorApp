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

package org.rojoherrero.gondor.pharmacy.service.impl;

import aQute.bnd.annotation.ProviderType;

import org.rojoherrero.gondor.pharmacy.service.base.DrugLocalServiceBaseImpl;

/**
 * The implementation of the drug local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.rojoherrero.gondor.pharmacy.service.DrugLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DrugLocalServiceBaseImpl
 * @see org.rojoherrero.gondor.pharmacy.service.DrugLocalServiceUtil
 */
@ProviderType
public class DrugLocalServiceImpl extends DrugLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link org.rojoherrero.gondor.pharmacy.service.DrugLocalServiceUtil} to access the drug local service.
	 */
}