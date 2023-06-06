package it.epicode.be.prenotazioni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrenotazioniController {

	@GetMapping("/IT-it")
	public ModelAndView showPageItalian() {
		return new ModelAndView("IT-it");
	}
	
	@GetMapping("/EN-en")
	public ModelAndView showPageEnglish() {
		return new ModelAndView("EN-en");
	}
	
	
	
}
