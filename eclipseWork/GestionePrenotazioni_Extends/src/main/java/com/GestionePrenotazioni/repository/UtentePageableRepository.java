package com.GestionePrenotazioni.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.model.Utente;

@Repository
public interface UtentePageableRepository extends PagingAndSortingRepository<Utente, Long>{

}
