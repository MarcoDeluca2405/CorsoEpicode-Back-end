package Exame;

import java.util.List;

public  class Catalogo {
private String ISBN;
private String Titolo;
private int Anno_pubblcazione;
private int Numero_pagine;
private List <Libri> libri;
private List <Riviste> riviste;


/**
 * @return the iSBN
 * 
 * 
 * 
 */






public String getISBN() {
	return ISBN;
}


















/**
 * @return the libri
 */
public List<Libri> getLibri() {
	return libri;
}


















/**
 * @param libri the libri to set
 */
public void setLibri(List<Libri> libri) {
	this.libri = libri;
}


















/**
 * @return the riviste
 */
public List<Riviste> getRiviste() {
	return riviste;
}


















/**
 * @param riviste the riviste to set
 */
public void setRiviste(List<Riviste> riviste) {
	this.riviste = riviste;
}


















@Override
public String toString() {
	return libri+""+riviste;
}

















public Catalogo(String iSBN, String titolo, int anno_pubblcazione, int numero_pagine) {
	ISBN = iSBN;
	Titolo = titolo;
	Anno_pubblcazione = anno_pubblcazione;
	Numero_pagine = numero_pagine;
}






public Catalogo(List<Libri> libri, List<Riviste> riviste) {
	super();
	this.libri = libri;
	this.riviste = riviste;
}


/**
 * @param iSBN the iSBN to set
 */
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
/**
 * @return the titolo
 */
public String getTitolo() {
	return Titolo;
}
/**
 * @param titolo the titolo to set
 */
public void setTitolo(String titolo) {
	Titolo = titolo;
}
/**
 * @return the anno_pubblcazione
 */
public int getAnno_pubblcazione() {
	return Anno_pubblcazione;
}
/**
 * @param anno_pubblcazione the anno_pubblcazione to set
 */
public void setAnno_pubblcazione(int anno_pubblcazione) {
	Anno_pubblcazione = anno_pubblcazione;
}
/**
 * @return the numero_pagine
 */
public int getNumero_pagine() {
	return Numero_pagine;
}
/**
 * @param numero_pagine the numero_pagine to set
 */
public void setNumero_pagine(int numero_pagine) {
	Numero_pagine = numero_pagine;
}

}




