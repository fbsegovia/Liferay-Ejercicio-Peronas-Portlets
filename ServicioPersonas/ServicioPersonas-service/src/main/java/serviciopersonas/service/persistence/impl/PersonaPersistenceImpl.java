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

package serviciopersonas.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import serviciopersonas.exception.NoSuchPersonaException;

import serviciopersonas.model.Persona;

import serviciopersonas.model.impl.PersonaImpl;
import serviciopersonas.model.impl.PersonaModelImpl;

import serviciopersonas.service.persistence.PersonaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the persona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonaPersistence
 * @see serviciopersonas.service.persistence.PersonaUtil
 * @generated
 */
@ProviderType
public class PersonaPersistenceImpl extends BasePersistenceImpl<Persona>
	implements PersonaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PersonaUtil} to access the persona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PersonaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaModelImpl.FINDER_CACHE_ENABLED, PersonaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaModelImpl.FINDER_CACHE_ENABLED, PersonaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PersonaPersistenceImpl() {
		setModelClass(Persona.class);
	}

	/**
	 * Caches the persona in the entity cache if it is enabled.
	 *
	 * @param persona the persona
	 */
	@Override
	public void cacheResult(Persona persona) {
		entityCache.putResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaImpl.class, persona.getPrimaryKey(), persona);

		persona.resetOriginalValues();
	}

	/**
	 * Caches the personas in the entity cache if it is enabled.
	 *
	 * @param personas the personas
	 */
	@Override
	public void cacheResult(List<Persona> personas) {
		for (Persona persona : personas) {
			if (entityCache.getResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
						PersonaImpl.class, persona.getPrimaryKey()) == null) {
				cacheResult(persona);
			}
			else {
				persona.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all personas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersonaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persona.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Persona persona) {
		entityCache.removeResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaImpl.class, persona.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Persona> personas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Persona persona : personas) {
			entityCache.removeResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
				PersonaImpl.class, persona.getPrimaryKey());
		}
	}

	/**
	 * Creates a new persona with the primary key. Does not add the persona to the database.
	 *
	 * @param dni the primary key for the new persona
	 * @return the new persona
	 */
	@Override
	public Persona create(String dni) {
		Persona persona = new PersonaImpl();

		persona.setNew(true);
		persona.setPrimaryKey(dni);

		return persona;
	}

	/**
	 * Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dni the primary key of the persona
	 * @return the persona that was removed
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona remove(String dni) throws NoSuchPersonaException {
		return remove((Serializable)dni);
	}

	/**
	 * Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persona
	 * @return the persona that was removed
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona remove(Serializable primaryKey)
		throws NoSuchPersonaException {
		Session session = null;

		try {
			session = openSession();

			Persona persona = (Persona)session.get(PersonaImpl.class, primaryKey);

			if (persona == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersonaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(persona);
		}
		catch (NoSuchPersonaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Persona removeImpl(Persona persona) {
		persona = toUnwrappedModel(persona);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persona)) {
				persona = (Persona)session.get(PersonaImpl.class,
						persona.getPrimaryKeyObj());
			}

			if (persona != null) {
				session.delete(persona);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (persona != null) {
			clearCache(persona);
		}

		return persona;
	}

	@Override
	public Persona updateImpl(Persona persona) {
		persona = toUnwrappedModel(persona);

		boolean isNew = persona.isNew();

		Session session = null;

		try {
			session = openSession();

			if (persona.isNew()) {
				session.save(persona);

				persona.setNew(false);
			}
			else {
				persona = (Persona)session.merge(persona);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaImpl.class, persona.getPrimaryKey(), persona, false);

		persona.resetOriginalValues();

		return persona;
	}

	protected Persona toUnwrappedModel(Persona persona) {
		if (persona instanceof PersonaImpl) {
			return persona;
		}

		PersonaImpl personaImpl = new PersonaImpl();

		personaImpl.setNew(persona.isNew());
		personaImpl.setPrimaryKey(persona.getPrimaryKey());

		personaImpl.setDni(persona.getDni());
		personaImpl.setNombre(persona.getNombre());
		personaImpl.setEdad(persona.getEdad());

		return personaImpl;
	}

	/**
	 * Returns the persona with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the persona
	 * @return the persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersonaException {
		Persona persona = fetchByPrimaryKey(primaryKey);

		if (persona == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersonaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return persona;
	}

	/**
	 * Returns the persona with the primary key or throws a {@link NoSuchPersonaException} if it could not be found.
	 *
	 * @param dni the primary key of the persona
	 * @return the persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona findByPrimaryKey(String dni) throws NoSuchPersonaException {
		return findByPrimaryKey((Serializable)dni);
	}

	/**
	 * Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persona
	 * @return the persona, or <code>null</code> if a persona with the primary key could not be found
	 */
	@Override
	public Persona fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
				PersonaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Persona persona = (Persona)serializable;

		if (persona == null) {
			Session session = null;

			try {
				session = openSession();

				persona = (Persona)session.get(PersonaImpl.class, primaryKey);

				if (persona != null) {
					cacheResult(persona);
				}
				else {
					entityCache.putResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
						PersonaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
					PersonaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return persona;
	}

	/**
	 * Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dni the primary key of the persona
	 * @return the persona, or <code>null</code> if a persona with the primary key could not be found
	 */
	@Override
	public Persona fetchByPrimaryKey(String dni) {
		return fetchByPrimaryKey((Serializable)dni);
	}

	@Override
	public Map<Serializable, Persona> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Persona> map = new HashMap<Serializable, Persona>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Persona persona = fetchByPrimaryKey(primaryKey);

			if (persona != null) {
				map.put(primaryKey, persona);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
					PersonaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Persona)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_PERSONA_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Persona persona : (List<Persona>)q.list()) {
				map.put(persona.getPrimaryKeyObj(), persona);

				cacheResult(persona);

				uncachedPrimaryKeys.remove(persona.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
					PersonaImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the personas.
	 *
	 * @return the personas
	 */
	@Override
	public List<Persona> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Persona> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Persona> findAll(int start, int end,
		OrderByComparator<Persona> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Persona> findAll(int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Persona> list = null;

		if (retrieveFromCache) {
			list = (List<Persona>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERSONA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERSONA;

				if (pagination) {
					sql = sql.concat(PersonaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Persona>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Persona>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the personas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Persona persona : findAll()) {
			remove(persona);
		}
	}

	/**
	 * Returns the number of personas.
	 *
	 * @return the number of personas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERSONA);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersonaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persona persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PersonaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PERSONA = "SELECT persona FROM Persona persona";
	private static final String _SQL_SELECT_PERSONA_WHERE_PKS_IN = "SELECT persona FROM Persona persona WHERE dni IN (";
	private static final String _SQL_COUNT_PERSONA = "SELECT COUNT(persona) FROM Persona persona";
	private static final String _ORDER_BY_ENTITY_ALIAS = "persona.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Persona exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(PersonaPersistenceImpl.class);
}