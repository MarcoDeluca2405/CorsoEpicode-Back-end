package Esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadMain extends Thread{
	private Logger log=LoggerFactory.getLogger(ThreadMain.class);
	private int somma;
	ThreadChild tc1;
	ThreadChild tc2;
	ThreadChild tc3;
	
	public ThreadMain(ThreadChild th,ThreadChild th2, ThreadChild th3 ) {
		this.tc1=th;
		this.tc2=th2;
		this.tc3=th3;
	}
	
	
	@Override
	public void run() {

		somma=tc1.getSommaT()+tc2.getSommaT()+tc3.getSommaT();
		log.info("La somma dei tre thread è: "+somma);
	}
	
}
