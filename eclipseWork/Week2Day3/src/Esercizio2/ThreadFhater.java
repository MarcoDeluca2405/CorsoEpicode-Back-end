package Esercizio2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadFhater extends Thread {

	public static Random ran=new Random();
	public static Logger log=LoggerFactory.getLogger(ThreadFhater.class);
	
private int [] arr=new int [3000];
private int somma;


@Override
	public void run() {

		for(int i=0;i<arr.length;i++) {
			somma+=ran.nextInt(10);
		}
		
		log.info("La somma del padre è: "+somma);
		
}





	
	
}



