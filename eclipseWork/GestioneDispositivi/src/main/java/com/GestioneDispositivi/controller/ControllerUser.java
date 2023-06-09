package com.GestioneDispositivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestioneDispositivi.security.entity.User;
import com.GestioneDispositivi.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/utente")
public class ControllerUser {
	
	@Autowired UserService us;
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> allUser(){
		List<User> user=us.getAllUser();
	return	new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<?> createuser(@RequestBody User user){
		return ResponseEntity.ok(us.createUser(user));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteuser(@PathVariable long id){
		return ResponseEntity.ok(us.removeUser(id));
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR') or hasRole('USER')")
	public ResponseEntity<?> getbyId(@PathVariable long id){
		return ResponseEntity.ok(us.getByIdUser(id));
	}
	
	@PostMapping("/{id_user}/Device/{id_device}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public String addDeviceUser(@PathVariable long id_user, @PathVariable long id_device){
		System.out.println(id_user+" "+id_device);
		return us.addDispositivo(id_user, id_device);
	}

	@DeleteMapping("/{id_user}/Device/{id_device}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public String removeDeviceUser(@PathVariable long id_user, @PathVariable long id_device){
		System.out.println(id_user+" "+id_device);
		return us.deleteDispositivo(id_user, id_device);
	}
	
	@PutMapping()
	@PreAuthorize("hasRole('ADMIN')or hasRole('MODERATOR')")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		return ResponseEntity.ok(us.updateUser(user));
	}
}
