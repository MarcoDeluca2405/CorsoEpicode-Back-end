package com.GestioneDispositivi.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestioneDispositivi.models.Dispositivo;
import com.GestioneDispositivi.repository.DispositivoDAO;

@Service
public class DispositivoService {

	@Autowired DispositivoDAO db;
	@Autowired @Qualifier("fakeDeviceSmartPhone") ObjectProvider<Dispositivo> phoneFakeProvider;
	@Autowired @Qualifier("fakeDevicelaptop") ObjectProvider<Dispositivo> laptopFakeProvider;
	@Autowired @Qualifier("fakeDeviceTablet") ObjectProvider<Dispositivo> tabletFakeProvider;
	
	public Dispositivo createFakePhone() {
		return phoneFakeProvider.getObject();
	}
	public Dispositivo createFakeLaptop() {
		return laptopFakeProvider.getObject();
	}
	public Dispositivo createFakeTablet() {
	return	tabletFakeProvider.getObject();
	}
	
	
	public void createDispositivo(Dispositivo dispositivo) {
		 db.save(dispositivo);
		
	}
	
	public void updateDispositivo(Dispositivo dispositivo) {
		 db.save(dispositivo);
	}
	
	public void deleteDispositivo(Dispositivo dispositivo) {
		 db.delete(dispositivo);
	}
	
	public Dispositivo getByIdDispositivo(long id) {
		 return db.findById(id).get();
	}

	public List<Dispositivo> getByALLDispositivo() {
		 return db.findAll();
	}
	
}
