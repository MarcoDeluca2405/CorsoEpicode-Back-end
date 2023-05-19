package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import daoInterface.IrivisteDAO;
import model.Riviste;
import util.JpaUtil;

public class RivisteDAO implements IrivisteDAO{
private static Logger log=LoggerFactory.getLogger(RivisteDAO.class);

@Override
public void save(Riviste e) {
	// TODO Auto-generated method stub
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	
	try {
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		log.info("Elemento: "+e.getTitolo()+" salvato nel DB");
		
	}catch(Exception ex) {
		em.getTransaction().rollback();
		log.error(ex.getMessage());
		
	}finally {
		em.close();
		
	}
}

@Override
public Riviste getByISBN(int isbn) {
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	
	try {
		
		em.getTransaction().begin();
		Riviste r=em.find(Riviste.class, isbn);
		em.getTransaction().commit();
		return r;
		
	}catch(Exception ex) {
		em.getTransaction().rollback();
		log.error(ex.getMessage());
		
	}finally {
		em.close();
		
	}
	return null;
}

@Override
public void delete(Riviste e) {
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	
	try {
		
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		log.info("Elemento: "+e.getTitolo()+" è stato Eliminato dal DB");
		
	}catch(Exception ex) {
		em.getTransaction().rollback();
		log.error(ex.getMessage());
		
	}finally {
		em.close();
		
	}
	
}

@Override
public void update(Riviste e) {
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	
	try {
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		log.info("Elemento: "+e.getTitolo()+" è stato modificato e salvato nel DB");
		
	}catch(Exception ex) {
		em.getTransaction().rollback();
		log.error(ex.getMessage());
		
	}finally {
		em.close();
		
	}
	
}

@Override
public List<Riviste> getAll() {
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	
	try {
		
		Query q=em.createNamedQuery("findAllRiviste");
		return q.getResultList();
		
	}catch(Exception ex) {
		em.getTransaction().rollback();
		log.error(ex.getMessage());
		
	}finally {
		em.close();
		
	}
	return null;
}

}
