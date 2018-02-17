/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.financas.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.financas.uteis.LogUtils;


public class GenericDao<T> {

	private Logger logger = LogManager.getLogger(GenericDao.class);
    private Class classeObjeto;

    public GenericDao(Class classeObjeto) {
        this.classeObjeto = classeObjeto;
    }

    private EntityManager em = PersistenceManager.getEntityManager();

	public T inserir(T obj) throws PersistenceException {
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		}catch (PersistenceException e) {
			logger.error(GenericDao.class.getName() + ".insert = " + e.getCause(), e);
			rollbackTransaction(em);
			throw e;
		}
		return obj;
	}

	public T atualizar(T obj) throws PersistenceException {
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			logger.error(GenericDao.class.getName() + ".atualizar = " + e.getCause(), e);
			rollbackTransaction(em);
			throw e;
		}
		return obj;
	}

    public boolean excluir(T obj) {
       try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
        	logger.error(GenericDao.class.getName() + ".excluir = " + e.getCause(), e);
			rollbackTransaction(em);
        }
        return false;
    }

    public T getObjeto(int id) {
        try {
            em.getTransaction().begin();
            T a = (T) em.find(getClasseObjeto(),id);
            em.getTransaction().commit();
            return a;
        } catch (Exception e) {
        	logger.error(GenericDao.class.getName() + ".getObjeto = " + e.getCause(), e);
			rollbackTransaction(em);
        }
        return null;
    }

    public void rollbackTransaction(EntityManager em) throws PersistenceException{
    	try {
	    	if(em != null && em.getTransaction() != null) {
	    		em.getTransaction().rollback();
	    	}
    	}catch (PersistenceException e) {
			logger.error(LogUtils.formatMessage(GenericDao.class, "rollbackTransaction", e.getMessage()), e);
			throw e;
		}
    }
    
    public Class getClasseObjeto() {
        return classeObjeto;
    }

    public void setClasseObjeto(Class classeObjeto) {
        this.classeObjeto = classeObjeto;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
