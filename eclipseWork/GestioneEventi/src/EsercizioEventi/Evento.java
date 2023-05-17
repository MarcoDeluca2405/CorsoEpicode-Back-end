package EsercizioEventi;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	private String titolo;
	
	@Column(name="data_evento")
	private LocalDate dataEvento;
	
	private String descrizione;
	
	private tipoEvento evento;
	
	@Column(name="numero_max_partecipanti")
	private int numeroMassimoPartecipanti;

	public Evento() {
		super();
	}

	
	public Evento(String titolo, LocalDate dataEvento, String descrizione, tipoEvento evento,int numeroMassimoPartecipanti) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.evento = evento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	
	

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", evento=" + evento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
	}


	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}


	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the dataEvento
	 */
	public LocalDate getDataEvento() {
		return dataEvento;
	}

	/**
	 * @param dataEvento the dataEvento to set
	 */
	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	/**
	 * @return the evento
	 */
	public tipoEvento getEvento() {
		return evento;
	}

	/**
	 * @param evento the evento to set
	 */
	public void setEvento(tipoEvento evento) {
		this.evento = evento;
	}

	/**
	 * @return the numeroMassimoPartecipanti
	 */
	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	/**
	 * @param numeroMassimoPartecipanti the numeroMassimoPartecipanti to set
	 */
	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	
	
	
	
	
}
