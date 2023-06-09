package com.GestioneDispositivi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestioneDispositivi.models.Dispositivo;

@Repository
public interface DispositivoDAO extends JpaRepository<Dispositivo, Long>{

}
