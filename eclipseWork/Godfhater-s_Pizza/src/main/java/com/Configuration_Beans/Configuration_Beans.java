package com.Configuration_Beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.Beans.Ingredienti;
import com.Beans.Pizza;

@Configuration
public class Configuration_Beans {

	
	@Bean
	@Scope("prototype")
	public Pizza pizza(String nome,List<Ingredienti> ingrediente,int cal,double prezzo) {
		ingrediente.add(0,new Ingredienti("Pomodoro",1));
		ingrediente.add(1,new Ingredienti("Mozzarella",1));
		for(Ingredienti ingredienteSin : ingrediente) {
			if(ingredienteSin.getQuantita()>1) {
				prezzo=ingredienteSin.totalePrezzoIngredienti()+prezzo;
				cal=cal+50;
				
			}
			
			
		}
		
		
		return new Pizza(nome,ingrediente,cal,prezzo);
	}
	
	@Bean
	@Scope("prototype")
	public Pizza pizzaMargherita() {
		String nome="Margherita";
		List<Ingredienti> ingrediente=new ArrayList<Ingredienti>();
		ingrediente.add(0,new Ingredienti("Pomodoro",1));
		ingrediente.add(1,new Ingredienti("Mozzarella",1));
		int cal=700;
		double prezzo=4.5;
		return new Pizza(nome,ingrediente,cal,prezzo);
	}
}
