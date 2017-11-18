/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GenericDao<T> {

	private Logger logger = LogManager.getLogger(GenericDao.class);
    private Class classeObjeto;

    public GenericDao(Class classeObjeto) {
        this.classeObjeto = classeObjeto;
    }

    //Gerencia o ciclo de vida da EntityManager
    //Biblioteca utilizada ScopedEntityManager-1.0-r5.jar

    //private EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    private EntityManager em = PersistenceManager.getEntityManager();

    public boolean inserir(T obj) {
        try {
            getEm().getTransaction().begin();
            getEm().persist(obj);
            getEm().getTransaction().commit();
            return true;
        } catch (Exception e) {
        	logger.error("************** Erro ao inserir objeto. ************** ", e);
            return false;
        }
    }

    public boolean atualizar(T obj) {
        try {
            getEm().getTransaction().begin();
            getEm().merge(obj);
            getEm().getTransaction().commit();
            return true;
        } catch (Exception e) {
        	logger.error("************** Erro ao atualizar objeto. ************** ", e);
        }
        return false;
    }
    
    
    
    public boolean excluir(T obj) {
       try {
            getEm().getTransaction().begin();
            getEm().remove(obj);
            getEm().getTransaction().commit();
            return true;
        } catch (Exception e) {
        	logger.error("************** Erro ao excluir objeto. ************** ", e);
        }
        return false;
    }

    public T getObjeto(int id) {
        try {
            getEm().getTransaction().begin();
            T a = (T) getEm().find(getClasseObjeto(),id);
            getEm().getTransaction().commit();
            return a;
        } catch (Exception e) {
        	logger.error("************** Erro ao carregar objeto. ************** ",	e);
        }
        return null;
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
