package com.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.model.Utente;
import com.GestionePrenotazioni.repository.UtenteDAORepository;

@Service
public class UtenteService {
	
	@Autowired UtenteDAORepository db;
	
	@Autowired @Qualifier("UtenteFake") ObjectProvider<Utente> utenteFakeProvider;
	@Autowired @Qualifier("newUtente") ObjectProvider<Utente> newUtenteProvider;
	
	
	public Utente createUtenteFake() {
		return utenteFakeProvider.getObject();
	}
	
	public Utente createNewUtente() {
		return newUtenteProvider.getObject();
	}

	
	public void insertUtente(Utente u) {
		db.save(u);
		System.out.println("Utente: "+u.getNome()+" Salvato nel DB");
	}
	
	public void updateUtente(Utente u) {
		db.save(u);
		System.out.println("Utente: "+u.getNome()+"Modificato e Salvato nel DB");
	}
	
	public void deleteUtente(Utente u) {
		db.delete(u);
		System.out.println("Utente: "+u.getNome()+" Cancellato nel DB");
	}
	

	public List<Utente> getAllName(String nome){
		return db.findByNome(nome);
	}
	
	
	public List<Utente> getAll(){
		return db.findAll();
	}
}
