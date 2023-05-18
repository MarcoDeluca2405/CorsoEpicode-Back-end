package main;
import model.*;
import util.JpaUtil;
import dao.*;

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
		per.setDataDiNascita(new GregorianCalendar(1980,9, 23).getTime());
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
		ev.setDataEvento(new Date());
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
