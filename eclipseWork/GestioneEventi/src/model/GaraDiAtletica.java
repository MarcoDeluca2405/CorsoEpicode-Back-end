package model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gara_di_atletica")
public class GaraDiAtletica extends Evento {

	@Column(name ="lista_atleti")
	@ManyToMany(targetEntity = Persona.class, cascade = CascadeType.ALL)
	private Set<Persona> SetAtleti;
	
	
	@ManyToOne(targetEntity=Persona.class)
	private Persona Vincitore;

	public GaraDiAtletica() {
		super();
	}

	public GaraDiAtletica(Set<Persona> setAtleti, Persona vincitore) {
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
	public Set<Persona> getSetAtleti() {
		return SetAtleti;
	}

	/**
	 * @param setAtleti the setAtleti to set
	 */
	public void setSetAtleti(Set<Persona> setAtleti) {
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
