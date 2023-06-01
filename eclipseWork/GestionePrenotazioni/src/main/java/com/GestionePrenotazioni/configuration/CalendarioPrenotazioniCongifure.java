package com.GestionePrenotazioni.configuration;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.model.CalendarioPrenotazioni;
import com.GestionePrenotazioni.model.Postazione;

@Configuration
public class CalendarioPrenotazioniCongifure {

	
	@Bean("newPrenotazioneCalender")
	@Scope("singleton")
	public CalendarioPrenotazioni newCalendarioPrenotazioni(LocalDate data,Postazione postazione){
		return new CalendarioPrenotazioni(data,postazione);
	}
	
}
