package Esercizio2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadChild extends Thread{
	private final int[] arr=new int[3];
	private static int cont=0;
	private Logger log=LoggerFactory.getLogger(ThreadChild.class);
	private int somma;
	public static Random ran=new Random();
	
	
	@Override
	public void run() {
		
		
		for(int i=0;i<1000;i++) {
			somma+=ran.nextInt(10);
			sommaT(somma);
		}
		
		for(int i=0;i<arr.length;i++) {
			arr[cont]=somma;
		}
		if(cont==0) {
			log.info("sono il primo il valore è: "+arr[0]);
		}
		
		if(cont==1) {
			log.info("sono il secondo il valore è: "+arr[1]);
		
	}
		if(cont==2) {
			log.info("sono il terzo il valore è: "+arr[2]);
		
		}
		
		
		cont=cont+1;
		
		
}
	
	public int sommaT(int somma) {
		return somma;
	}
	public int getSommaT() {
		return somma;
	}
	
}