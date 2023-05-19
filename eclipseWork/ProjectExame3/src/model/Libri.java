package model;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findAllLibri",query="SELECT l FROM Libri l")
public class Libri extends Catalogo{

	private String autore;
	private String genere;
	
	public Libri() {
		super();
	}

	public Libri(String autore, String genere) {
		super();
		this.autore = autore;
		this.genere = genere;
	}

	public Libri(String titolo, int annopublicazione, int numeropagine) {
		super(titolo, annopublicazione, numeropagine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Libri [autore=" + autore + ", genere=" + genere + "]";
	}

	/**
	 * @return the autore
	 */
	public String getAutore() {
		return autore;
	}

	/**
	 * @param autore the autore to set
	 */
	public void setAutore(String autore) {
		this.autore = autore;
	}

	/**
	 * @return the genere
	 */
	public String getGenere() {
		return genere;
	}

	/**
	 * @param genere the genere to set
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	
}
