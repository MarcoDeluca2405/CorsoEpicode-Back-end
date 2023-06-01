package GodFhaterPizza_Extends.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import GodFhaterPizza_Extends.model.Tavolo;

@Configuration
public class TavoloConfiguration {

	
	@Bean
	@Scope("prototype")
	public Tavolo tavolo(int numeroTavolo,int numeroCoperti) {
		return new Tavolo( numeroTavolo, numeroCoperti);
	
}

}
