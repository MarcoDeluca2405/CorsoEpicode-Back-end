package com.Beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ingredienti {
private String nome;
private int quantita;
private double prezzo_quanita=0.5;





@Override
public String toString() {
	return nome+" quantita: "+quantita; 
}

public double totalePrezzoIngredienti() {
	return this.prezzo_quanita=this.prezzo_quanita*quantita;
}

public Ingredienti(String nome, int quantita) {
	super();
	this.nome = nome;
	this.quantita = quantita;
}
}
