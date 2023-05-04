package Esercizio3;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner scan= new Scanner(System.in);
			String input=" ";
			String exit="q";
			String parole="";
			do {
			
				System.out.println("Inserisci una parola");
				System.out.println("exit -q");
				input=scan.nextLine();
				if(input.charAt(0)!='q') {
				parole+=input+" , ";
				}
			}while(input.charAt(0)!='q'); 
			
			System.out.println("la tue parole sono:");
			System.out.println(parole);
	}

}
