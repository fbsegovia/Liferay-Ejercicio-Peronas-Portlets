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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link serviciopersonas.service.http.PersonaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see serviciopersonas.service.http.PersonaServiceSoap
 * @generated
 */
@ProviderType
public class PersonaSoap implements Serializable {
	public static PersonaSoap toSoapModel(Persona model) {
		PersonaSoap soapModel = new PersonaSoap();

		soapModel.setDni(model.getDni());
		soapModel.setNombre(model.getNombre());
		soapModel.setEdad(model.getEdad());

		return soapModel;
	}

	public static PersonaSoap[] toSoapModels(Persona[] models) {
		PersonaSoap[] soapModels = new PersonaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonaSoap[][] toSoapModels(Persona[][] models) {
		PersonaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersonaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonaSoap[] toSoapModels(List<Persona> models) {
		List<PersonaSoap> soapModels = new ArrayList<PersonaSoap>(models.size());

		for (Persona model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonaSoap[soapModels.size()]);
	}

	public PersonaSoap() {
	}

	public String getPrimaryKey() {
		return _dni;
	}

	public void setPrimaryKey(String pk) {
		setDni(pk);
	}

	public String getDni() {
		return _dni;
	}

	public void setDni(String dni) {
		_dni = dni;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public int getEdad() {
		return _edad;
	}

	public void setEdad(int edad) {
		_edad = edad;
	}

	private String _dni;
	private String _nombre;
	private int _edad;
}