package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

public class MainProject {
	
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAproject");
	 static EntityManager em=emf.createEntityManager();
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Cliente c=new Cliente();
		c.setNome("Marco");
		c.setCognome("Viola");
		c.setRegioneRresidenza("Toscana");
		c.setDataNascita(LocalDate.of(1980, 11, 22));
		c.setEmail("m.viola@example.com");
		inserisciCliente(c);
		*/
		
		Cliente c=leggiCliente(1);
		System.out.println(c);
		
		c.setRegioneRresidenza("Lazio");
		modificaCliente(c);
		
	}
	public static void inserisciCliente(Cliente c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		System.out.println("utente salvato nel DB");
	}
public static void modificaCliente(Cliente c) {
	em.getTransaction().begin();
	em.merge(c);
	em.getTransaction().commit();
	System.out.println("utente salvato nel DB");
	}
public static void eliminaCliente(Cliente c) {
	em.getTransaction().begin();
	em.remove(c);
	em.getTransaction().commit();
	System.out.println("utente salvato nel DB");
}

public static Cliente leggiCliente(Integer id) {
	Cliente c=null;
	em.getTransaction().begin();
	c=em.find(Cliente.class, id);
	return c;
	
}

}
