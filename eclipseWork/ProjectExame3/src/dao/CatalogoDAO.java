package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import daoInterface.ICatalogoDAO;
import model.Catalogo;

import util.*;

public class CatalogoDAO implements ICatalogoDAO{
	private Logger log= LoggerFactory.getLogger(CatalogoDAO.class);
	
	@Override
	public void save(Catalogo e) {
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
	public Catalogo getByISBN(int isbn) {
		// TODO Auto-generated method stub
		
		
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			Catalogo c=em.find(Catalogo.class, isbn);
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
	public void delete(Catalogo e) {
		// TODO Auto-generated method stub
		
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
	public void update(Catalogo e) {
		// TODO Auto-generated method stub
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
	public List<Catalogo> getAll() {
		// TODO Auto-generated method stub
		
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

	@Override
	public List<Catalogo> getFindAnnoPublciazione(int e) {
		// TODO Auto-generated method stub
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		
			Query q=em.createNamedQuery("findEqualAnno");
			q.setParameter("anno", e);
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
	public void deleteByid(int ISBN) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
				Query q=em.createQuery("DELETE FROM Catalogo c WHERE c.ISBN= :s");
				q.setParameter("s", ISBN);
				q.executeUpdate();
			em.getTransaction().commit();
			System.out.println("è stato cancellato");
		}catch(Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			
		}finally {
			em.close();
			
		}
	}

	@Override
	public List<Catalogo> getFindAutore(String e) {
		
	EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		
			Query q=em.createNamedQuery("findAutore");
			q.setParameter("autore",e);
		
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
	public List<Catalogo> getFindTitolo(String e) {
EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		
			Query q=em.createNamedQuery("findTitolo");
			q.setParameter("titolo",e);
		
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
