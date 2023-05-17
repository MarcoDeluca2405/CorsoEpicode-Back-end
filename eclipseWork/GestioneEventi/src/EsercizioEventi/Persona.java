package EsercizioEventi;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(unique = true)
	private String email;
	
	@Column(nullable = false)
	private LocalDate data_di_nascita;
	
	@Column(nullable = false)
	private Sesso sesso;
	@OneToMany
	private List<Partecipazione> partecipazione;

	public Persona() {
		super();
	}

	public Persona(String nome, String cognome, String email, LocalDate data_di_nascita, Sesso sesso,
			List<Partecipazione> partecipazione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.data_di_nascita = data_di_nascita;
		this.sesso = sesso;
		this.partecipazione = partecipazione;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", data_di_nascita=" + data_di_nascita + ", sesso=" + sesso + ", partecipazione=" + partecipazione
				+ "]";
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the data_di_nascita
	 */
	public LocalDate getData_di_nascita() {
		return data_di_nascita;
	}

	/**
	 * @param data_di_nascita the data_di_nascita to set
	 */
	public void setData_di_nascita(LocalDate data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}

	/**
	 * @return the sesso
	 */
	public Sesso getSesso() {
		return sesso;
	}

	/**
	 * @param sesso the sesso to set
	 */
	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	/**
	 * @return the partecipazione
	 */
	public List<Partecipazione> getPartecipazione() {
		return partecipazione;
	}

	/**
	 * @param partecipazione the partecipazione to set
	 */
	public void setPartecipazione(List<Partecipazione> partecipazione) {
		this.partecipazione = partecipazione;
	}
	
}
