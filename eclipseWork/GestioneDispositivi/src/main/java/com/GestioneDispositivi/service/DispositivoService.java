package com.GestioneDispositivi.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestioneDispositivi.models.Dispositivo;
import com.GestioneDispositivi.repository.DispositivoDAO;

import jakarta.persistence.EntityExistsException;

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
	
	
	public Dispositivo createDispositivo(Dispositivo dispositivo) {
		 return db.save(dispositivo);
		
	}
	
	public String updateDispositivo(Long id,Dispositivo disp) {
			if(!db.existsById(id)) {
				throw new EntityExistsException("Device non esiste");
			}
				db.save(disp);
		 return "Device Modificato: "+db.findById(id).toString();
	}
	
	public String deleteDispositivo(Long id) {
		 db.delete(db.findById(id).get());
		 return "Device Ellinato: "+db.findById(id).get();
	}
	
	public Dispositivo getByIdDispositivo(long id) {
		 return db.findById(id).get();
	}

	public List<Dispositivo> getByALLDispositivo() {
		 return db.findAll();
	}
	
}
