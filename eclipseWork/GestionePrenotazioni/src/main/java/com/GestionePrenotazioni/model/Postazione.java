package com.GestionePrenotazioni.model;

import java.util.List;

import com.GestionePrenotazioni.Enum.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
public class Postazione {

	@SequenceGenerator(name = "seq_id",sequenceName = "seq_id",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_id")
	@Id
	private Integer id;
	
	private String descrizione;
	private Tipo tipo;
	private Integer max_occpuanti;
	
	@ManyToOne
	private Edificio edificio;
	
	
	public Postazione(String descrizione, Tipo tipo, Integer max_occpuanti, Edificio edificio) {
		super();
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.max_occpuanti = max_occpuanti;
		this.edificio = edificio;
	}
	
	
}
