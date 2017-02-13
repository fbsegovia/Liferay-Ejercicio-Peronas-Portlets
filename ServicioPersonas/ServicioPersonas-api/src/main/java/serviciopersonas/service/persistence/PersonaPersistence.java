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

package serviciopersonas.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import serviciopersonas.exception.NoSuchPersonaException;

import serviciopersonas.model.Persona;

/**
 * The persistence interface for the persona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see serviciopersonas.service.persistence.impl.PersonaPersistenceImpl
 * @see PersonaUtil
 * @generated
 */
@ProviderType
public interface PersonaPersistence extends BasePersistence<Persona> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonaUtil} to access the persona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the persona in the entity cache if it is enabled.
	*
	* @param persona the persona
	*/
	public void cacheResult(Persona persona);

	/**
	* Caches the personas in the entity cache if it is enabled.
	*
	* @param personas the personas
	*/
	public void cacheResult(java.util.List<Persona> personas);

	/**
	* Creates a new persona with the primary key. Does not add the persona to the database.
	*
	* @param dni the primary key for the new persona
	* @return the new persona
	*/
	public Persona create(java.lang.String dni);

	/**
	* Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dni the primary key of the persona
	* @return the persona that was removed
	* @throws NoSuchPersonaException if a persona with the primary key could not be found
	*/
	public Persona remove(java.lang.String dni) throws NoSuchPersonaException;

	public Persona updateImpl(Persona persona);

	/**
	* Returns the persona with the primary key or throws a {@link NoSuchPersonaException} if it could not be found.
	*
	* @param dni the primary key of the persona
	* @return the persona
	* @throws NoSuchPersonaException if a persona with the primary key could not be found
	*/
	public Persona findByPrimaryKey(java.lang.String dni)
		throws NoSuchPersonaException;

	/**
	* Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dni the primary key of the persona
	* @return the persona, or <code>null</code> if a persona with the primary key could not be found
	*/
	public Persona fetchByPrimaryKey(java.lang.String dni);

	@Override
	public java.util.Map<java.io.Serializable, Persona> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the personas.
	*
	* @return the personas
	*/
	public java.util.List<Persona> findAll();

	/**
	* Returns a range of all the personas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of personas
	* @param end the upper bound of the range of personas (not inclusive)
	* @return the range of personas
	*/
	public java.util.List<Persona> findAll(int start, int end);

	/**
	* Returns an ordered range of all the personas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of personas
	* @param end the upper bound of the range of personas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of personas
	*/
	public java.util.List<Persona> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona> orderByComparator);

	/**
	* Returns an ordered range of all the personas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of personas
	* @param end the upper bound of the range of personas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of personas
	*/
	public java.util.List<Persona> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the personas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of personas.
	*
	* @return the number of personas
	*/
	public int countAll();
}