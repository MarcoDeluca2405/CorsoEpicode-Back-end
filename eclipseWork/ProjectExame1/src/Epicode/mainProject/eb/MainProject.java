package Epicode.mainProject.eb;
import java.util.*;

public class MainProject {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String select;
		int count=0;
		
		Multimediale [] m=new Multimediale[5];
	
		
		do {
			
		System.out.println("Cosa vuoi creare? (max 5 oggetti");	
		System.out.println("1-Video");
		System.out.println("2-Registrazione Audio");	
		System.out.println("3-Immagine");	
		System.out.println("0-Per Terminare");
		select=sc.nextLine();
		
		
		switch(select) {
		
		case "0":
			
			break;
		
		case "1":
				if(count<m.length) {
					
					for(int i=count;i<m.length;) {
						
						if(i==count) {
						
						System.out.println("Inserisci il Titolo");
						String titolo=sc.nextLine();
						
						System.out.println("Inserisci la durata");
						int durata=sc.nextInt();
						
						Video v=new Video(titolo,durata);
						m[i]=v;
						count++;
						break;
						}else {
							break;
						}
					}
					
				}else {
					System.out.println("Il contenitore è pieno");
					break;
				}
			
				break;
			
			
		case "2":
			
			if(count<m.length) {
				
				for(int i=count;i<m.length;) {
					
					if(i==count) {
					
					System.out.println("Inserisci il Titolo");
					String titolo=sc.nextLine();
					
					System.out.println("Inserisci la durata");
					int durata=sc.nextInt();
					
					RegistrazioneAudio a=new RegistrazioneAudio(titolo,durata);
					m[i]=a;
					count++;
					break;
					}else {
						break;
					}
				}
				
			}else {
				System.out.println("Il contenitore è pieno");
				break;
			}
		
			break;
			
		
			
		case "3":
			
			if(count<m.length) {
				
				for(int i=count;i<m.length;) {
					
					if(i==count) {
					
					System.out.println("Inserisci il Titolo");
					String titolo=sc.nextLine();
					
					
					Immagine v=new Immagine(titolo);
					m[i]=v;
					count++;
					break;
					}else {
						break;
					}
				}
				
			}else {
				System.out.println("Il contenitore è pieno");
				break;
			}
		
			break;
			
			
		
			
			
		}
			
		}while(!select.equals("0"));
		
		for(int i=0;i<m.length;i++) {
			System.out.println(m[i]);
		}
		
		
		
		do {
			
			System.out.println("Cosa vuoi vedere?");
			System.out.println("1 - Video");
			System.out.println("2 - Registrazione Audio");
			System.out.println("3 - Immagini");
			System.out.println("0 - esci");
			
			select=sc.nextLine();
			
			switch(select) {
			
			case "1":
				
				break;
				
				
			case "2":
				
				break;
				
				
			case "3":
				
				break;
				
				
			
			
			}
			
			
			
			
		}while(!select.equals("0"));
		
		
		
		System.out.println("close Programm");
		
	}

}
