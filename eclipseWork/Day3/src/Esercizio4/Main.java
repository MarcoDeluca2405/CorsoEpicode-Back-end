package Esercizio4;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner i=new Scanner(System.in);
	
		System.out.println("Inserisci da dove vuoi che parte il conto alla rovescia");
		
		int count=i.nextInt();
		
		System.out.println("Inizio Conto alla rovescia");
		
		for(int index=count;index!=-1;index--) {
			
			System.out.println(index);
			
		}
		

	}

}
