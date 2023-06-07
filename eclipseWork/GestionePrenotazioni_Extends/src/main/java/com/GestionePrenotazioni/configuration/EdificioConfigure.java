package com.GestionePrenotazioni.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.model.Edificio;
import com.github.javafaker.Faker;

@Configuration
public class EdificioConfigure {

	
	@Bean("fakeEdificio")
	@Scope("prototype")
	public Edificio edificioFake() {
		Faker fake=Faker.instance(new Locale("it-IT"));
		Edificio e=new Edificio();
		e.setCitta(fake.address().cityName());
		e.setIndirizzo(fake.address().streetAddress());
		e.setNome(fake.company().name());
		return e;
	}
	
}
