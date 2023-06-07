package com.GestionePrenotazioni.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.model.Utente;
import com.GestionePrenotazioni.repository.UtenteDAORepository;
import com.GestionePrenotazioni.repository.UtentePageableRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteService {
	
	@Autowired UtenteDAORepository db;
	@Autowired UtentePageableRepository pg_db;
	
	@Autowired @Qualifier("UtenteFake") ObjectProvider<Utente> utenteFakeProvider;
	@Autowired @Qualifier("newUtente") ObjectProvider<Utente> newUtenteProvider;
	
	
	public Utente createUtenteFake() {
		return utenteFakeProvider.getObject();
	}
	
	public Utente createNewUtente() {
		return newUtenteProvider.getObject();
	}
	
	
	public Utente create(Utente user) {
		// Gestione di un errore | email già presente
		if(db.existsById((long)user.getId())) {
			throw new EntityNotFoundException("Email exists!!");
		}
		return db.save(user);
	}

	
	public void insertUtente(Utente u) {
		if(!db.existsById((long)u.getId())) {
		throw new EntityExistsException("Utetne già prensente");
		}
		db.save(u);
		System.out.println("Utente: "+u.getNome()+" Salvato nel DB");
	}
	
	public void updateUtente(Utente u) {
		if(!db.existsById((long)u.getId())){
			throw new EntityExistsException("Utente non trovato");
		}
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
	
	
	public Page<Utente> getPegeableAll(Pageable pageable){
		return (Page<Utente>) pg_db.findAll((Sort) pageable);
	}
	
	
	
	public List<Utente> getAll(){
		return db.findAll();
	}
	
	public Utente getById(int id) {
		if(!db.existsById((long)id)){
			throw new EntityExistsException("Utente non trovato");
		}
		return db.findById(id);
	}
}
