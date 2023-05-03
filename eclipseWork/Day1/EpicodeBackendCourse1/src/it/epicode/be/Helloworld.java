package it.epicode.be;
import java.util.*;

public class Helloworld {

public static void main (String[] args)
		{
		
		System.out.println("This is my first Epicode Java Project!");
		
		Scanner scan=new Scanner(System.in);
		
		
	
		System.out.println("Moltiplicazione");
		
		
		System.out.println("Inserisci il primo valore");
		
		int num_1=scan.nextInt();
		
		System.out.println("Inserisci il secondo valore");
		int num_2=scan.nextInt();
		
		System.out.println("La loro moltiplicazione è: "+Moltiplicazione(num_1,num_2));
		
		

		
	
		System.out.println("---------------");
		
		System.out.println("Concatenazione");
		
		System.out.println("Inserisci una parola");
		String parola=scan.next();
		
		System.out.println("Inserisci un valore");
		int valore=scan.nextInt();
		
		System.out.println("La loro cocatenzaione è: "+Concatenazione(parola,valore));
		
		
		
		
		System.out.println("----------------");
		
		System.out.println("Inserisci Array");
		
		String arr[]= {"ciao","mi","chiamo","mario","!"};
		
		System.out.println("Inserisci una parola");
		parola=scan.next();
		
		
		StampaArray(InserisciArray(arr,parola));
		
		System.out.println("----------------");
		
		System.out.println("Ordinamento");
		
		System.out.println("Inserisci la prima parola");
		String parola_1=scan.next();
		
		System.out.println("Inserisci la seconda parola");
		String parola_2=scan.next();
		
		System.out.println("Inserisci la terza parola");
		String parola_3=scan.next();
		
		System.out.println("Ordinamento è: "+Ordinamento(parola_1,parola_2,parola_3));
		
		System.out.println("Ordinamento inverso è: "+Ordinamento_inverso(parola_1,parola_2,parola_3));
		
		System.out.println("-----------------");
		
		System.out.println("Perimetro Rettangolo");
		
		System.out.println("Inserisci il primo Lato");
		double lato_a=scan.nextDouble();
		
		System.out.println("Inserisci il secondo Lato");
		double lato_b=scan.nextDouble();
		
		System.out.println("Il  perimetro del rettangolo è: "+Perimetro_rettangolo(lato_a,lato_b));
		
		System.out.println("----------------");
		
		System.out.println("Pari e Dispari");
		
		System.out.println("Inserisci il valore");
		valore=scan.nextInt();
		
		System.out.println("Il valore "+valore+" è: "+Pari_Dispari(valore));
		
		
		System.out.println("-------------------");
		
		System.out.println("Area del Triangolo Avendo il valore del perimetro");
		
		System.out.println("Inserisci il primo lato");
		lato_a=scan.nextDouble();
		
		System.out.println("Inserisci il secondo lato");
		lato_b=scan.nextDouble();
		
		System.out.println("Inserisci il terzo lato");
		double lato_c=scan.nextDouble();
		
		System.out.println("Il valore del area del triangolo è: "+Perimetro_trinagolo(lato_a,lato_b,lato_c));
		
		
		}



//Moltiplicazione

public static int Moltiplicazione(int a, int b) {
	return a*b;
}


//CONCATENAZIONE

public static String Concatenazione(String a, int b) {
	return a+b;
}


//InserisciArray

public static String[] InserisciArray(String [] a,String parola) {
	String [] b=new String[6];
	
	for(int i=0; i < a.length ;i++) {
		
		b[0]=a[0];
		b[1]=a[1];
		b[2]=parola;
		b[3]=a[2];
		b[4]=a[3];
		b[5]=a[4];
	}
	
	
	return b;

}


public static void StampaArray(String [] b) {
		
	for(int i=0; i<b.length;i++) {
			
		System.out.println(b[i]);
		
	}
	
}



//Inserimento di tre valori sia in oridine e sia inverso

public static String Ordinamento(String a,String b, String c) {
	
	return a+" "+b+" "+c;
}



public static String Ordinamento_inverso(String a,String b, String c) {
	
	return c+" "+b+" "+a;
}


//Perimento Rettangolo

	public static double Perimetro_rettangolo(double a, double b) {
			
		double perimentro;
		return  perimentro=a*b;
	}



//Pari e Dispari
	public static String Pari_Dispari(int valore){
		
		
		
		if((valore%2)==0) {
			
		return "pari";
	
		}else {
			
			return "dispari";
		}
		
	}



//Perimentro del Triangolo
	public static double Perimetro_trinagolo(double a,double b, double c) {
		
		double area=(a+b+c)/2;
		
		 return area;
		
	
	}


}



