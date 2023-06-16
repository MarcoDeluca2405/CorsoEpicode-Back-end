package com.GestioneIncendi.model;




// utilizando il pattern prototype si può creare piu instanze diverse 
//dello stesso oggetto e modificarlo in un secondo momento le caratteristiche



public class Sonda extends Abstract_sonda{

	public Sonda() {
		
	}
	
	public Sonda(Sonda target) {
		super(target);
	}

	@Override
	public Abstract_sonda clone() {
		// TODO Auto-generated method stub
	return new Sonda(this);
	}

}
