package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "findAllPrestito", query = "SELECT p FROM Prestito p")
@NamedQuery(name="findUtenteAttuali",query = "SELECT e FROM Prestito p JOIN p.elementoprestato e JOIN p.utente u Where u.numeroditessera= :tessera AND p.restituzioneeffettiva IS NULL ")
@NamedQuery(name="findNonResituiti",query="SELECT e,u, p.inizioPrestito,p.restitutizioneprevista FROM Prestito p JOIN p.elementoprestato e JOIN p.utente u WHERE p.restituzioneeffettiva IS NULL AND  p.restitutizioneprevista < :currentData")
public class Prestito {
	
	@Id
	@SequenceGenerator(name = "seq_id",sequenceName = "seq_id",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="n_card_utenti")
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name="Cat")
	private Catalogo elementoprestato;
	
	@Column(name="inizio_prestito")
	private LocalDate inizioPrestito;
	
	@Column(name="restituzione_prevista")
	private LocalDate restitutizioneprevista;
	
	@Column(name="restituzione_effettiva")
	private LocalDate restituzioneeffettiva;

	public Prestito() {
		super();
	}

	public Prestito(Utente utente, Catalogo elementoPrestato, LocalDate inizioPrestito,
			LocalDate restitutizionePrevista, LocalDate restituzioneEffettiva) {
		super();
		this.utente = utente;
		elementoprestato = elementoPrestato;
		this.inizioPrestito = inizioPrestito;
		this.restitutizioneprevista = inizioPrestito.plusDays(30);
		this.restituzioneeffettiva = restituzioneEffettiva;
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
		return elementoprestato;
	}

	/**
	 * @param elementoPrestato the elementoPrestato to set
	 */
	public void setElementoPrestato(Catalogo elementoPrestato) {
		elementoprestato = elementoPrestato;
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
		return restitutizioneprevista;
	}

	/**
	 * @param restitutizionePrevista the restitutizionePrevista to set
	 */
	public void setRestitutizionePrevista(LocalDate inizioPrestito) {
		this.restitutizioneprevista = inizioPrestito.plusDays(30);
	}

	/**
	 * @return the restituzioneEffettiva
	 */
	public LocalDate getRestituzioneEffettiva() {
		return restituzioneeffettiva;
	}

	/**
	 * @param restituzioneEffettiva the restituzioneEffettiva to set
	 */
	public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
		this.restituzioneeffettiva = restituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", ElementoPrestato=" + elementoprestato + ", inizioPrestito="
				+ inizioPrestito + ", restitutizionePrevista=" + restitutizioneprevista + ", restituzioneEffettiva="
				+ restituzioneeffettiva + "]";
	}
	
	
	
}
