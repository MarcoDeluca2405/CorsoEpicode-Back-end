package com.GestionePrenotazioni;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.GestionePrenotazioni.model.Utente;

class TestUtente {
	Utente u;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	 System.out.println("BeforeAll start");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfeterAll chiusura");
	}

	@BeforeEach
	void setUp() throws Exception {
		u=new Utente("ilDelux","Marco De Luca","Marco_de_luca2405@hotmail.com");
		System.out.println("BeforeEach creazione Utente");
	}

	@AfterEach
	void tearDown() throws Exception {
		u=null;
	}

	@Test
	void testGetUsername() {
		assertEquals("ilDelux", u.getUsername());
	}

	@Test
	void testGetNome() {
		assertEquals("Marco De Luca", u.getNome());
	}

}
