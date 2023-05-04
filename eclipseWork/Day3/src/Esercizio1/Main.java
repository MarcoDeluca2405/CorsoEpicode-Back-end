package Esercizio1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String parola="cia";
		
		if(parola.length()%2==0) {
			System.out.println("La parola è pari");
		}else {
			System.out.println("La parola è dispari");
		}
		
		
		System.out.println("--------------");
		
		int anno= 2012;
		
		boolean bisestile = (anno>1584 && ((anno%400 ==0) || (anno%4 ==0 && anno % 100 !=0)));
		
		if(bisestile) {
			System.out.println("L'anno "+anno+" è Bisestile");
		}else {
			System.out.println("L'anno "+anno+" non è Bisestile");
		}
	}

}
