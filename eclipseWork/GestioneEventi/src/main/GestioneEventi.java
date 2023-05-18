package main;
import model.*;
import util.JpaUtil;
import dao.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;



public class GestioneEventi {

	public static void main(String[] args) {
		/*
		Location location = saveLocation();
		Evento evento = saveEvento(location);
		Persona persona = savePersona();
		
		Partecipazione partecipazione = savePartecipazione(evento,persona);
		
		

*/
		Location location = saveLocation();
		Evento evento = saveEvento(location);
		PartitaDiCalcio pdc=saveParita(evento);
		
		Location l1=new Location();
		l1.setNome("Epicode");
		l1.setCitta("Roma");
		
		LocationDAO ld=new LocationDAO();
		ld.save(l1);
		
		Concerto c1=new Concerto();
		c1.setTitolo("SuperConcerto");
		c1.setDataEvento(LocalDate.now());
		c1.setDescrizione("Super concerto Epicode");
		c1.setGenere(Genere.ROCK);
		c1.setInStreaming(true);
		c1.setLocation(l1);
		c1.setNumeroMassimoPartecipanti(10);
		c1.setTipoEvento(TipoEvento.PRIVATO);
		

		EventoDAO evd1 = new EventoDAO();
		evd1.save(c1);
		
		Persona p1 = new Persona("Mario", "Rossi", "m.rossi@example.com",LocalDate.of(2000, 8, 15),Sesso.MASCHIO);
		
		PersonaDAO pd1 = new PersonaDAO();
		pd1.save(p1);
		

		Partecipazione par1 = new Partecipazione(p1, c1, StatoPartecipazione.CONFERMATA);
		
		PartecipazioneDAO pard1 = new PartecipazioneDAO();
		pard1.save(par1);
		
		
		
	}



	private static Partecipazione savePartecipazione(Evento evento, Persona persona) {
		Partecipazione part = new Partecipazione();
		part.setEvento(evento);
		part.setPersona(persona);
		part.setStato(StatoPartecipazione.CONFERMATA);
		
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
		partecipazioneDAO.save(part);
		return part;
	}

	private static Persona savePersona() {
		Persona per = new Persona();
		per.setNome("Mario");
		per.setCognome("Rossi");
		per.setEmail("m.rossi@google.com");
		per.setSesso(Sesso.MASCHIO);
		per.setDataDiNascita(LocalDate.of(1990, 10, 2));
		PersonaDAO personaDAO = new PersonaDAO();
		personaDAO.save(per);
		return per;
	}

	private static Location saveLocation() {
		Location loc = new Location();
		loc.setCitta("Firenze");
		loc.setNome("Stadio Franchi");
		
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.save(loc);
		return loc;
	}

	private static Evento saveEvento(Location loc) {
		Evento ev = new Evento();
		ev.setDataEvento(LocalDate.now());
		ev.setTitolo("Partita");
		ev.setDescrizione("Finale di coppa");
		ev.setNumeroMassimoPartecipanti(10);
		ev.setTipoEvento(TipoEvento.PUBBLICO);
		ev.setLocation(loc);
		
		EventoDAO evDao = new EventoDAO();
		evDao.save(ev);
		return ev;
	}

	private static PartitaDiCalcio saveParita(Evento e) {
		PartitaDiCalcio pdc=new PartitaDiCalcio();
		pdc.setDataEvento(e.getDataEvento());
		pdc.setDescrizione(e.getDescrizione());
		pdc.setLocation(e.getLocation());
		pdc.setTitolo(e.getTitolo());
		pdc.setTipoEvento(e.getTipoEvento());
		pdc.setNumeroGolDiCasa(5);
		pdc.setNumeroGolSquadraOspite(2);
		pdc.setSquadraVincente("Milan");
		pdc.setNumeroMassimoPartecipanti(e.getNumeroMassimoPartecipanti());
		pdc.setSquadraDiCasa("Milan");
		pdc.setSquadraOspite("Juve");
		
		EventoDAO evDao=new EventoDAO();
		evDao.save(pdc);
		return pdc;
	}
}
