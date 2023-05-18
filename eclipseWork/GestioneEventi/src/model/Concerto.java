package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="concerto")
@NamedQuery(name="concertiInStreaming",query = "SELECT c FROM Concerto c WHERE c.inStreaming = :streaming ")
@NamedQuery(name="concertiPerGenere",query = "SELECT c FROM Concerto c WHERE c.genere IN :listaGenere ")
public class Concerto extends Evento{
	
	@Enumerated(EnumType.STRING)
	private Genere genere;
	

	@Column(name="in_streaming")
	private boolean inStreaming;

	public Concerto() {
		super();
	}

	public Concerto(Genere genere, boolean inStreaming) {
		super();
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	@Override
	public String toString() {
		return "Concerto [genere=" + genere + ", inStreaming=" + inStreaming + "]";
	}

	/**
	 * @return the genere
	 */
	public Genere getGenere() {
		return genere;
	}

	/**
	 * @param genere the genere to set
	 */
	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	/**
	 * @return the inStreaming
	 */
	public boolean getInStreaming() {
		return inStreaming;
	}

	/**
	 * @param inStreaming the inStreaming to set
	 */
	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	}
	
	
}
