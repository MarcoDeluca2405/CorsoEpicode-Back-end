package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import daoInterface.IUtenteDAO;
import model.Catalogo;
import model.Utente;
import util.JpaUtil;

public class UtenteDAO implements IUtenteDAO {
	private Logger log= LoggerFactory.getLogger(CatalogoDAO.class);
	@Override
	public void save(Utente e) {
		// TODO Auto-generated method stub
		EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			log.info("Elemento: "+e.getCognome()+" salvato nel DB");
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
	}

	@Override
	public Utente getByISBN(int nTessera) {
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			Utente u=em.find(Utente.class, nTessera);
			em.getTransaction().commit();
			return u;
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
		return null;
	}

	@Override
	public void delete(Utente e) {
		
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			log.info("Elemento: "+e.getCognome()+" è stato Eliminato dal DB");
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
		
	}

	@Override
	public void update(Utente e) {
EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
			log.info("Elemento: "+e.getCognome()+" è stato modificato e salvato nel DB");
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
		
	}

	@Override
	public List<Utente> getAll() {
EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			Query q=em.createNamedQuery("findAllCatalogo");
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
