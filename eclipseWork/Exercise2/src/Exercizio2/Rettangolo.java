package Exercizio2;

public class Rettangolo {

	public double lar=0;
	public double alt=0;
	
	public Rettangolo(double lar,double alt) {
		this.lar=lar;
		this.alt=alt;
		
	}
	
	public double perimentroRet() {
		
		
		
		double p=lar+alt+lar+alt;
		return p;
		
	}
	
public double areaRet() {
		
	double a=lar*alt;
	return a;
		
	}
	
	public void stampaRettangolo() {
	
		
		double p=lar+alt+lar+alt;
		double a=lar*alt;
		
		System.out.println("Il perimentro del rettangolo è: "+p);
		
		System.out.println("L'area del rettangolo è: "+a);
		
	}
	
	
	public void stampaDueRettangoli(Object ret, Object ret2) {
		
		Rettangolo a= (Rettangolo) ret;
		Rettangolo b= (Rettangolo) ret2;
		System.out.println("-------------------");
		a.stampaRettangolo();
		b.stampaRettangolo();
		System.out.println("-------------------");
		double somma_p=a.perimentroRet()+b.perimentroRet();
		double somma_a=a.areaRet()+b.areaRet();
		
		System.out.println("La loro somma del perimetro è: "+somma_p);
		System.out.println("La loro somma del area è: "+somma_a);
	}
	
}
