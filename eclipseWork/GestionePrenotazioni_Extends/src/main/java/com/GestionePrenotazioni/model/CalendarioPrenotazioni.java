package com.GestionePrenotazioni.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class CalendarioPrenotazioni {
	
	@SequenceGenerator(name = "seq_id",sequenceName = "seq_id",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_id")
	@Id
	private Integer id;
	
	private LocalDate giornoPrenotato;
	
	@ManyToOne
	private Postazione postazione;
	
	
	
	
	public CalendarioPrenotazioni(LocalDate giornoPrenotato, Postazione postazione) {
		super();
		this.giornoPrenotato = giornoPrenotato;
		this.postazione = postazione;
		
	}
	
	
}
