package com.GestioneDispositivi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.GestioneDispositivi.enumeration.Status;
import com.GestioneDispositivi.models.Dispositivo;
import com.GestioneDispositivi.repository.DispositivoDAO;
import com.GestioneDispositivi.repository.UsersDAO;
import com.GestioneDispositivi.security.entity.User;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired UsersDAO db;
	@Autowired DispositivoDAO dbd;
	
	public User createUser(User user) {
		if(db.existsByUsername(user.getUsername())) {
			throw new EntityNotFoundException("Username exist");
		}
		return db.save(user);
	}
	
	public String addDispositivo(User user,Dispositivo dispositivo) {
		user.getDispositivi().add(dispositivo);
		dispositivo.setStatus(Status.ASSEGNATO);
		dbd.save(dispositivo);
		db.save(user);
		return "Utente ha salvato il dispostivo";
	}
	
	public String deleteDispositivo(User user,Dispositivo dispositivo) {
		user.getDispositivi().remove(dispositivo);
		dispositivo.setStatus(Status.DISPONIBILE);
		dbd.save(dispositivo);
		db.save(user);
		return "Utente ha rimossso il dispositivo";
	}
	
	public List<User> getAllUser(){
		return db.findAll();
	}
	
	public User getByIdUser(long id) {
		return db.findById(id).get();
	}
}
