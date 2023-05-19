package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="utente")
public class Utente {
	
	@Id
	@SequenceGenerator(name = "seq_tessera",sequenceName = "seq_tessera",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tessera")
	private Integer numeroDiTessera;
	
	private String nome;
	private String cognome;
	
	@Column(name="data_di_nascita")
	private LocalDate dataDiNascita;

	
	
	
	
	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, LocalDate dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}

	@Override
	public String toString() {
		return "Utente [numeroDiTessera=" + numeroDiTessera + ", nome=" + nome + ", cognome=" + cognome
				+ ", dataDiNascita=" + dataDiNascita + "]";
	}

	/**
	 * @return the numeroDiTessera
	 */
	public Integer getNumeroDiTessera() {
		return numeroDiTessera;
	}

	/**
	 * @param numeroDiTessera the numeroDiTessera to set
	 */
	public void setNumeroDiTessera(Integer numeroDiTessera) {
		this.numeroDiTessera = numeroDiTessera;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the dataDiNascita
	 */
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	/**
	 * @param dataDiNascita the dataDiNascita to set
	 */
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	
	
}
