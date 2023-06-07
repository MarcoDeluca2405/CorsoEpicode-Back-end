package com.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.Enum.Tipo;
import com.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.repository.PostazioneDAORepositery;

@Service
public class PostazioneService {

	@Autowired PostazioneDAORepositery db;
	
	@Autowired @Qualifier("createPostazione") ObjectProvider<Postazione> createPostazioneProvider;
	
	
	public Postazione createPostazione() {
		return createPostazioneProvider.getObject();
	}
	
	public void insertPostazione(Postazione p) {
		db.save(p);
		System.out.println("Postazione "+p.getId()+" "+p.getDescrizione()+" salvato nel DB");
	}
	
	public void updatePostazione(Postazione p) {
		db.save(p);
		System.out.println("Postazione "+p.getId()+" "+p.getDescrizione()+"modificato e salvato nel DB");
	}
	
	public void deletePostazione(Postazione p) {
		db.delete(p);
		System.out.println("Postazione "+p.getId()+" "+p.getDescrizione()+" Cancellato nel DB");
	}
	
	public List<Postazione>getAll() {
		return db.findAll();
	}
	
	public Postazione findById(int id) {
		return db.findById(id);
	}
	
	public Postazione findTipoAndCity(Tipo t,String city) {
		return db.findBytipoAndedificioBycitta(t, city);
	}
	
}
