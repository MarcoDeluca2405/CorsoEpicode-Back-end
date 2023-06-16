package com.GestioneIncendi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public abstract class Abstract_sonda {
	private Long id;
	private int longitudine;
	private int altidudine;
	private int livello_fummo;
	
	public Abstract_sonda() {
		
	}
	
	public Abstract_sonda(Abstract_sonda target) {
		if(target != null) {
			this.id=target.id;
			this.longitudine=target.longitudine;
			this.altidudine=target.altidudine;
			this.livello_fummo=target.livello_fummo;
		}
	}
	
	
	public abstract Abstract_sonda clone();

	@Override
	public String toString() {
		return "Sonda [longitudine=" + longitudine + ", altidudine=" + altidudine
				+ ", livello_fummo=" + livello_fummo + "]";
	}
	
	
}
