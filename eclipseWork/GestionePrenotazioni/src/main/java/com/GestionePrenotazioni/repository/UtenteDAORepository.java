package com.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.model.Utente;
import java.util.List;



@Repository
public interface UtenteDAORepository extends JpaRepository<Utente, Long> {

	public List<Utente> findByNome(String name);
	
}
