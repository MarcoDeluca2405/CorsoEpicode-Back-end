package Esercizio1;

import org.slf4j.*;

public class ThreadChild extends Thread{
	private static Logger log=LoggerFactory.getLogger(ThreadChild.class);
	private String symbol;
	private int count=0;
	
	public ThreadChild(String symbol) {
		this.symbol=symbol;
	}
	
	@Override
	public void run() {
		try {
		for(int i=0;i<10;i++) {	
			Thread.sleep(100);
			count++;
			log.info(toString());;		
		}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		
		return this.symbol+" count: "+this.count;
	}
	
}
