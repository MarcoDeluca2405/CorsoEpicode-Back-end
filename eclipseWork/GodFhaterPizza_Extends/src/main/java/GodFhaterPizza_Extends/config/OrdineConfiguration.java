package GodFhaterPizza_Extends.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import GodFhaterPizza_Extends.model.Ordine;
import GodFhaterPizza_Extends.model.Tavolo;

@Configuration
@PropertySource("classpath:application.properties")
public class OrdineConfiguration {

	@Value("${GodfathersPizza.costocoperto}") private String costoCoperto;
	
	
	@Bean
	@Scope("prototype")
	public Ordine ordineTavolo(int numero_ordine, Tavolo tavolo, int numero_coperti) throws NumberFormatException, Exception {
		return new Ordine( numero_ordine,  tavolo,  numero_coperti,Double.parseDouble(costoCoperto));
	}
}