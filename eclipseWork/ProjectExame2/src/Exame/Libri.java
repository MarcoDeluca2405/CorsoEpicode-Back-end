package Exame;

public class Libri extends Catalogo {
private String Autore;
private String Genere;



public Libri(String iSBN, String titolo, int anno_pubblcazione, int numero_pagine,String Autore,String Genere) {
	super(iSBN, titolo, anno_pubblcazione, numero_pagine);
	// TODO Auto-generated constructor stub
	this.Autore=Autore;
	this.Genere=Genere;
}


@Override
public String toString() {
	return "!"+super.getISBN()+"@"+super.getTitolo()+"@"+super.getAnno_pubblcazione()+"@"+super.getNumero_pagine()+"@"+Autore+"@"+Genere+"";
}


/**
 * @return the autore
 */
public String getAutore() {
	return Autore;
}
/**
 * @param autore the autore to set
 */
public void setAutore(String autore) {
	Autore = autore;
}
/**
 * @return the genere
 */
public String getGenere() {
	return Genere;
}
/**
 * @param genere the genere to set
 */
public void setGenere(String genere) {
	Genere = genere;
}
}

