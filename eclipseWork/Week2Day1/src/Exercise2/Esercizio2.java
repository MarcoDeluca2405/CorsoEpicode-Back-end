package Exercise2;
import java.util.*;

public class Esercizio2 {

	public static void main(String[] args) {
		
		System.out.println("Il rapporto è: "+raportoKm_Lt());

	}
	
	
	public static double raportoKm_Lt(){
		System.out.println("Kilometri percorsi");
		double km=setKm_Lt();
		System.out.println("Litri consumati");
		double lt=setKm_Lt();
		double somma;
		try {
			
			return somma=km/lt;
			
		}catch(java.lang.ArithmeticException e) {
			System.out.println("il valore dei due è 0");
			return somma=km/lt;
		}
		
	}
	
	
	public static double setKm_Lt() {
		Scanner sc=new Scanner(System.in);
		double valore=-1;
		do {
		try {
			System.out.println("inserisci il valore");
			valore=Double.parseDouble(sc.nextLine());
		}catch(java.lang.NumberFormatException e) {
		System.out.println("Non è un valore inserire un valore corretto");
		}
		}while(valore<0);
		return valore;
	}
	

	
	

}
