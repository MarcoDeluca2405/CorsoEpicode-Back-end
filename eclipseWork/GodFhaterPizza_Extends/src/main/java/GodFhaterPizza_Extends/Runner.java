package GodFhaterPizza_Extends;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class Runner implements CommandLineRunner{
Logger log = LoggerFactory.getLogger(Runner.class);
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		start_Beans();
		
	}

	
	public void start_Beans() {
		log.info("start...");
		GestioneMenu stampa = new GestioneMenu();
		stampa.stampaMenu();
		stampa.testTopping();
		
	}
	
}
