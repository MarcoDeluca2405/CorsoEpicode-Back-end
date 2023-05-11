package Esercizio3;

public class Presenza {
private String nome;
private int giorniPresenza;


public Presenza(String nome, int giorniPresenza) {
	super();
	this.nome = nome;
	this.giorniPresenza = giorniPresenza;
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
 * @return the giorniPresenza
 */
public int getGiorniPresenza() {
	return giorniPresenza;
}


/**
 * @param giorniPresenza the giorniPresenza to set
 */
public void setGiorniPresenza(int giorniPresenza) {
	this.giorniPresenza = giorniPresenza;
}


@Override
public String toString() {
	return nome+"@"+giorniPresenza;
}






}
