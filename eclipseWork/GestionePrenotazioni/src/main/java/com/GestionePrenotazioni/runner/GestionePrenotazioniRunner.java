package com.GestionePrenotazioni.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.model.Utente;
import com.GestionePrenotazioni.service.UtenteService;

@Component
public class GestionePrenotazioniRunner implements ApplicationRunner {

	@Autowired private UtenteService utenteService;
	
	
	private List<Utente> u;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//creazione 10 utenti
		
		//tenUtente();
		
		//lettura utenti nel DB
			u=utentiDb();
			u.forEach(utenti->System.out.println(utenti.getId()+" "+utenti.getUsername()));
		
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
	
}
