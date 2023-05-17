package EsercizioEventi;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="partecipazione")
public class Partecipazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Persona persona;
	@ManyToOne(cascade = CascadeType.ALL)
	@Column(nullable = false)
	private Evento evento;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Stato stato;

	
	
	public Partecipazione() {
		super();
	}

	public Partecipazione(Persona persona, Evento evento, Stato stato) {
		super();
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the evento
	 */
	public Evento getEvento() {
		return evento;
	}

	/**
	 * @param evento the evento to set
	 */
	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	/**
	 * @return the stato
	 */
	public Stato getStato() {
		return stato;
	}

	/**
	 * @param stato the stato to set
	 */
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	

}
