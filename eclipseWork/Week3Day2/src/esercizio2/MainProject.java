package esercizio2;

import java.time.DateTimeException;
import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class MainProject {

	static EntityManagerFactory emf= Persistence.createEntityManagerFactory("Week3Day2");
	static EntityManager em= emf.createEntityManager();
	static Scanner scan=new Scanner(System.in);
	static Studenti st;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("///////////////");
		Studenti s=new Studenti();
		boolean exit=false;
		
		do {

			System.out.println("1-inserisci nuovo Studente");
			System.out.println("2-leggi gli studenti");
			System.out.println("3-leggi un studente");
			System.out.println("4-modifica studente");
			System.out.println("5-Ellimina studente");
			System.out.println("0-exit");
			
		int selected=Integer.parseInt(scan.nextLine());

		switch(selected) {
		
		case 1:
		System.out.println("Inserisci Nome");
		s.setName(scan.nextLine());

		System.out.println("Inserisci Cognome");
		s.setLastname(scan.nextLine());
		
		
		boolean ok=true;
		do {
			System.out.println("Inserisci Genere m/f");
			String gender=scan.nextLine();
			if(gender.equals("m")||gender.equals("f")) {
				s.setGender(gender);
				ok=false;
			}else {
				System.out.println("Inserisci m o f");
			}
			
		}while(ok);
		
		
		
		boolean ok2=true;
		
		System.out.println("Inserisci Compleanno");
		
		do {
		System.out.println("anno/mese/giorno - xxxx-xx-xx");
		try {
		s.setBirthdate(LocalDate.of(Integer.parseInt(scan.nextLine()),Integer.parseInt(scan.nextLine()) ,Integer.parseInt(scan.nextLine())));
		
			ok2=false;
		
		
		}catch(DateTimeException e) {
			System.out.println("valori non corretti");
		}
		
		}while(ok2);
		
		System.out.println("Inserisci avg");
		s.setAvg(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Inserisci voto min");
		s.setMin_voto(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Inserisci voto max");
		s.setMax_voto(Integer.parseInt(scan.nextLine()));
		
		
		insertStudent(s);
		
		break;
		
		case 2:
			
				List<Studenti> listS=leggiAllStudenti();
				System.out.println(listS);
				
				
			break;
			
		case 3:
				System.out.println("Inserisci valore id");
			System.out.println(leggiStudente(Integer.parseInt(scan.nextLine())));
			
			break;
		
		case 4:
			System.out.println("Inserisci valore id");
			 st=leggiStudente(Integer.parseInt(scan.nextLine()));
			System.out.println("Inserisci valore da sostuire con il Cognome");
			st.setLastname(scan.nextLine());
			System.out.println(st);
			
			break;
			
		case 5:
			System.out.println("Inserisci valore id");
			 st=leggiStudente(Integer.parseInt(scan.nextLine()));
			 deleteStudente(st);
			 System.out.println(st);
			break;
		
		case 0:
			exit=true;
			break;
			
		}
		}while(!exit);
		System.out.println("chiusura del programma!");
	}

	
	public static void insertStudent(Studenti s) {
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		System.out.println(s.getName()+" è stato inserito");
	}
	
	public static void updateStudent(Studenti s) {
		em.getTransaction().begin();
		em.merge(s);
		em.getTransaction().commit();
		
	}
	
	public static Studenti leggiStudente(int id) {
		em.getTransaction().begin();
		Studenti s=em.find(Studenti.class, id);
		em.getTransaction().commit();
		return s;
	}
	
	public static List<Studenti> leggiAllStudenti(){
		em.getTransaction().begin();
		
		String sql="SELECT name FROM studenti";
		Query query=em.createNativeQuery(sql);
		 List<Studenti> s=query.getResultList();
		 return s;
	}
	
	public static void deleteStudente(Studenti s) {
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
	}
	
}
