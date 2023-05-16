package ProvaJBC;

import java.time.LocalDate;

public class Cliente {
	private Integer numero_cliente;
	private String nome;
	private String cognome;
	private LocalDate data_nascita;
	private String regione_residenza;
	
	
	public Cliente(Integer numero_cliente, String nome, String cognome, LocalDate data_nascita,
			String regione_residenza) {
		super();
		this.numero_cliente = numero_cliente;
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.regione_residenza = regione_residenza;
	}


	public Cliente(String nome, String cognome, LocalDate data_nascita, String regione_residenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.regione_residenza = regione_residenza;
	}


	@Override
	public String toString() {
		return "Cliente [numero_cliente=" + numero_cliente + ", nome=" + nome + ", cognome=" + cognome
				+ ", data_nascita=" + data_nascita + ", regione_residenza=" + regione_residenza + "]";
	}


	public Cliente() {
		super();
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
	 * @return the numero_cliente
	 */
	public Integer getNumero_cliente() {
		return numero_cliente;
	}


	/**
	 * @param numero_cliente the numero_cliente to set
	 */
	public void setNumero_cliente(Integer numero_cliente) {
		this.numero_cliente = numero_cliente;
	}


	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	/**
	 * @return the data_nascita
	 */
	public LocalDate getData_nascita() {
		return data_nascita;
	}


	/**
	 * @param data_nascita the data_nascita to set
	 */
	public void setData_nascita(LocalDate data_nascita) {
		this.data_nascita = data_nascita;
	}


	/**
	 * @return the regione_residenza
	 */
	public String getRegione_residenza() {
		return regione_residenza;
	}


	/**
	 * @param regione_residenza the regione_residenza to set
	 */
	public void setRegione_residenza(String regione_residenza) {
		this.regione_residenza = regione_residenza;
	}
	
	
	
}
