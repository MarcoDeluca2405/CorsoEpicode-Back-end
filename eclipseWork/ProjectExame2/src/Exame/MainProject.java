package Exame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainProject {
	
	
	private static List<Libri> listLibri=new ArrayList<Libri>();
	private static List<Riviste> listRiviste=new ArrayList<Riviste>();
	private static List <Catalogo> listCat=new ArrayList<Catalogo>();
	private static Catalogo cat=new Catalogo(listLibri,listRiviste);
	
	private static List<Riviste> ri;
	private static List<Libri> li;
	
	private static int ISBN_cont=0;
	private static String ISBN_L="L-"+ISBN_cont;
	private static String ISBN_R="R-"+ISBN_cont;
	
	private static Scanner scan=new Scanner(System.in);
	private static Logger log=LoggerFactory.getLogger(MainProject.class);
	
	public static void main(String [] arg) {
	
		try {
			System.out.println("Sto leggendo il file");
			readFile();
			listCat.add(cat);
		
		for(int i=0;i<1;i++) {
			addLibro();
			
		}
		

		for(int i=0;i<2;i++) {
			addRivista();
			
		}
		
		
		listCat.add(cat);

		

		listCat.forEach(l ->l.getLibri().forEach(r->{
			System.out.println("ISBN: "+r.getISBN()+" Titolo: "+r.getTitolo()+" numero pagine: "+r.getNumero_pagine()+" Autore: "+r.getAutore()+" Genere: "+r.getGenere()+" anno di publicazione: "+r.getAnno_pubblcazione());
			
		}));
		
		listCat.forEach(l ->l.getRiviste().forEach(r->{
			System.out.println("ISBN: "+r.getISBN()+" Titolo: "+r.getTitolo()+" numero pagine: "+r.getNumero_pagine()+" anno di publicazione: "+r.getAnno_pubblcazione()+" periodicità: "+r.getPeriodo());
			
		}));
		
		
		
		
		System.out.println("Quale Elemeno vuoi ellimare tramite il codice ISBN?");
		String ISBN=scan.nextLine();
		rimuoviElemento(ISBN);
		
		System.out.println("Quale Elemeno vuoi cercare tramite il codice ISBN?");
		ricercaISBN(scan.nextLine());
		
		System.out.println("Quale Elemeno vuoi cercare tramite la data di publicazione");
		ricercaAnnoPub(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Quale Elemeno vuoi cercare tramite l'autore");
		ricercaAutore(scan.nextLine());
		
		
		
	
		
		
		
		
			

			listCat.forEach(l ->l.getLibri().forEach(r->{
				System.out.println("ISBN: "+r.getISBN()+" Titolo: "+r.getTitolo()+" numero pagine: "+r.getNumero_pagine()+" Autore: "+r.getAutore()+" Genere: "+r.getGenere()+" anno di publicazione: "+r.getAnno_pubblcazione());
				
			}));
			
			listCat.forEach(l ->l.getRiviste().forEach(r->{
				System.out.println("ISBN: "+r.getISBN()+" Titolo: "+r.getTitolo()+" numero pagine: "+r.getNumero_pagine()+" anno di publicazione: "+r.getAnno_pubblcazione()+" periodicità: "+r.getPeriodo());
				
			}));
			
			
			System.out.println("Sovrascrivo i file");
			writeFile();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

public static void addLibro() {
	try {
	System.out.println("#### Inserisci un nuovo libro ####");
	
	System.out.println("Inserisci titolo");
	String titolo=scan.nextLine();
	
	System.out.println("Inserisci anno di publicazione");
	int anno=Integer.parseInt(scan.nextLine());
	
	System.out.println("Inserisci Numero Pagine");
	int numeroPagine=Integer.parseInt(scan.nextLine());
	
	
	System.out.println("Inserisci Autore");
	String Autore=scan.nextLine();
	
	System.out.println("Inserisci Genere");
	String Genere=scan.nextLine();
	
	Libri libro=new Libri(ISBN_L, titolo, anno, numeroPagine, Autore, Genere);
	listLibri.add(libro);	
	ISBN_cont++;
	ISBN_L="L-"+ISBN_cont;
	
	}catch(Exception e){
		log.error("Valore non valido Inserire valore Stringa!");
	}
	}



public static void addRivista() {
try {
	System.out.println("#### Inserisci un nuova Rivista ####");
	
	System.out.println("Inserisci titolo");
	String titolo=scan.nextLine();
	
	System.out.println("Inserisci anno di publicazione");
	int anno=Integer.parseInt(scan.nextLine());
	
	System.out.println("Inserisci Numero Pagine");
	int numeroPagine=Integer.parseInt(scan.nextLine());
	
	
	
	
	Riviste r = new Riviste(ISBN_R,titolo,anno,numeroPagine);
	boolean nonscelto=true;
	
	do {
		System.out.println("Seleziona Periodicità");
		System.out.println("1- SETTIMANALE");
		System.out.println("2- MENSILE");
		System.out.println("3- SEMESTRALE");
		String selected=scan.nextLine();
		
	switch(selected) {
	
	case "1":
		
			r=new Riviste(ISBN_R,titolo,anno,numeroPagine,r.getPeriodo().SETTIMANALE);
			nonscelto=false;
		break;
		
	case "2":
		r=new Riviste(ISBN_R,titolo,anno,numeroPagine,r.getPeriodo().MENSILE);
		nonscelto=false;
		break;
			
			
	case "3":
		r=new Riviste(ISBN_R,titolo,anno,numeroPagine,r.getPeriodo().SEMESTRALE);
		nonscelto=false;
		break;
	
	default:
		System.out.println("Valore inserito non è corretto");
		break;
	
	}
	}while(nonscelto);
	listRiviste.add(r);
	ISBN_cont++;
	ISBN_R="R-"+ISBN_cont;

	}catch(Exception e) {
		System.out.println("Valore inserito non è corretto");
		}
	}


public static void rimuoviElemento(String ISBN) {
		listRiviste.removeIf(r-> r.getISBN().equals(ISBN));
	listLibri.removeIf(r-> r.getISBN().equals(ISBN));
	
}


public static void ricercaISBN(String ISBN) {

	
	
	ri=listRiviste.stream()
		.filter(f-> f.getISBN().equals(ISBN)).collect(Collectors.toList());
			
	li=listLibri.stream()
			.filter(f-> f.getISBN().equals(ISBN)).collect(Collectors.toList());
	
	System.out.println("#### Ricerca Per ISBN ######");
	ri.forEach(r-> System.out.println("ISBN: "+r.getISBN()+" Titolo: "+r.getTitolo()+" numero pagine: "+r.getNumero_pagine()+" anno di publicazione: "+r.getAnno_pubblcazione()+" periodicità: "+r.getPeriodo()));
	li.forEach(r-> System.out.println("ISBN: "+r.getISBN()+" Titolo: "+r.getTitolo()+" numero pagine: "+r.getNumero_pagine()+" Autore: "+r.getAutore()+" Genere: "+r.getGenere()+" anno di publicazione: "+r.getAnno_pubblcazione()));
}


public static void ricercaAnnoPub(Integer anno) {
	
	
	
	ri=listRiviste.stream()
		.filter(f-> String.valueOf(f.getAnno_pubblcazione()).equals(String.valueOf(anno))).collect(Collectors.toList());
			
	li=listLibri.stream()
			.filter(f-> String.valueOf(f.getAnno_pubblcazione()).equals(String.valueOf(anno))).collect(Collectors.toList());
	
	System.out.println("#### Ricerca Per Data di publicazione ######");
	ri.forEach(r-> System.out.println("ISBN: "+r.getISBN()+" Titolo: "+r.getTitolo()+" numero pagine: "+r.getNumero_pagine()+" anno di publicazione: "+r.getAnno_pubblcazione()+" periodicità: "+r.getPeriodo()));
	li.forEach(r-> System.out.println("ISBN: "+r.getISBN()+" Titolo: "+r.getTitolo()+" numero pagine: "+r.getNumero_pagine()+" Autore: "+r.getAutore()+" Genere: "+r.getGenere()+" anno di publicazione: "+r.getAnno_pubblcazione()));
}


public static void ricercaAutore(String autore) {
	
	li=listLibri.stream()
			.filter(f-> f.getAutore().equals(autore)).collect(Collectors.toList());
	
	System.out.println("#### Ricerca Per Autore ######");
	li.forEach(r-> System.out.println("ISBN: "+r.getISBN()+" Titolo: "+r.getTitolo()+" numero pagine: "+r.getNumero_pagine()+" Autore: "+r.getAutore()+" Genere: "+r.getGenere()+" anno di publicazione: "+r.getAnno_pubblcazione()));
}

public static void writeFile() throws IOException {
	File write=new File("catalogo/catalogo.txt");
	
	
	
	FileUtils.writeLines(write, listCat,"UTF-8");
	
	
}


public static void readFile() throws IOException{
	File readCat=new File("catalogo/catalogo.txt");

	String salv=FileUtils.readFileToString(readCat, "UTF-8");

	System.out.println(salv);
	
	String [] oggetti;
	String [] riviste;
	String [] libri;
	
	oggetti=salv.split("!");
	
	for(String ogg:oggetti) {
		
		if(ogg.startsWith("L")) {
			libri=ogg.split("@");
				Libri libro=new Libri(libri[0], libri[1], Integer.parseInt(libri[2]), Integer.parseInt(libri[3]), libri[4], libri[5]);
				listLibri.add(libro);
			
			
		}
		
		if(ogg.startsWith("R-")) {
			riviste=ogg.split("@");
			Riviste r=new Riviste(riviste[0],riviste[1],Integer.parseInt(riviste[2]),Integer.parseInt(riviste[3]));
			listRiviste.add(r);
		
			
		}
		
		
	}
	
}


}

