package Esercizio1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	static Logger log = LoggerFactory.getLogger(MainProject.class);
	static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
		List<String> arr=createArray();
		/*
		log.info("Parole Duplici: "+trovaDuplicati(arr).toString());
		log.info("Numero Distinte: "+Long.toString(numeroDistinte(arr)));
		log.info("Parole Distinte: "+stampaParoleDistinte(arr).toString());
		*/
		
		log.info("Parole Duplici: "+trovaDuplicati(arr));
		log.info("Numero parole Distinte: "+numeroDistinte(arr));
		log.info("parole Distinte: "+stampaParoleDistinte(arr));
	}
	
		
	
	
	public static List<String> createArray() {
		log.info("Quanti elementi vuoi inserire?");
		int n=Integer.parseInt(scan.nextLine());
		List<String> arr=new ArrayList<String>();
		
		for(int i=0;i<n;i++) {
			log.info("Inserisci una parola");
			arr.add(scan.nextLine());
			
		}
		
		return arr;
	}
	
	

	
	/*
	
	public static Set<String> trovaDuplicati(List <String> arr){
		
		Set<String> find =new HashSet<String>();
		return arr.stream().filter(e-> !find.add(e)).collect(Collectors.toSet());
		
	}
	
	public static long numeroDistinte(List <String> arr){
		Set<String> find =new HashSet<String>();
		return arr.stream().filter(e-> find.add(e)).collect(Collectors.counting());
	}
	
	public static Set<String> stampaParoleDistinte(List <String> arr){
		Set<String> find =new HashSet<String>();
		return arr.stream().filter(e->find.add(e)).collect(Collectors.toSet());
	}
*/
	
	public static Set <String> trovaDuplicati(List <String> arr){
		Set <String> find=new HashSet<String>();
		for(String i: arr) {
			if(Collections.frequency(arr, i) > 1) {
				find.add(i);
			}
		}
		return find;
		
	}
	
	public static int  numeroDistinte(List <String> arr) {
		Set <String> find=new HashSet<String>();
		for(String i:arr) {
			find.add(i);
		}
		return find.size();
		
	}
	
	public static Set <String> stampaParoleDistinte(List <String> arr){
		Set<String> find=new HashSet<String>();
		for(String i: arr) {
			find.add(i);
		}
		return find;
	}
	
	
}
