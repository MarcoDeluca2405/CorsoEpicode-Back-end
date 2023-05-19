package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import daoInterface.IPrestitoDAO;
import model.Catalogo;
import model.Prestito;
import util.JpaUtil;

public class PrestitoDAO implements IPrestitoDAO{
	private Logger log= LoggerFactory.getLogger(CatalogoDAO.class);
	@Override
	public void save(Prestito e) {
		// TODO Auto-generated method stub
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			log.info("Elemento: "+e.getUtente()+" salvato nel DB");
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
	}

	@Override
	public Prestito getByISBN(int isbn) {
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			Prestito c=em.find(Prestito.class, isbn);
			em.getTransaction().commit();
			return c;
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
		return null;
	}

	@Override
	public void delete(Prestito e) {
		// TODO Auto-generated method stub
EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			log.info("Elemento: "+e.getUtente()+" è stato Eliminato dal DB");
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
		
	}

	@Override
	public void update(Prestito e) {
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
			log.info("Elemento: "+e.getUtente()+" è stato modificato e salvato nel DB");
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
		
	}

	@Override
	public List<Prestito> getAll() {
		// TODO Auto-generated method stub
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			Query q=em.createNamedQuery("findAllPrestito");
			return q.getResultList();
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
		return null;
	}

	@Override
	public List<Prestito> getAllElement(int numeroTessere) {
		// TODO Auto-generated method stub
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			Query q=em.createNamedQuery("findUtenteAttuali");
			q.setParameter("tessera", numeroTessere);
			return q.getResultList();
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
		
		return null;
	}

	@Override
	public List<Prestito> getAllElementOverDate(LocalDate e) {
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	try {
		
		Query q=em.createNamedQuery("findUtenteAttuali");
		q.setParameter("currentData",e );
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
