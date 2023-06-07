package com.GestionePrenotazioni.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionePrenotazioni.model.Utente;
import com.GestionePrenotazioni.repository.UtenteDAORepository;
import com.GestionePrenotazioni.service.UtenteService;

@RestController
@RequestMapping("/api/utente")
public class UtenteController {
	@Autowired private UtenteService utenteService;
	
	@GetMapping
	public ResponseEntity<List<Utente>> getAllUtente(){
		return ResponseEntity.ok(utenteService.getAll());
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Utente>> getPageableAllUtente(Pageable pageable){
		return ResponseEntity.ok(utenteService.getPegeableAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUtenteById(@PathVariable int id){
		return ResponseEntity.ok(utenteService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody Utente utente){
		return ResponseEntity.ok(utenteService.create(utente));
	}
	
}
