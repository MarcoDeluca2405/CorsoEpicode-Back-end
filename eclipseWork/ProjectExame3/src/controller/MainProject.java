package controller;
import java.time.LocalDate;
import java.util.List;

import Enum.Periodicita;
import dao.LibriDAO;
import dao.PrestitoDAO;
import dao.CatalogoDAO;
import dao.RivisteDAO;
import dao.UtenteDAO;
import model.*;

public class MainProject {
	public static LibriDAO ld= new LibriDAO();
	public static RivisteDAO rd=new RivisteDAO();
	public static CatalogoDAO cd=new CatalogoDAO();
	public static UtenteDAO ud=new UtenteDAO();
	public static PrestitoDAO pd=new PrestitoDAO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Libri l=new Libri();
		l.setTitolo("Signore Degli anelli");
		l.setAnnopublicazione(1996);
		l.setGenere("Fantasy");
		l.setNumeropagine(200);
		l.setAutore("Galdaf");
		
		Libri l2=new Libri();
		l2.setTitolo("Marvel");
		l2.setAnnopublicazione(2003);
		l2.setGenere("Fantasy");
		l2.setNumeropagine(500);
		l2.setAutore("M.V.");
		
		Riviste r=new Riviste();
		r.setTitolo("Uomo ucciso in collina");
		r.setAnnopublicazione(1996);
		r.setNumeropagine(5);
		r.setPeriodicita(Periodicita.MENSILE);
		
		Riviste r2=new Riviste();
		r2.setTitolo("Non si trova piu' lavoro");
		r2.setAnnopublicazione(2023);
		r2.setNumeropagine(8);
		r2.setPeriodicita(Periodicita.SEMESTRALE);
		
		
		cd.save(r);
		cd.save(r2);
		cd.save(l);
		cd.save(l2);
		
		
		Utente u1=new Utente();
		u1.setNome("Marco");
		u1.setCognome("De Luca");
		u1.setDataDiNascita(LocalDate.of(1996, 05, 24));
		
		Utente u2=new Utente();
		u2.setCognome("Dolce");
		u2.setNome("Gabbana");
		u2.setDataDiNascita(LocalDate.of(1875, 10, 23));
		
		Utente u3=new Utente();
		u3.setCognome("Francesco");
		u3.setNome("Dormi");
		u3.setDataDiNascita(LocalDate.of(2005, 11, 2));
		
		ud.save(u1);
		ud.save(u2);
		ud.save(u3);
		
		Prestito p1=new Prestito();
		p1.setElementoPrestato(l);
		p1.setInizioPrestito(LocalDate.of(2023, 05, 19));
		p1.setRestituzioneEffettiva(LocalDate.of(2023, 05, 24));
		p1.setRestitutizionePrevista(p1.getInizioPrestito());
		p1.setUtente(u1);
		
		Prestito p2=new Prestito();
		p2.setElementoPrestato(l2);
		p2.setInizioPrestito(LocalDate.of(2020, 05, 19));
		p2.setRestituzioneEffettiva(LocalDate.of(2023, 05, 24));
		p2.setRestitutizionePrevista(p2.getInizioPrestito());
		p2.setUtente(u2);
		
		Prestito p3=new Prestito();
		p3.setElementoPrestato(r);
		p3.setInizioPrestito(LocalDate.of(2022, 05, 19));
		p3.setRestituzioneEffettiva(LocalDate.of(2023, 06, 24));
		p3.setRestitutizionePrevista(p3.getInizioPrestito());
		p3.setUtente(u3);
		
		Prestito p4=new Prestito();
		p4.setElementoPrestato(l2);
		p4.setInizioPrestito(LocalDate.of(2023, 02, 2));
		p4.setRestituzioneEffettiva(LocalDate.of(2023, 03, 20));
		p4.setRestitutizionePrevista(p3.getInizioPrestito());
		p4.setUtente(u1);
		
		pd.save(p1);
		pd.save(p2);
		pd.save(p3);
		pd.save(p4);
		
		
		List<Catalogo> c=cd.getAll();
		List<Libri> ll=ld.getAll();
		List<Riviste>rl=rd.getAll();
		List<Catalogo> cfp=cd.getFindAnnoPublciazione(1996);
		List<Catalogo> cA=cd.getFindAutore("M.V.");
		List<Catalogo> cT=cd.getFindTitolo("Signore Degli anelli");
		
		List<Utente> ut=ud.getAll();
		List<Prestito> lp=pd.getAll();
		
		List<Prestito> lpt=pd.getAllElement(2);
		List<Prestito> lpd=pd.getAllElementOverDate(LocalDate.of(2023, 06, 1));
		System.out.println("//////////////");
		System.out.println("Catalogo:");
		c.forEach(lc-> System.out.println(lc));
		
		
		System.out.println("//////////////");
		System.out.println("Libri:");
		ll.forEach(ll1->System.out.println(ll1));
		
		
		System.out.println("//////////////");
		System.out.println("Riviste:");
		rl.forEach(rl1->System.out.println(rl1));
		
		
		System.out.println("//////////////");
		System.out.println("Ricerca in base l'anno");
		cfp.forEach(lc->System.out.println(lc));
		
		
		System.out.println("//////////////");
		System.out.println("Ricerca in base l'autore");
		cA.forEach(lc->System.out.println(lc));
		
		System.out.println("//////////////");
		System.out.println("Ricerca in base al Titolo");
		cT.forEach(lc->System.out.println(lc));
		
		System.out.println("//////////////");
		System.out.println("Eliminazione in base ISBN");	
		cd.deleteByid(2);
		List<Catalogo> nc=cd.getAll();
		
		System.out.println("//////////////");
		System.out.println("Nuovo Catalogo:");
		nc.forEach(lc->System.out.println(lc));
		
		System.out.println("//////////////");
		System.out.println("Lista utenti:");
		ut.forEach(lc->System.out.println(lc));
		
		
		System.out.println("//////////////");
		System.out.println("Lista Prestito:");
		lp.forEach(lc->System.out.println(lc));
		
		System.out.println("//////////////");
		System.out.println("Lista prestiti numero utente:");
		lpt.forEach(lc->System.out.println(lc));
		
		System.out.println("//////////////");
		System.out.println("Lista prestiti Scaduti utente:");
		lpd.forEach(lc->System.out.println(lc));
	}

	
	
}
