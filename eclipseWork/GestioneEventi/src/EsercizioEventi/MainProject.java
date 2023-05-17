package EsercizioEventi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProject {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("GestioneEventi");
	static EntityManager em=emf.createEntityManager();
	static Scanner scan=new Scanner(System.in);
	static Evento e;
	static int id;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean finish=true;
		int scelta;

		try {
		do {
			
			System.out.println("1-save Evento");
			System.out.println("2-Leggi Evento");
			System.out.println("3-Ellimina Evento ");
			System.out.println("4-Ricarica Evento");
			System.out.println("0-Exit");
			
			scelta=Integer.parseInt(scan.nextLine());
			
			switch(scelta){
				
				
				case 1:
					
							System.out.println("inserisci in sequenza, Titolo, data evento,descrizione, numero massimo di persone");
							
							System.out.println("Titolo");
							String titolo=scan.nextLine();
							System.out.println("data");
							LocalDate data=LocalDate.of(Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()));
							System.out.println("descrizione");
							String descrizione=scan.nextLine();
							System.out.println("numero massimo participanti");
							int num=Integer.parseInt(scan.nextLine());
							
							e=new Evento(titolo,data,descrizione,tipoEvento.PUBLICO,num);
							
							save(e);
					break;
					
				case 2:
							
						System.out.println("quale id vuoi ricercare?");
						 id=Integer.parseInt(scan.nextLine());
						System.out.println(getById(id));
						
					break;
					
				case 3:
					
					System.out.println("quale id vuoi cancellare?");
					 id=Integer.parseInt(scan.nextLine());
					Evento ev=getById(id);
					deleteE(ev);
					 System.out.println("è stato cancellato"+e.getTitolo());
					break;
					
				case 4:
					
					refresh(e);
					System.out.println("il database è stato ripristinato");
					
					break;
					
					
				case 0:
						
					finish=false;
					
					break;
				
			}
			
		}while(finish);
		}catch(Exception e) {
			e.getMessage();
		}finally {
		System.out.println("exit programm...");
		em.close();
		emf.close();
		}
	}

	
	public static void save(Evento e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("Evento: "+e.getNumeroMassimoPartecipanti()+" è stato salvato");
	}
	
	
	public static Evento  getById(int id) {
		
		em.getTransaction().begin();
		Evento e=em.find(Evento.class, id);
		em.getTransaction().commit();
		return e;
	}
	
	
	public static void deleteE(Evento e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
	
	public static void refresh(Evento e) {
		em.getTransaction().begin();
		em.refresh(e);
		em.getTransaction().commit();
	}
	
}
