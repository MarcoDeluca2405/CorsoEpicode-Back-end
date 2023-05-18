package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="partita_di_calcio")
public class PartitaDiCalcio extends Evento{

	@Column(name="squadra_di_casa")
	private String SquadraDiCasa;
	
	@Column(name="squadra_di_ospite")
	private String SquadraOspite;
	
	@Column(name="squadra_vincente")
	private String SquadraVincente;
	
	@Column(name="numero_di_gol_di_casa")
	private Integer numeroGolDiCasa;
	
	@Column(name="squadra_di_gol_squadra_ospite")
	private Integer numeroGolSquadraOspite;

	
	
	public PartitaDiCalcio() {
		super();
	}



	public PartitaDiCalcio(String squadraDiCasa, String squadraOspite, String squadraVincente, Integer numeroGolDiCasa,
			Integer numeroGolSquadraOspite) {
		super();
		SquadraDiCasa = squadraDiCasa;
		SquadraOspite = squadraOspite;
		SquadraVincente = squadraVincente;
		this.numeroGolDiCasa = numeroGolDiCasa;
		this.numeroGolSquadraOspite = numeroGolSquadraOspite;
	}



	@Override
	public String toString() {
		return "PartitaDiCalcio [SquadraDiCasa=" + SquadraDiCasa + ", SquadraOspite=" + SquadraOspite
				+ ", SquadraVincente=" + SquadraVincente + ", numeroGolDiCasa=" + numeroGolDiCasa
				+ ", numeroGolSquadraOspite=" + numeroGolSquadraOspite + "]";
	}



	/**
	 * @return the squadraDiCasa
	 */
	public String getSquadraDiCasa() {
		return SquadraDiCasa;
	}



	/**
	 * @param squadraDiCasa the squadraDiCasa to set
	 */
	public void setSquadraDiCasa(String squadraDiCasa) {
		SquadraDiCasa = squadraDiCasa;
	}



	/**
	 * @return the squadraOspite
	 */
	public String getSquadraOspite() {
		return SquadraOspite;
	}



	/**
	 * @param squadraOspite the squadraOspite to set
	 */
	public void setSquadraOspite(String squadraOspite) {
		SquadraOspite = squadraOspite;
	}



	/**
	 * @return the squadraVincente
	 */
	public String getSquadraVincente() {
		return SquadraVincente;
	}



	/**
	 * @param squadraVincente the squadraVincente to set
	 */
	public void setSquadraVincente(String squadraVincente) {
		SquadraVincente = squadraVincente;
	}



	/**
	 * @return the numeroGolDiCasa
	 */
	public Integer getNumeroGolDiCasa() {
		return numeroGolDiCasa;
	}



	/**
	 * @param numeroGolDiCasa the numeroGolDiCasa to set
	 */
	public void setNumeroGolDiCasa(Integer numeroGolDiCasa) {
		this.numeroGolDiCasa = numeroGolDiCasa;
	}



	/**
	 * @return the numeroGolSquadraOspite
	 */
	public Integer getNumeroGolSquadraOspite() {
		return numeroGolSquadraOspite;
	}



	/**
	 * @param numeroGolSquadraOspite the numeroGolSquadraOspite to set
	 */
	public void setNumeroGolSquadraOspite(Integer numeroGolSquadraOspite) {
		this.numeroGolSquadraOspite = numeroGolSquadraOspite;
	}
	
	
	
}
