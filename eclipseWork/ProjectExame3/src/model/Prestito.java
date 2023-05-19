package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class Prestito {
	
	@Id
	@SequenceGenerator(name = "seq_id",sequenceName = "seq_id",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
	private Integer id;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne(targetEntity = Catalogo.class,cascade =  CascadeType.ALL)
	@Column(name="elemento_prestato")
	private Catalogo ElementoPrestato;
	
	@Column(name="inizio_prestito")
	private LocalDate inizioPrestito;
	
	@Column(name="restituzione_prevista")
	private LocalDate restitutizionePrevista=inizioPrestito.plusDays(30);
	
	@Column(name="restituzione_effettiva")
	private LocalDate restituzioneEffettiva;

	public Prestito() {
		super();
	}

	public Prestito(Utente utente, Catalogo elementoPrestato, LocalDate inizioPrestito,
			LocalDate restitutizionePrevista, LocalDate restituzioneEffettiva) {
		super();
		this.utente = utente;
		ElementoPrestato = elementoPrestato;
		this.inizioPrestito = inizioPrestito;
		this.restitutizionePrevista = restitutizionePrevista;
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	/**
	 * @return the utente
	 */
	public Utente getUtente() {
		return utente;
	}

	/**
	 * @param utente the utente to set
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	/**
	 * @return the elementoPrestato
	 */
	public Catalogo getElementoPrestato() {
		return ElementoPrestato;
	}

	/**
	 * @param elementoPrestato the elementoPrestato to set
	 */
	public void setElementoPrestato(Catalogo elementoPrestato) {
		ElementoPrestato = elementoPrestato;
	}

	/**
	 * @return the inizioPrestito
	 */
	public LocalDate getInizioPrestito() {
		return inizioPrestito;
	}

	/**
	 * @param inizioPrestito the inizioPrestito to set
	 */
	public void setInizioPrestito(LocalDate inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}

	/**
	 * @return the restitutizionePrevista
	 */
	public LocalDate getRestitutizionePrevista() {
		return restitutizionePrevista;
	}

	/**
	 * @param restitutizionePrevista the restitutizionePrevista to set
	 */
	public void setRestitutizionePrevista(LocalDate restitutizionePrevista) {
		this.restitutizionePrevista = restitutizionePrevista;
	}

	/**
	 * @return the restituzioneEffettiva
	 */
	public LocalDate getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}

	/**
	 * @param restituzioneEffettiva the restituzioneEffettiva to set
	 */
	public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", ElementoPrestato=" + ElementoPrestato + ", inizioPrestito="
				+ inizioPrestito + ", restitutizionePrevista=" + restitutizionePrevista + ", restituzioneEffettiva="
				+ restituzioneEffettiva + "]";
	}
	
	
	
}
