package com.GestionePrenotazioni.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Utente {
	
	@SequenceGenerator(name = "seq_id",sequenceName = "seq_id",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_id")
	@Id
	private Integer id;
	
	private String username;
	private String nome;
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<CalendarioPrenotazioni> cal_prenotazioni=new ArrayList<CalendarioPrenotazioni>();
	
	public Utente(String username, String nome, String email, List<CalendarioPrenotazioni> cal_prenotazioni) {
		super();
		this.username = username;
		this.nome = nome;
		this.email = email;
		this.cal_prenotazioni = cal_prenotazioni;
	}
	
	public Utente(String username, String nome, String email) {
		super();
		this.username = username;
		this.nome = nome;
		this.email = email;
		
	}
	
}
