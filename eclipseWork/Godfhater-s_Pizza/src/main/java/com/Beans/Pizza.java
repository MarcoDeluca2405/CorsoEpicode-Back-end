package com.Beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor

@Getter
@Setter
public class Pizza {

	private String nome;
	private List<Ingredienti> ingrediente;
	private int cal;
	private  double prezzo;
	
	
	
	
	


	
	public String readPizza() {
		return nome+"("+ingrediente+")    - CAL: "+cal+" Kcal -Prezzo: "+prezzo+" €";
	}
	
	
	
}


