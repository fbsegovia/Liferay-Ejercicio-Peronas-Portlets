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

package serviciopersonas.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import serviciopersonas.model.Persona;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Persona in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Persona
 * @generated
 */
@ProviderType
public class PersonaCacheModel implements CacheModel<Persona>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonaCacheModel)) {
			return false;
		}

		PersonaCacheModel personaCacheModel = (PersonaCacheModel)obj;

		if (dni.equals(personaCacheModel.dni)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dni);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{dni=");
		sb.append(dni);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", edad=");
		sb.append(edad);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Persona toEntityModel() {
		PersonaImpl personaImpl = new PersonaImpl();

		if (dni == null) {
			personaImpl.setDni(StringPool.BLANK);
		}
		else {
			personaImpl.setDni(dni);
		}

		if (nombre == null) {
			personaImpl.setNombre(StringPool.BLANK);
		}
		else {
			personaImpl.setNombre(nombre);
		}

		personaImpl.setEdad(edad);

		personaImpl.resetOriginalValues();

		return personaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dni = objectInput.readUTF();
		nombre = objectInput.readUTF();

		edad = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (dni == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dni);
		}

		if (nombre == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nombre);
		}

		objectOutput.writeInt(edad);
	}

	public String dni;
	public String nombre;
	public int edad;
}