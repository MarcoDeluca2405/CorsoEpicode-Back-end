package Esercizio1;

public class MainProject {

	public static void main(String[] args) {
		
		ThreadChild a=new ThreadChild("*");
		ThreadChild b=new ThreadChild("#");
		
		
		a.start();
		b.start();
		
		
	}

}
