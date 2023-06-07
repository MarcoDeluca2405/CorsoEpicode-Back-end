package com.GestionePrenotazioni.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.model.User;



public interface PrenotazioneRepository extends PagingAndSortingRepository<Prenotazione, Long>  {
	
	public Page<Prenotazione> findByUserAndDataPrenotata(User user, LocalDate dataPrenotata, Pageable pageable);
	
	public Page<Prenotazione> findByUser(User user, Pageable pageable);
	
	

}
