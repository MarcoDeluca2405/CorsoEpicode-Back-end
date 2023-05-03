package Exercizio2;

public class OperatoreTelefonico {

	public int number;
	public double credit;
    public String [] list;
	
	
    
    public OperatoreTelefonico(double credit, String [] list) {
    	
    	this.credit=credit;
    	this.list=list;
    	
    }
    
    public int setNumber(int number) {
    	this.number=number;
    	return number;
    }
    
    public void stampaSim() {
    	System.out.println("Il tuo numero: "+number);
    	System.out.println("Il tuo credito: "+credit);
    	System.out.println("Le tue ultime chiamate: ");
    	
    	for(int i=0;i<list.length;i++) {
    		System.out.print(i+" - "+list[i]+" ; ");
    	}
    }
    
    
}
