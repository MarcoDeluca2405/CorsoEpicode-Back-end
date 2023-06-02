package com.GestionePrenotazioni.runner;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.Enum.Tipo;
import com.GestionePrenotazioni.model.CalendarioPrenotazioni;
import com.GestionePrenotazioni.model.Edificio;
import com.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.model.Utente;
import com.GestionePrenotazioni.service.CalendarioPrenotazioniService;
import com.GestionePrenotazioni.service.EdificioService;
import com.GestionePrenotazioni.service.PostazioneService;
import com.GestionePrenotazioni.service.UtenteService;

@Component
public class GestionePrenotazioniRunner implements ApplicationRunner {

	@Autowired private UtenteService utenteService;
	@Autowired private CalendarioPrenotazioniService calendarioPrenotazioniService;
	@Autowired private EdificioService edificioService;
	@Autowired private PostazioneService postazioneService;
	
	private List<Utente> u;
	private List<Edificio> e;
	private List<Postazione> p;
	private List<CalendarioPrenotazioni> c;
	private Tipo tipo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//Lettura Db e popolamento liste
		u=utentiDb();
		e=edificiDb();
		p=postazioniDb();
		c=calendarioPrenotazioniDb();
		//System.out.println(utenteService.getById(87));
		
		//Creazione di una Prenotazione
		createCalendarioPrenotazioni(utenteService.getById(114),LocalDate.of(2024, 1, 10),postazioneService.findById(130));
		
		
		//Ricerca per tipo postazione e citta
		
	Postazione p=ricercaPostazioneDesiderata(tipo.OPENSPACE, "Caruso salentino");
		System.out.println(p);
		
		//creazione 10 utenti
		
		//tenUtente();
		
		//creazione 6 edifici
		
		//sixEdificio();
		
		//Creazione Postazione
		
		
		//createPostazione(e.get(1));
		
		
		//lettura utenti nel DB
		
			
			//u.forEach(utenti->System.out.println(utenti.getId()+" "+utenti.getUsername()));
		
		
		
		//lettura edifici nel DB
		
		
		//e.forEach(ed->System.out.println("\n id:"+ed.getId()+" "+ed.getCitta()+" "+ed.getIndirizzo()+" "+ed.getNome()));
		
		
		//lettura delle Postazioni nel DB
	
	
		//p.forEach(po->System.out.println("\n id: "+po.getId()+" descrizione: "+po.getDescrizione()+" tipo: "+po.getTipo()+" nome del edificio: "+po.getEdificio().getNome()));
		
	}
	
	
	public void tenUtente() {
		
		//Creazione 10 persone fake
		
				for(int i=0;i<10;i++) {
					
					Utente u=utenteService.createUtenteFake();
					utenteService.insertUtente(u);
					
				}
				
	}

	public List<Utente> utentiDb(){
		return utenteService.getAll();
	}
	
	
	public List<Edificio> edificiDb(){

		return edificioService.getAllEdificio();
	}
	
	public List<Postazione> postazioniDb(){
		return postazioneService.getAll();
	}
	
	public List<CalendarioPrenotazioni> calendarioPrenotazioniDb(){
		return calendarioPrenotazioniService.AllCalendarioPrenotazioni();
	}
	
	public void sixEdificio() {
		for(int i=0;i<6;i++) {
			Edificio e=edificioService.createEdificioFake();
			edificioService.insertEdificio(e);
		}
	}
	
	public void createPostazione(Edificio e) {
		Postazione p=postazioneService.createPostazione();
		p.setDescrizione("Runione");
		p.setEdificio(e);
		p.setMax_occpuanti(50);
		p.setTipo(Tipo.PRIVATO);
		postazioneService.insertPostazione(p);
		
		Postazione p2=postazioneService.createPostazione();
		p2.setDescrizione("Mercatone di Frutta");
		p2.setEdificio(e);
		p2.setMax_occpuanti(100);
		p2.setTipo(Tipo.OPENSPACE);
		postazioneService.insertPostazione(p2);
		
		Postazione p3=postazioneService.createPostazione();
		p3.setDescrizione("Sala Riunioni");
		p3.setEdificio(e);
		p3.setMax_occpuanti(75);
		p3.setTipo(Tipo.SALA_RIUNIONI);
		postazioneService.insertPostazione(p3);
		
	}
	
	
	public void createCalendarioPrenotazioni(Utente utente,LocalDate data,Postazione postazione) {
		
		u=utentiDb();
		c=calendarioPrenotazioniDb();
		System.out.println(c);
		System.out.println(c.isEmpty());
		
		if(!c.isEmpty()) {
		for(CalendarioPrenotazioni prenotato:c) {
		System.out.println("ciao");
			if(!prenotato.getGiornoPrenotato().equals(data)||postazione.isLibero()) {
				
				
				createCalender(utente,data,postazione);
				
			}else {
				
				
				List<CalendarioPrenotazioni> existPrenotazioni=utente.getCal_prenotazioni();
				for(CalendarioPrenotazioni prenotazioni:existPrenotazioni) {
				
					
					if(!prenotazioni.getGiornoPrenotato().equals(data) || postazione.isLibero()) {
						createCalender(utente,data,postazione);
					}else {
						
						System.out.println("Questa data è stata già prenotata da un altro");
							
					}
					
				}
				
				System.out.println("Questa data è stata già prenotata da un altro");
			}
			
			
		}
		
		
		}else {
			
			createCalender(utente,data,postazione);
		}
		
			
		
		
	}
	
	public void createCalender(Utente utente,LocalDate data,Postazione postazione) {
		
		CalendarioPrenotazioni cp=calendarioPrenotazioniService.newPrenotazioneCalendario();
		cp.setGiornoPrenotato(data);
		cp.setPostazione(postazione);
		/*
		Postazione newPostazioneLibero= postazioneService.createPostazione();
		newPostazioneLibero.setDescrizione(postazione.getDescrizione());
		newPostazioneLibero.setEdificio(postazione.getEdificio());
		newPostazioneLibero.setMax_occpuanti(postazione.getMax_occpuanti());
		newPostazioneLibero.setTipo(postazione.getTipo());
		postazioneService.insertPostazione(newPostazioneLibero);
		*/
		postazione.setLibero(false);
		postazioneService.insertPostazione(postazione);
		calendarioPrenotazioniService.insertCalendarioPrenotazioni(cp);
		utente.getCal_prenotazioni().add(cp);
		utenteService.insertUtente(utente);
	}

	
	public Postazione ricercaPostazioneDesiderata(Tipo t,String citta) {
		return postazioneService.findTipoAndCity(t, citta);
		
	}
}
