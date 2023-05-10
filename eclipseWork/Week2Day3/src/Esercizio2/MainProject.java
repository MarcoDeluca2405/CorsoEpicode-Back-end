package Esercizio2;

public class MainProject {

	public static void main(String[] args) {
		
	ThreadFhater tf=new ThreadFhater();
	ThreadChild th=new ThreadChild();
	ThreadChild th2=new ThreadChild();
	ThreadChild th3=new ThreadChild();
	ThreadMain tm=new ThreadMain(th,th2,th3);
	
	
	try {
		th.start();
		th.join();
		th2.start();
		th2.join();
		th3.start();
		th3.join();
		tm.start();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	tf.start();
	
			
		
	
			
			
		
			
	
	}
}