package com.GestionePrenotazioni.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.model.CalendarioPrenotazioni;
import com.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.repository.CalendarioDAORepository;

@Service
public class CalendarioPrenotazioniService {

	@Autowired CalendarioDAORepository db;
	
	@Autowired @Qualifier("newPrenotazioneCalender") ObjectProvider<CalendarioPrenotazioni> newPrenotazioneCalendarioProvider;
	
	
	
	public CalendarioPrenotazioni newPrenotazioneCalendario() {
		return newPrenotazioneCalendarioProvider.getObject();
		
	}
	
	
	public void insertCalendarioPrenotazioni(CalendarioPrenotazioni c) {
		db.save(c);
		System.out.println("Appuntameto salvato nel DB");
	}
	
	
	public void updateCalendarioPrenotazioni(CalendarioPrenotazioni c) {
		db.save(c);
		System.out.println("Appuntameto Modificato e salvato nel DB");
	}
	
	public void deleteCalendarioPrenotazioni(CalendarioPrenotazioni c) {
		db.delete(c);
		System.out.println("Appuntameto Cancellato nel DB");
	}
	
	public List<CalendarioPrenotazioni> AllCalendarioPrenotazioni() {
		return db.findAll();
	}
	
	
}
