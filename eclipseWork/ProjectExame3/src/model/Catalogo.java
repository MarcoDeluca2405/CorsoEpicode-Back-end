package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "findAllCatalogo", query = "SELECT c FROM Catalogo c")
@NamedQuery(name="findEqualAnno",query="SELECT c FROM Catalogo c WHERE c.annopublicazione= :anno")
@NamedQuery(name="findAutore",query="SELECT c FROM Catalogo c WHERE c.autore= :autore")
@NamedQuery(name="findTitolo",query="SELECT c FROM Catalogo c WHERE c.titolo=:titolo ")
public abstract class  Catalogo {

	@Id
	@SequenceGenerator(name = "seq_ISBN",sequenceName = "seq_ISBN",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ISBN")
	private Integer ISBN;
	
	private String titolo;
	
	@Column(name="anno_publicazione")
	private int annopublicazione;
	
	@Column(name="numero_pagine")
	private int numeropagine;

	public Catalogo() {
		super();
	}

	public Catalogo(String titolo, int annopublicazione, int numeropagine) {
		super();
		this.titolo = titolo;
		this.annopublicazione = annopublicazione;
		this.numeropagine = numeropagine;
	}

	@Override
	public String toString() {
		return "Catalogo [ISBN=" + ISBN + ", titolo=" + titolo + ", annopublicazione=" + annopublicazione
				+ ", numeropagine=" + numeropagine + "]";
	}

	/**
	 * @return the iSBN
	 */
	public Integer getISBN() {
		return ISBN;
	}

	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the annopublicazione
	 */
	public int getAnnopublicazione() {
		return annopublicazione;
	}

	/**
	 * @param annopublicazione the annopublicazione to set
	 */
	public void setAnnopublicazione(int annopublicazione) {
		this.annopublicazione = annopublicazione;
	}

	/**
	 * @return the numeropagine
	 */
	public int getNumeropagine() {
		return numeropagine;
	}

	/**
	 * @param numeropagine the numeropagine to set
	 */
	public void setNumeropagine(int numeropagine) {
		this.numeropagine = numeropagine;
	}
	
	
}
