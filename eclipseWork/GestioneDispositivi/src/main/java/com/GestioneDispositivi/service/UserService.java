package com.GestioneDispositivi.service;

import java.util.List;
import java.util.Optional;

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
	
	public String addDispositivo(Long id_user,Long id_device) {
		db.findById(id_user).get().getDispositivi().add(dbd.findById(id_device).get());
		dbd.findById(id_device).get().setStatus(Status.ASSEGNATO);
		dbd.save(dbd.findById(id_device).get());
		db.save(db.findById(id_user).get());
		return "Utente ha salvato il dispostivo";
	}
	
	public String deleteDispositivo(Long id_user,Long id_device) {
		db.findById(id_user).get().getDispositivi().remove(dbd.findById(id_device).get());
		dbd.findById(id_device).get().setStatus(Status.DISPONIBILE);
		dbd.save(dbd.findById(id_device).get());
		db.save(db.findById(id_user).get());
		return "Utente ha rimossso il dispositivo";
	}
	
	public List<User> getAllUser(){
		return db.findAll();
	}
	
	public User getByIdUser(long id) {
		return db.findById(id).get();
	}
	
	public String removeUser(long id) {
		db.deleteById(id);
		return "Utente Elliminato";
	}
}
