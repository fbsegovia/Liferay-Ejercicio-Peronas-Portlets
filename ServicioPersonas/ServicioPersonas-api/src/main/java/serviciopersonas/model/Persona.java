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

package serviciopersonas.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Persona service. Represents a row in the &quot;FOO_Persona&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PersonaModel
 * @see serviciopersonas.model.impl.PersonaImpl
 * @see serviciopersonas.model.impl.PersonaModelImpl
 * @generated
 */
@ImplementationClassName("serviciopersonas.model.impl.PersonaImpl")
@ProviderType
public interface Persona extends PersonaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link serviciopersonas.model.impl.PersonaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Persona, String> DNI_ACCESSOR = new Accessor<Persona, String>() {
			@Override
			public String get(Persona persona) {
				return persona.getDni();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Persona> getTypeClass() {
				return Persona.class;
			}
		};
}