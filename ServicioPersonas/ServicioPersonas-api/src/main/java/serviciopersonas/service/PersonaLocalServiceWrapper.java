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

package serviciopersonas.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PersonaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersonaLocalService
 * @generated
 */
@ProviderType
public class PersonaLocalServiceWrapper implements PersonaLocalService,
	ServiceWrapper<PersonaLocalService> {
	public PersonaLocalServiceWrapper(PersonaLocalService personaLocalService) {
		_personaLocalService = personaLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _personaLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _personaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _personaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of personas.
	*
	* @return the number of personas
	*/
	@Override
	public int getPersonasCount() {
		return _personaLocalService.getPersonasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _personaLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _personaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link serviciopersonas.model.impl.PersonaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _personaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link serviciopersonas.model.impl.PersonaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _personaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the personas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link serviciopersonas.model.impl.PersonaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of personas
	* @param end the upper bound of the range of personas (not inclusive)
	* @return the range of personas
	*/
	@Override
	public java.util.List<serviciopersonas.model.Persona> getPersonas(
		int start, int end) {
		return _personaLocalService.getPersonas(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _personaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _personaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the persona to the database. Also notifies the appropriate model listeners.
	*
	* @param persona the persona
	* @return the persona that was added
	*/
	@Override
	public serviciopersonas.model.Persona addPersona(
		serviciopersonas.model.Persona persona) {
		return _personaLocalService.addPersona(persona);
	}

	/**
	* Creates a new persona with the primary key. Does not add the persona to the database.
	*
	* @param dni the primary key for the new persona
	* @return the new persona
	*/
	@Override
	public serviciopersonas.model.Persona createPersona(java.lang.String dni) {
		return _personaLocalService.createPersona(dni);
	}

	/**
	* Deletes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dni the primary key of the persona
	* @return the persona that was removed
	* @throws PortalException if a persona with the primary key could not be found
	*/
	@Override
	public serviciopersonas.model.Persona deletePersona(java.lang.String dni)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _personaLocalService.deletePersona(dni);
	}

	/**
	* Deletes the persona from the database. Also notifies the appropriate model listeners.
	*
	* @param persona the persona
	* @return the persona that was removed
	*/
	@Override
	public serviciopersonas.model.Persona deletePersona(
		serviciopersonas.model.Persona persona) {
		return _personaLocalService.deletePersona(persona);
	}

	@Override
	public serviciopersonas.model.Persona fetchPersona(java.lang.String dni) {
		return _personaLocalService.fetchPersona(dni);
	}

	/**
	* Returns the persona with the primary key.
	*
	* @param dni the primary key of the persona
	* @return the persona
	* @throws PortalException if a persona with the primary key could not be found
	*/
	@Override
	public serviciopersonas.model.Persona getPersona(java.lang.String dni)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _personaLocalService.getPersona(dni);
	}

	/**
	* Updates the persona in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param persona the persona
	* @return the persona that was updated
	*/
	@Override
	public serviciopersonas.model.Persona updatePersona(
		serviciopersonas.model.Persona persona) {
		return _personaLocalService.updatePersona(persona);
	}

	@Override
	public PersonaLocalService getWrappedService() {
		return _personaLocalService;
	}

	@Override
	public void setWrappedService(PersonaLocalService personaLocalService) {
		_personaLocalService = personaLocalService;
	}

	private PersonaLocalService _personaLocalService;
}