package com.GestionePrenotazioni.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.GestionePrenotazioni.model.Citta;
import com.GestionePrenotazioni.model.Edificio;



public interface EdificioRepository extends PagingAndSortingRepository<Edificio, Long> {
	
	Page<Edificio> findByCitta(Citta citta, Pageable pageable);
	
	Page<Edificio> findByNome(String nome, Pageable pageable);

}
