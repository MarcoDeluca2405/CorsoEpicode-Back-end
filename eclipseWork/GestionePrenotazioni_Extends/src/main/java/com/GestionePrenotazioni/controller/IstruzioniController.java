package com.GestionePrenotazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionePrenotazioni.service.IstruzioniService;

@RestController
@RequestMapping("/api")
public class IstruzioniController {

	@Autowired
	private IstruzioniService istruzioneService;
	
	@GetMapping("/istruzioni/{lingua}")
	public ResponseEntity<String> getIstruizoni(@PathVariable String lingua){
		String istruzioni=istruzioneService.getIstruzioni(lingua);
		
		return new ResponseEntity<>(istruzioni,HttpStatus.OK);
	}
	
}
