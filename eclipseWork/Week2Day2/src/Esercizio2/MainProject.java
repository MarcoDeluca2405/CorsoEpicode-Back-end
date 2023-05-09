package Esercizio2;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.slf4j.*;

public class MainProject {
static Logger log=LoggerFactory.getLogger(MainProject.class);
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		
		log.info("Inserisci un valore");
		int n=Integer.parseInt(scan.nextLine());
		List <Integer> arr=num(n);
		
		
		log.info(arr.toString());
		log.info(reversNum(arr).toString());
		log.info(pariDispari(arr,false).toString());

	}
	
	
	public static List<Integer> num(int n){
		List <Integer> arrList=new ArrayList<Integer>();
		int [] arr=new int[n];
		
		for(Integer i: arr) {
			arrList.add((int) (Math.random()*100));
		}
		arrList.sort(null);
		return arrList;
	}
	
	public static List<Integer> reversNum(List<Integer> oldArrList){
		List <Integer> arrList=oldArrList;
		
		
		
		arrList.sort(Collections.reverseOrder());
		return arrList;
	}
	
	
	public static List<Integer> pariDispari(List<Integer> oldArray,boolean t){
		List <Integer> arrList=oldArray;
		List <Integer> newArrList= new ArrayList <Integer>();
		
		for(Integer i:arrList) {
			
			if(t==true) {
				if((i%2)==0) {
				newArrList.add(i);
				}
			}else {
				if((i%2)==1) {
				newArrList.add(i);
				}
			}
		}
		
		
		return newArrList;
	}
	
}	
