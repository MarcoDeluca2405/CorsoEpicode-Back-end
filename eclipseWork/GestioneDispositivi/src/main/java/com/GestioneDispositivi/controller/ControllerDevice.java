package com.GestioneDispositivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestioneDispositivi.models.Dispositivo;
import com.GestioneDispositivi.models.Laptop;
import com.GestioneDispositivi.models.Smartphone;
import com.GestioneDispositivi.models.Tablet;
import com.GestioneDispositivi.repository.DispositivoDAO;
import com.GestioneDispositivi.service.DispositivoService;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@RestController
@RequestMapping("/api/device")

public class ControllerDevice {

	@Autowired DispositivoService ds;
		
	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR') or hasRole('USER')")
	public ResponseEntity<?> getAllDevice(){
		List<Dispositivo> disp=ds.getByALLDispositivo();
		return new ResponseEntity<>(disp,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByIdDevice(@PathVariable long id){
		return ResponseEntity.ok(ds.getByIdDispositivo(id));
	}
	
	@PostMapping("/Laptop")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> createDevice(@RequestBody Laptop disp){
		return ResponseEntity.ok(ds.createDispositivo(disp));
	}
	
	@PostMapping("/SmartPhone")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> createDevice(@RequestBody Smartphone disp){
		return ResponseEntity.ok(ds.createDispositivo(disp));
	}
	
	@PostMapping("/Tablet")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> createDevice(@RequestBody Tablet disp){
		return ResponseEntity.ok(ds.createDispositivo(disp));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> updateDevice(@PathVariable long id, @RequestBody Laptop disp){
	return ResponseEntity.ok(ds.updateDispositivo(id,disp));	
	}
	
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<String> deleteDevice(@PathVariable long id){
		System.out.println(ds.getByIdDispositivo(id));
		return ResponseEntity.ok(ds.deleteDispositivo(id));
	}
}
