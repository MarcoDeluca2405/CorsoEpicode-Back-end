package model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import Enum.Periodicita;

@Entity
@NamedQuery(name="findAllRiviste",query="SELECT r FROM Riviste r")
public class Riviste extends Catalogo {
	
private Periodicita periodicita;

public Riviste() {
	super();
}

public Riviste(Periodicita periodicita) {
	super();
	this.periodicita = periodicita;
}

@Override
public String toString() {
	return "Riviste [periodicita=" + periodicita + "]";
}

/**
 * @return the periodicita
 */
public Periodicita getPeriodicita() {
	return periodicita;
}

/**
 * @param periodicita the periodicita to set
 */
public void setPeriodicita(Periodicita periodicita) {
	this.periodicita = periodicita;
}



}
