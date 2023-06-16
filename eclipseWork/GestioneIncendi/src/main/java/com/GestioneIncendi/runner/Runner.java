package com.GestioneIncendi.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;


public class Runner implements CommandLineRunner {
Logger log= LoggerFactory.getLogger(Runner.class);


	@Override
	public void run(String... args) throws Exception {
		log.info("ciao");
	}

}
