package Exercizio2;
import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		
		//Esercizio n 1
	
		System.out.println("Inserisci Largezza");
		double lar=scan.nextDouble();
		
		System.out.println("Inserisci Altezza");
		double alt=scan.nextDouble();
		
		
		Rettangolo a=new Rettangolo(lar,alt);
		
		a.stampaRettangolo();
		
		
		System.out.println("Inserisci Largezza");
		double lar2=scan.nextDouble();
		
		System.out.println("Inserisci Altezza");
		double alt2=scan.nextDouble();
		
		
		System.out.println("-------------------");
		Rettangolo b=new Rettangolo(lar2,alt2);
		b.stampaRettangolo();
		System.out.println("-------------------");
		
		a.stampaDueRettangoli(a, b);
		
		
		
		
		//Esercizio n 2 
		
		int number=340996111;
		double credit=1.0;
		String [] list= {"Marco","Francesco","Mario","Chiara","Roxy"};
		
		
		OperatoreTelefonico sim=new OperatoreTelefonico(credit,list);
		sim.setNumber(number);
		
		sim.stampaSim();
		
		
	}

}
