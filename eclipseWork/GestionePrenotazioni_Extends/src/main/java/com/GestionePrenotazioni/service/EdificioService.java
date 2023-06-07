package com.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.model.Edificio;
import com.GestionePrenotazioni.repository.EdificioDAORepository;

@Service
public class EdificioService {

	@Autowired EdificioDAORepository db;
	
	@Autowired @Qualifier("fakeEdificio") ObjectProvider<Edificio> fakeEdificioProvider;
	
	
	public Edificio createEdificioFake() {
		return fakeEdificioProvider.getObject();
	}
	
	
	public void insertEdificio(Edificio e) {
		db.save(e);
		System.out.println("Edificio "+e.getNome()+" salvato nel DB");
	}
	
	public void updateEdificio(Edificio e) {
		db.save(e);
		System.out.println("Edificio "+e.getNome()+"Modificato e salvato nel DB");
	}
	
	public void deleteEdificio(Edificio e) {
		db.delete(e);
		System.out.println("Edificio "+e.getNome()+" Cancellato nel DB");
	}
	
	public List<Edificio> getAllEdificio() {
	return db.findAll();
	}
	
}
