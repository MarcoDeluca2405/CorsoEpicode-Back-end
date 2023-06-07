package com.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.Enum.Tipo;
import com.GestionePrenotazioni.model.Postazione;
import java.util.List;


@Repository
public interface PostazioneDAORepositery  extends JpaRepository<Postazione, Long>{
		public Postazione findById(int id);
		
		@Query("SELECT p FROM Postazione p WHERE tipo= :tipo AND edificio.citta= :citta")
		public Postazione findBytipoAndedificioBycitta(Tipo tipo,String citta);
}
