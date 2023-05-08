package Exercise1;

import java.util.*;


public class MainProject {

	public static void main(String[] args) {

		stampaArray(cambiaValore(creaArray()));

	}
	
	
	public static int [] creaArray() {
		int [] arr=new int [5];
		for(int i=0; i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10)+1;
		}
		return arr;
	}
	
	public static void stampaArray(int [] arr) {
		System.out.print("[ ");
		for(int i=0; i<arr.length;i++) {
			if(i<arr.length-1) {
			System.out.print(arr[i]+", ");
			}else {
				System.out.print(arr[i]);
			}
		}
		System.out.print("] ");
		
		
	}
	
	public static int [] cambiaValore(int [] arr) {
		Scanner sc=new Scanner(System.in);
		arr=creaArray();
		int index = 1;
		
		
		
		do {
		try {
			System.out.println("Inserisci l'indice di assegnazione, max index 4");
			System.out.println("Premere 0 per uscire e stampare il nuovo array");
			System.out.println("-----------------------");
			index=Integer.parseInt(sc.nextLine());
			if(index!=0) {
			arr[index]=valori();
			}

		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("Valore di indice non permesso");
			
		}catch(java.lang.NumberFormatException e) {
			System.out.println("Non è un valore");
		}
		}while(index!=0);
		return arr;
	}
	
	
	public static int valori() {
		int valore=0;
		do {
		try {
			
			System.out.println("Inserisci Valore tra 1 e 10");
			Scanner sc=new Scanner(System.in);
			valore=Integer.parseInt(sc.nextLine());
			if(valore >=1 && valore <= 10) {
			}else {
			System.out.println("il valore non è compreso tra 1 e 10");	
			}

		}catch(java.lang.NumberFormatException e) {
			System.out.println("Non è un valore");	
		}
		
		}while(valore <1 || valore > 10);
		
		return valore;
		
	}
	

}
