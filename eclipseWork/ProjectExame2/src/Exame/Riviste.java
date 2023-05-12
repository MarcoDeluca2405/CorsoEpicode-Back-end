package Exame;



public class Riviste extends Catalogo {
	enum periodicita{
		SETTIMANALE,
		MENSILE,
		SEMESTRALE
	}
	
	
	private periodicita periodo;
	
	/**
	 * @return the periodo
	 */
	public periodicita getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(periodicita periodo) {
		this.periodo = periodo;
	}

	
	
	public Riviste(String iSBN, String titolo, int anno_pubblcazione, int numero_pagine) {
		super(iSBN, titolo, anno_pubblcazione, numero_pagine);
	}

	public Riviste(String iSBN, String titolo, int anno_pubblcazione, int numero_pagine, periodicita periodo ) {
		super(iSBN, titolo, anno_pubblcazione, numero_pagine);
		this.periodo=periodo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Rivista [ISBN: "+super.getISBN()+" Titolo: "+super.getTitolo()+" Anno di publicazione: "+super.getAnno_pubblcazione()+" numero pagine: "+super.getNumero_pagine()+" Periodicità: "+periodo+"]";
	}



}
