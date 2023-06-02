package com.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.model.Edificio;

@Repository
public interface EdificioDAORepository extends JpaRepository<Edificio, Long> {

}
