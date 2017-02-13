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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Persona}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Persona
 * @generated
 */
@ProviderType
public class PersonaWrapper implements Persona, ModelWrapper<Persona> {
	public PersonaWrapper(Persona persona) {
		_persona = persona;
	}

	@Override
	public Class<?> getModelClass() {
		return Persona.class;
	}

	@Override
	public String getModelClassName() {
		return Persona.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dni", getDni());
		attributes.put("nombre", getNombre());
		attributes.put("edad", getEdad());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String dni = (String)attributes.get("dni");

		if (dni != null) {
			setDni(dni);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		Integer edad = (Integer)attributes.get("edad");

		if (edad != null) {
			setEdad(edad);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _persona.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _persona.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _persona.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _persona.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<serviciopersonas.model.Persona> toCacheModel() {
		return _persona.toCacheModel();
	}

	@Override
	public int compareTo(serviciopersonas.model.Persona persona) {
		return _persona.compareTo(persona);
	}

	/**
	* Returns the edad of this persona.
	*
	* @return the edad of this persona
	*/
	@Override
	public int getEdad() {
		return _persona.getEdad();
	}

	@Override
	public int hashCode() {
		return _persona.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _persona.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PersonaWrapper((Persona)_persona.clone());
	}

	/**
	* Returns the dni of this persona.
	*
	* @return the dni of this persona
	*/
	@Override
	public java.lang.String getDni() {
		return _persona.getDni();
	}

	/**
	* Returns the nombre of this persona.
	*
	* @return the nombre of this persona
	*/
	@Override
	public java.lang.String getNombre() {
		return _persona.getNombre();
	}

	/**
	* Returns the primary key of this persona.
	*
	* @return the primary key of this persona
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _persona.getPrimaryKey();
	}

	@Override
	public java.lang.String toString() {
		return _persona.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _persona.toXmlString();
	}

	@Override
	public serviciopersonas.model.Persona toEscapedModel() {
		return new PersonaWrapper(_persona.toEscapedModel());
	}

	@Override
	public serviciopersonas.model.Persona toUnescapedModel() {
		return new PersonaWrapper(_persona.toUnescapedModel());
	}

	@Override
	public void persist() {
		_persona.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_persona.setCachedModel(cachedModel);
	}

	/**
	* Sets the dni of this persona.
	*
	* @param dni the dni of this persona
	*/
	@Override
	public void setDni(java.lang.String dni) {
		_persona.setDni(dni);
	}

	/**
	* Sets the edad of this persona.
	*
	* @param edad the edad of this persona
	*/
	@Override
	public void setEdad(int edad) {
		_persona.setEdad(edad);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_persona.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_persona.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_persona.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_persona.setNew(n);
	}

	/**
	* Sets the nombre of this persona.
	*
	* @param nombre the nombre of this persona
	*/
	@Override
	public void setNombre(java.lang.String nombre) {
		_persona.setNombre(nombre);
	}

	/**
	* Sets the primary key of this persona.
	*
	* @param primaryKey the primary key of this persona
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_persona.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_persona.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonaWrapper)) {
			return false;
		}

		PersonaWrapper personaWrapper = (PersonaWrapper)obj;

		if (Objects.equals(_persona, personaWrapper._persona)) {
			return true;
		}

		return false;
	}

	@Override
	public Persona getWrappedModel() {
		return _persona;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _persona.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _persona.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_persona.resetOriginalValues();
	}

	private final Persona _persona;
}