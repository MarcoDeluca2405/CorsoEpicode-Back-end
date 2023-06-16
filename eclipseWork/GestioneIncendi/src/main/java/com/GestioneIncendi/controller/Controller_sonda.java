package com.GestioneIncendi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.MimeMappings.Mapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.GestioneIncendi.model.Sonda;
import com.GestioneIncendi.service.Service_Sonda;

import jakarta.websocket.server.PathParam;

@RestController
public class Controller_sonda {
	@Autowired Service_Sonda ss;
	
	@PostMapping(value = "/allarme", params = {"id", "lat", "lon", "smokeLevel"})
	public ResponseEntity<?> addSonda(@RequestParam("id") long id, @RequestParam("lat") int lat, @RequestParam("lon") int lon,@RequestParam("smokeLevel") int level) {
		Sonda s=new Sonda();
		s.setId(id);
		s.setAltidudine(lat);
		s.setLongitudine(lon);
		s.setLivello_fummo(level);
		
		return ResponseEntity.ok(ss.createSonda(s));
		
	}
	
	@GetMapping(value="/sonda/all")
	public ResponseEntity<?> getAllSonda() {
		return ResponseEntity.ok(ss.getAllsonde());
	}
	
	@GetMapping(value="/allarme/all")
	public ResponseEntity<?> getAllAlarm(){
		return ResponseEntity.ok(ss.allAlarmiAttivi());
		}
	
	@PutMapping(value="/allarme/reset", params= {"id"})
	public ResponseEntity<?> resetSonda(@RequestParam("id") long id){
		return ResponseEntity.ok(ss.resetSonda(id));
	}
	
	@DeleteMapping(value="/sonda/delete", params= {"id"})
	public ResponseEntity<String> deleteSonda(@RequestParam("id") long id){
		return ResponseEntity.ok(ss.deleteSonda(id));
	}
	
	
	
}
