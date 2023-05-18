package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="concerto")
public class Concerto extends Evento{
	
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	@Enumerated(EnumType.STRING)
	@Column(name="in_streaming")
	private InStreaming inStreaming;

	public Concerto() {
		super();
	}

	public Concerto(Genere genere, InStreaming inStreaming) {
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
	public InStreaming getInStreaming() {
		return inStreaming;
	}

	/**
	 * @param inStreaming the inStreaming to set
	 */
	public void setInStreaming(InStreaming inStreaming) {
		this.inStreaming = inStreaming;
	}
	
	
}
