package model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gara_di_atletica")
public class GaraDiAtletica extends Evento {

	@Column(name ="lista_atleti")
	@OneToMany(targetEntity = Persona.class, cascade = CascadeType.ALL)
	private List<Persona> SetAtleti;
	
	
	@OneToOne(targetEntity=Persona.class)
	private Persona Vincitore;

	public GaraDiAtletica() {
		super();
	}

	public GaraDiAtletica(List<Persona> setAtleti, Persona vincitore) {
		super();
		SetAtleti = setAtleti;
		Vincitore = vincitore;
	}

	@Override
	public String toString() {
		return "GaraDiAtletica [SetAtleti=" + SetAtleti + ", Vincitore=" + Vincitore + "]";
	}

	/**
	 * @return the setAtleti
	 */
	public List<Persona> getSetAtleti() {
		return SetAtleti;
	}

	/**
	 * @param setAtleti the setAtleti to set
	 */
	public void setSetAtleti(List<Persona> setAtleti) {
		SetAtleti = setAtleti;
	}

	/**
	 * @return the vincitore
	 */
	public Persona getVincitore() {
		return Vincitore;
	}

	/**
	 * @param vincitore the vincitore to set
	 */
	public void setVincitore(Persona vincitore) {
		Vincitore = vincitore;
	}
	
	
	
	
}
