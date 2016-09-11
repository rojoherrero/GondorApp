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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Drug service. Represents a row in the &quot;GOndorApp_Drug&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DrugModel
 * @see org.rojoherrero.gondor.model.impl.DrugImpl
 * @see org.rojoherrero.gondor.model.impl.DrugModelImpl
 * @generated
 */
@ImplementationClassName("org.rojoherrero.gondor.model.impl.DrugImpl")
@ProviderType
public interface Drug extends DrugModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.rojoherrero.gondor.model.impl.DrugImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Drug, Long> DRUG_ID_ACCESSOR = new Accessor<Drug, Long>() {
			@Override
			public Long get(Drug drug) {
				return drug.getDrugId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Drug> getTypeClass() {
				return Drug.class;
			}
		};
}