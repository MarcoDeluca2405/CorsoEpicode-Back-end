package com.GestionePrenotazioni.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.model.Utente;
import com.github.javafaker.Faker;

@Configuration
public class UtenteConfiguration {

	
	@Bean("UtenteFake")
	@Scope("prototype")
	public Utente utenteFake() {
		Faker fake= Faker.instance(new Locale("it-IT"));
		Utente utenteFake=new Utente();
		utenteFake.setUsername(fake.name().username());
		utenteFake.setNome(fake.name().fullName());
		utenteFake.setEmail(fake.internet().emailAddress());
		return utenteFake;
	}
	
	@Bean("newUtente")
	@Scope("prototype")
	public Utente newUtente(String username,String name,String email) {
		return new Utente(username,name,email);
	}
	
	
	
}
