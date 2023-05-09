package Esercizio3;
import org.slf4j.*;
import java.util.*;

public class MainProject {

	static Logger log=LoggerFactory.getLogger(MainProject.class);
	static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		Map<String,String> tel=addTel();
		
		stampaContatti(tel);
	/*	
		log.info("Cosa vuoi rimuovere? inserisci nome contatto");
		String nome=scan.nextLine();
		stampaContatti(removeTel(tel,nome));
		*/
		
		log.info("Cosa vuoi Cercare? inserisci numero contatto");
		String number=scan.nextLine();
		stampaFindTelName(tel,number);
	}

	
	public static Map<String,String> addTel() {
		Map<String,String> tel=new HashMap<String,String>();
		boolean t=false;
		int cont=1;
	
		
		do {	
			if(cont!=0) {
			log.info("Inserisci Nome");
			String nome=scan.nextLine();
			log.info("Inserisci Numero");
			String numero=scan.nextLine();
			tel.put(nome,numero);
			
			log.info("vuoi continuare premi un qualsisi numero altrimenti premi 0");
			cont=Integer.parseInt(scan.nextLine());
			}else {
				t=true;
			}
			
		}while(!t);
		
		return tel;
	}
	
	
	public static Map<String,String> removeTel(Map<String,String> tel,String nome){
		Map<String,String> newTel=tel;
		
		newTel.remove(nome);
		return newTel;
		
	}
	
	
	public static void stampaFindTelNumber(Map<String,String> tel,String number) {
		Map<String,String> newTel=tel;
		
	///	log.info(newTel);
		
		
	}
	
	public static void stampaFindTelName(Map<String,String> tel,String nome) {
		Map<String,String> newTel=tel;
		
		log.info(nome+" - "+newTel.get(nome));
		
		
	}
	
	public static void stampaContatti(Map<String,String> tel) {
		log.info(tel.toString());
	}
	
}
