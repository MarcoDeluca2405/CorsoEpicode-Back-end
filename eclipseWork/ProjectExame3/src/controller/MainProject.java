package controller;
import java.time.LocalDate;
import java.util.List;

import Enum.Periodicita;
import dao.LibriDAO;
import dao.CatalogoDAO;
import dao.RivisteDAO;
import model.*;

public class MainProject {
	public static LibriDAO ld= new LibriDAO();
	public static RivisteDAO rd=new RivisteDAO();
	public static CatalogoDAO cd=new CatalogoDAO();

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
		
		List<Catalogo> c=cd.getAll();
		List<Libri> ll=ld.getAll();
		List<Riviste>rl=rd.getAll();
		List<Catalogo> cfp=cd.getFindAnnoPublciazione(1996);
		List<Catalogo> cA=cd.getFindAutore("M.V.");
		List<Catalogo> cT=cd.getFindTitolo("Signore Degli anelli");
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
		
		
		
	}

	
	
}
