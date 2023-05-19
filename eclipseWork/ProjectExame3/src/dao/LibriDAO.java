package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import daoInterface.IlibriDAO;
import model.Catalogo;
import model.Libri;
import model.Riviste;
import util.JpaUtil;

public class LibriDAO implements IlibriDAO {
private static Logger log= LoggerFactory.getLogger(LibriDAO.class);
	@Override
	public void save(Libri e) {
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
	public Libri getByISBN(int isbn) {
		// TODO Auto-generated method stub
EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			Libri r=em.find(Libri.class, isbn);
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
	public void delete(Libri e) {
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
	public void update(Libri e) {
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
	public List<Libri> getAll() {
		// TODO Auto-generated method stub
		
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			Query q=em.createNamedQuery("findAllLibri");
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
