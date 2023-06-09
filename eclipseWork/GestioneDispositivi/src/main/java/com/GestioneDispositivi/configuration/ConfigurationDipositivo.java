package com.GestioneDispositivi.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestioneDispositivi.enumeration.Status;
import com.GestioneDispositivi.enumeration.Tipo_connettività;
import com.GestioneDispositivi.models.Dispositivo;
import com.GestioneDispositivi.models.Laptop;
import com.GestioneDispositivi.models.Smartphone;
import com.GestioneDispositivi.models.Tablet;
import com.github.javafaker.Faker;


@Configuration
public class ConfigurationDipositivo {

	
	@Bean("fakeDeviceSmartPhone")
	@Scope("prototype")
	public Dispositivo fakeDeviceSmartPhone() {
		Faker fk=Faker.instance(new Locale("it-IT"));
		Smartphone sm=new Smartphone();
		sm.setConnettività(Tipo_connettività.QUATRO_G);
		sm.setCPU_core(fk.random().nextInt(2, 5));
		sm.setModel(fk.code().gtin13());
		sm.setStatus(Status.DISPONIBILE);
		sm.setStorage(fk.random().nextInt(256, 1256));
		sm.setStorage_RAM(fk.random().nextInt(2,8));
		return sm;
	}
	
	@Bean("fakeDevicelaptop")
	@Scope("prototype")
	public Dispositivo fakeDeviceLaptop() {
		Faker fk=Faker.instance(new Locale("it-IT"));
		Laptop lp=new Laptop();
		lp.setScheda_video(fk.code().gtin13());;
		lp.setCPU_core(fk.random().nextInt(2, 5));
		lp.setModel(fk.code().gtin13());
		lp.setStatus(Status.DISPONIBILE);
		lp.setStorage(fk.random().nextInt(256, 1256));
		lp.setStorage_RAM(fk.random().nextInt(2,8));
		return lp;
	}
	
	@Bean("fakeDeviceTablet")
	@Scope("prototype")
	public Dispositivo fakeDeviceTablet() {
		Faker fk=Faker.instance(new Locale("it-IT"));
		Tablet tb=new Tablet();
		tb.setTipo_display("Amoled");
		tb.setCPU_core(fk.random().nextInt(2, 5));
		tb.setModel(fk.code().gtin13());
		tb.setStatus(Status.DISPONIBILE);
		tb.setStorage(fk.random().nextInt(256, 1256));
		tb.setStorage_RAM(fk.random().nextInt(2,8));
		return tb;
	}
	
}
