package com.financas.repository;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpa.HibernatePersistenceProvider;

public class PersistenceManager {

	private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();
	private static EntityManagerFactory factory;

	/**
	 * Cria uma entity manager factory �nica e o retorna em todas as demais chamadas
	 */
	public static EntityManagerFactory getFactory() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("financasPU");
		}
		return factory;

	}

	/**
	 * Cria um entity manager �nico (se criar = true) para a thread e o retorna em
	 * todas as demais chamadas
	 */
	public static EntityManager getEntityManager(boolean criar) {
		EntityManager em = (EntityManager) threadLocal.get();
		if (em == null || !em.isOpen()) {
			if (criar) {
				em = getFactory().createEntityManager();
				threadLocal.set(em);
			}
		}
		return em;
	}

	/**
	 * Cria um entity manager �nico para a thread e o retorna em todas as demais
	 * chamadas
	 */
	public static EntityManager getEntityManager() {
		return getEntityManager(true);
	}

}
