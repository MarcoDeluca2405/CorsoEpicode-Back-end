package com.GestionePrenotazioni.repository;

import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.model.CalendarioPrenotazioni;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CalendarioDAORepository extends JpaRepository<CalendarioPrenotazioni,Long>{

	
	
}
