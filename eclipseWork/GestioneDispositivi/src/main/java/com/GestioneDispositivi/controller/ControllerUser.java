package com.GestioneDispositivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestioneDispositivi.security.entity.User;
import com.GestioneDispositivi.security.payload.RegisterDto;
import com.GestioneDispositivi.security.service.AuthService;
import com.GestioneDispositivi.service.UserService;

@RestController
@RequestMapping("/api/utente")
public class ControllerUser {
	
	@Autowired UserService us;
	private AuthService authService;
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> allUser(){
		List<User> user=us.getAllUser();
	return	new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<?> createuser(@RequestBody RegisterDto registerDto){
		  String response = authService.register(registerDto);
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
