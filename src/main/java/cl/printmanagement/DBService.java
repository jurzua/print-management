package cl.printmanagement;

import java.awt.PrintJob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import cl.printmanagement.bo.DBEntry;
import cl.printmanagement.bo.Print;
import cl.printmanagement.bo.User;


public class DBService {

	private static final Logger logger = Logger.getLogger(DBService.class);
	
	private static DBService instance;
	
	public static DBService getInstance(){
		if(instance == null){
			instance = new DBService();
		}
		return instance;
	}
	
	public List<Print> getPrintList(String userName){
		long start = System.currentTimeMillis();
		List<Print> list = new ArrayList<Print>();
		
		EntityManager em = PersistenceManagerCore.getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				Query query = em.createQuery("from Print where userName = :userName");
				query.setParameter("userName", userName);
				list = (List<Print>)query.getResultList();
				em.getTransaction().commit();
			} catch (Exception e) {
				if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		
		long diff = System.currentTimeMillis() - start;  
		logger.info("[size="+ list.size() +", time(ms)=" + diff + "]");
		return list;	
	}
	
	
	public List<Print> getPrintList(){
		long start = System.currentTimeMillis();
		List<Print> list = new ArrayList<Print>();
		
		EntityManager em = PersistenceManagerCore.getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				Query query = em.createQuery("from Print");
				list = (List<Print>)query.getResultList();
				em.getTransaction().commit();
			} catch (Exception e) {
				if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		
		long diff = System.currentTimeMillis() - start;  
		logger.info("[size="+ list.size() +", time(ms)=" + diff + "]");
		return list;		
	}
	
	public List<User> getUserList(){
		long start = System.currentTimeMillis();
		List<User> list = new ArrayList<User>();
		
		EntityManager em = PersistenceManagerCore.getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				Query query = em.createQuery("from User");
				list = (List<User>)query.getResultList();
				em.getTransaction().commit();
			} catch (Exception e) {
				if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		
		long diff = System.currentTimeMillis() - start;  
		logger.info("[size="+ list.size() +", time(ms)=" + diff + "]");
		return list;		
	}
	
	public User getUser(Long id){
		User user = null;
		EntityManager em = PersistenceManagerCore.getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				Query query = em.createQuery("from User where id = :id");
				query.setParameter("id", id);
				List<User> list = (List<User>)query.getResultList();
				user = (!list.isEmpty()) ? list.get(0) : null;
				em.getTransaction().commit();
			} catch (Exception e) {
				if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return user;
	}
	
	public Print getPrint(String jobId, String computer){
		Print print = null;
		EntityManager em = PersistenceManagerCore.getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				Query query = em.createQuery("from Print where jobId = :jobId and computer = :computer");
				query.setParameter("jobId", jobId);
				query.setParameter("computer", computer);
				List<Print> list = (List<Print>)query.getResultList();
				print = (!list.isEmpty()) ? list.get(0) : null;
				em.getTransaction().commit();
			} catch (Exception e) {
				if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return print;
	}
	
	
	public User login(String email, String password){
		User user = null;
		EntityManager em = PersistenceManagerCore.getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				Query query = em.createQuery("from User where email = :email and password = :password");
				query.setParameter("email", email);
				query.setParameter("password", password);
				List<User> list = (List<User>)query.getResultList();
				user = (!list.isEmpty()) ? list.get(0) : null;
				em.getTransaction().commit();
			} catch (Exception e) {
				if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return user;
	}

	public void saveDBEntry(DBEntry entity) throws Exception {
		logger.info("Prepering to save " + entity.toString());
		
		EntityManager em = PersistenceManagerCore.getEntityManager();
		try {
			em.getTransaction().begin();
			try {		
				saveDBEntry0(em, entity);
				em.getTransaction().commit();
			} catch (Exception e) {
				if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		logger.info("Saving " + entity.toString());
	}
	
	public void removeDBEntry(DBEntry entity) throws Exception {
		logger.info("Prepering to save " + entity.toString());
		
		EntityManager em = PersistenceManagerCore.getEntityManager();
		try {
			em.getTransaction().begin();
			try {		
				em.remove(entity);
				em.getTransaction().commit();
			} catch (Exception e) {
				if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		logger.info("Saving " + entity.toString());
	}
	
	private void saveDBEntry0(EntityManager em, DBEntry entity) throws Exception {
		boolean isPersistent = entity.isPersistent();
		Date timeStamp = new Date();
		if(!isPersistent){
			entity.setCreationTime(timeStamp);	
		}
		entity.setLastChange(timeStamp);
		saveOrUpdate(em, entity);
	    
	    logger.info("Entity saved: " + entity.toString());
	}
	
	private void saveOrUpdate(EntityManager em, DBEntry entry){
		if(entry.isPersistent()){
			em.merge(entry);
		}else{
			em.persist(entry);
		}
	}
}
