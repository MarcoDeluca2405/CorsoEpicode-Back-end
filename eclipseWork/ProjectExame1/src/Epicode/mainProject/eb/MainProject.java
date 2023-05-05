package Epicode.mainProject.eb;
import java.util.*;

public class MainProject {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String select;
		String select2;
		int count=0;
		
		Multimediale [] m=new Multimediale[5];
	
		
		do {
			
		System.out.println("Cosa vuoi creare? (max 5 oggetti)");	
		System.out.println("1-Video");
		System.out.println("2-Registrazione Audio");	
		System.out.println("3-Immagine");	
		System.out.println(" ");	
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
						String numero=sc.nextLine();
						int durata=Integer.parseInt(numero);
						
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
					String numero=sc.nextLine();
					int durata=Integer.parseInt(numero);
					
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
			for(int i=0;i<m.length;i++) {
				System.out.println((i+1)+" - "+m[i]);
				
			}
			System.out.println("0 - exit");
			
			select=sc.nextLine();
			
			switch(select) {
			
			case "1":
						if(m[0] instanceof Video) {
							
							do {
							
							System.out.println("E' un video cosa vuoi fare?");
							System.out.println("1 - play()");
							System.out.println("2 - Aumenta la luminosità()");
							System.out.println("3 - Diminuisci la Luministà()");
							System.out.println("4 - Aumenta il Volume()");
							System.out.println("5 - Diminuisci il Volume()");
							System.out.println("0 - exit");
							
							select2=sc.nextLine();
							
							switch(select2) {
								
							case "1":
								System.out.println("--------");
								((Video)m[0]).play();
								System.out.println("--------");
								break;
								
							case "2":
								
								System.out.println("--------");
								((Video)m[0]).aumentaLuminosita();
								System.out.println("--------");
								
								break;
								
								
							case "3":
								
								System.out.println("--------");
								((Video)m[0]).diminuisciLuminosita();
								System.out.println("--------");
								
								break;
							
							
							case "4":
								
								System.out.println("--------");
								((Video)m[0]).alzaVolume();
								System.out.println("--------");
								
								break;
								
							case "5":
									
								System.out.println("--------");
								((Video)m[0]).abbassaVolume();
								System.out.println("--------");
								break;
								
							}
							
							
							
							}while(!select2.equals("0"));
							
						}else if(m[0] instanceof RegistrazioneAudio){
							
							
							do {
								
								System.out.println("E' un Audio cosa vuoi fare?");
								System.out.println("1 - play()");
								System.out.println("2 - Aumenta il Volume()");
								System.out.println("3 - Diminuisci il Volume()");
								System.out.println("0 - exit");
								
								select2=sc.nextLine();
								
								switch(select2) {
									
								case "1":
									System.out.println("--------");
									((RegistrazioneAudio)m[0]).play();
									System.out.println("--------");
									break;
									
								case "2":
									
									System.out.println("--------");
									((RegistrazioneAudio)m[0]).alzaVolume();
									System.out.println("--------");
									
									break;
									
									
								case "3":
									
									System.out.println("--------");
									((RegistrazioneAudio)m[0]).abbassaVolume();
									System.out.println("--------");
									
									break;
								
								
								
									
								}
								
								
								
								}while(!select2.equals("0"));
							
							
						}else if(m[0] instanceof Immagine) {

							do {
								
								System.out.println("E' un Immagine cosa vuoi fare?");
								System.out.println("1 - Show()");
								System.out.println("2 - Aumenta il Luminosità()");
								System.out.println("3 - Diminuisci il Luminosità()");
								System.out.println("0 - exit");
								
								select2=sc.nextLine();
								
								switch(select2) {
									
								case "1":
									System.out.println("--------");
									((Immagine)m[0]).show();
									System.out.println("--------");
									break;
									
								case "2":
									
									System.out.println("--------");
									((Immagine)m[0]).aumentaLuminosita();
									System.out.println("--------");
									
									break;
									
									
								case "3":
									
									System.out.println("--------");
									((Immagine)m[0]).diminuisciLuminosita();
									System.out.println("--------");
									
									break;
								
								
								
									
								}
								
								
								
								}while(!select2.equals("0"));
							
							
						}
						
				
				break;
				
				
			case "2":
				if(m[1] instanceof Video) {
					
					do {
					
					System.out.println("E' un video cosa vuoi fare?");
					System.out.println("1 - play()");
					System.out.println("2 - Aumenta la luminosità()");
					System.out.println("3 - Diminuisci la Luministà()");
					System.out.println("4 - Aumenta il Volume()");
					System.out.println("5 - Diminuisci il Volume()");
					System.out.println("0 - exit");
					
					select2=sc.nextLine();
					
					switch(select2) {
						
					case "1":
						System.out.println("--------");
						((Video)m[1]).play();
						System.out.println("--------");
						break;
						
					case "2":
						
						System.out.println("--------");
						((Video)m[1]).aumentaLuminosita();
						System.out.println("--------");
						
						break;
						
						
					case "3":
						
						System.out.println("--------");
						((Video)m[1]).diminuisciLuminosita();
						System.out.println("--------");
						
						break;
					
					
					case "4":
						
						System.out.println("--------");
						((Video)m[1]).alzaVolume();
						System.out.println("--------");
						
						break;
						
					case "5":
							
						System.out.println("--------");
						((Video)m[1]).abbassaVolume();
						System.out.println("--------");
						break;
						
					}
					
					
					
					}while(!select2.equals("0"));
					
				}else if(m[1] instanceof RegistrazioneAudio){
					
					
					do {
						
						System.out.println("E' un Audio cosa vuoi fare?");
						System.out.println("1 - play()");
						System.out.println("2 - Aumenta il Volume()");
						System.out.println("3 - Diminuisci il Volume()");
						System.out.println("0 - exit");
						
						select2=sc.nextLine();
						
						switch(select2) {
							
						case "1":
							System.out.println("--------");
							((RegistrazioneAudio)m[1]).play();
							System.out.println("--------");
							break;
							
						case "2":
							
							System.out.println("--------");
							((RegistrazioneAudio)m[1]).alzaVolume();
							System.out.println("--------");
							
							break;
							
							
						case "3":
							
							System.out.println("--------");
							((RegistrazioneAudio)m[1]).abbassaVolume();
							System.out.println("--------");
							
							break;
						
						
						
							
						}
						
						
						
						}while(!select2.equals("0"));
					
					
				}else if(m[1] instanceof Immagine) {

					do {
						
						System.out.println("E' un Immagine cosa vuoi fare?");
						System.out.println("1 - Show()");
						System.out.println("2 - Aumenta il Luminosità()");
						System.out.println("3 - Diminuisci il Luminosità()");
						System.out.println("0 - exit");
						
						select2=sc.nextLine();
						
						switch(select2) {
							
						case "1":
							System.out.println("--------");
							((Immagine)m[1]).show();
							System.out.println("--------");
							break;
							
						case "2":
							
							System.out.println("--------");
							((Immagine)m[1]).aumentaLuminosita();
							System.out.println("--------");
							
							break;
							
							
						case "3":
							
							System.out.println("--------");
							((Immagine)m[1]).diminuisciLuminosita();
							System.out.println("--------");
							
							break;
						
						
						
							
						}
						
						
						
						}while(!select2.equals("0"));
					
					
				}
				break;
				
				
			case "3":
				if(m[2] instanceof Video) {
					
					do {
					
					System.out.println("E' un video cosa vuoi fare?");
					System.out.println("1 - play()");
					System.out.println("2 - Aumenta la luminosità()");
					System.out.println("3 - Diminuisci la Luministà()");
					System.out.println("4 - Aumenta il Volume()");
					System.out.println("5 - Diminuisci il Volume()");
					System.out.println("0 - exit");
					
					select2=sc.nextLine();
					
					switch(select2) {
						
					case "1":
						System.out.println("--------");
						((Video)m[2]).play();
						System.out.println("--------");
						break;
						
					case "2":
						
						System.out.println("--------");
						((Video)m[2]).aumentaLuminosita();
						System.out.println("--------");
						
						break;
						
						
					case "3":
						
						System.out.println("--------");
						((Video)m[2]).diminuisciLuminosita();
						System.out.println("--------");
						
						break;
					
					
					case "4":
						
						System.out.println("--------");
						((Video)m[2]).alzaVolume();
						System.out.println("--------");
						
						break;
						
					case "5":
							
						System.out.println("--------");
						((Video)m[2]).abbassaVolume();
						System.out.println("--------");
						break;
						
					}
					
					
					
					}while(!select2.equals("0"));
					
				}else if(m[2] instanceof RegistrazioneAudio){
					
					
					do {
						
						System.out.println("E' un Audio cosa vuoi fare?");
						System.out.println("1 - play()");
						System.out.println("2 - Aumenta il Volume()");
						System.out.println("3 - Diminuisci il Volume()");
						System.out.println("0 - exit");
						
						select2=sc.nextLine();
						
						switch(select2) {
							
						case "1":
							System.out.println("--------");
							((RegistrazioneAudio)m[2]).play();
							System.out.println("--------");
							break;
							
						case "2":
							
							System.out.println("--------");
							((RegistrazioneAudio)m[2]).alzaVolume();
							System.out.println("--------");
							
							break;
							
							
						case "3":
							
							System.out.println("--------");
							((RegistrazioneAudio)m[2]).abbassaVolume();
							System.out.println("--------");
							
							break;
						
						
						
							
						}
						
						
						
						}while(!select2.equals("0"));
					
					
				}else if(m[2] instanceof Immagine) {

					do {
						
						System.out.println("E' un Immagine cosa vuoi fare?");
						System.out.println("1 - Show()");
						System.out.println("2 - Aumenta il Luminosità()");
						System.out.println("3 - Diminuisci il Luminosità()");
						System.out.println("0 - exit");
						
						select2=sc.nextLine();
						
						switch(select2) {
							
						case "1":
							System.out.println("--------");
							((Immagine)m[2]).show();
							System.out.println("--------");
							break;
							
						case "2":
							
							System.out.println("--------");
							((Immagine)m[2]).aumentaLuminosita();
							System.out.println("--------");
							
							break;
							
							
						case "3":
							
							System.out.println("--------");
							((Immagine)m[2]).diminuisciLuminosita();
							System.out.println("--------");
							
							break;
						
						
						
							
						}
						
						
						
						}while(!select2.equals("0"));
					
					
				}
				break;
				
				
			case "4":
				if(m[3] instanceof Video) {
					
					do {
					
					System.out.println("E' un video cosa vuoi fare?");
					System.out.println("1 - play()");
					System.out.println("2 - Aumenta la luminosità()");
					System.out.println("3 - Diminuisci la Luministà()");
					System.out.println("4 - Aumenta il Volume()");
					System.out.println("5 - Diminuisci il Volume()");
					System.out.println("0 - exit");
					
					select2=sc.nextLine();
					
					switch(select2) {
						
					case "1":
						System.out.println("--------");
						((Video)m[3]).play();
						System.out.println("--------");
						break;
						
					case "2":
						
						System.out.println("--------");
						((Video)m[3]).aumentaLuminosita();
						System.out.println("--------");
						
						break;
						
						
					case "3":
						
						System.out.println("--------");
						((Video)m[3]).diminuisciLuminosita();
						System.out.println("--------");
						
						break;
					
					
					case "4":
						
						System.out.println("--------");
						((Video)m[3]).alzaVolume();
						System.out.println("--------");
						
						break;
						
					case "5":
							
						System.out.println("--------");
						((Video)m[3]).abbassaVolume();
						System.out.println("--------");
						break;
						
					}
					
					
					
					}while(!select2.equals("0"));
					
				}else if(m[3] instanceof RegistrazioneAudio){
					
					
					do {
						
						System.out.println("E' un Audio cosa vuoi fare?");
						System.out.println("1 - play()");
						System.out.println("2 - Aumenta il Volume()");
						System.out.println("3 - Diminuisci il Volume()");
						System.out.println("0 - exit");
						
						select2=sc.nextLine();
						
						switch(select2) {
							
						case "1":
							System.out.println("--------");
							((RegistrazioneAudio)m[3]).play();
							System.out.println("--------");
							break;
							
						case "2":
							
							System.out.println("--------");
							((RegistrazioneAudio)m[3]).alzaVolume();
							System.out.println("--------");
							
							break;
							
							
						case "3":
							
							System.out.println("--------");
							((RegistrazioneAudio)m[3]).abbassaVolume();
							System.out.println("--------");
							
							break;
						
						
						
							
						}
						
						
						
						}while(!select2.equals("0"));
					
					
				}else if(m[3] instanceof Immagine) {

					do {
						
						System.out.println("E' un Immagine cosa vuoi fare?");
						System.out.println("1 - Show()");
						System.out.println("2 - Aumenta il Luminosità()");
						System.out.println("3 - Diminuisci il Luminosità()");
						System.out.println("0 - exit");
						
						select2=sc.nextLine();
						
						switch(select2) {
							
						case "1":
							System.out.println("--------");
							((Immagine)m[3]).show();
							System.out.println("--------");
							break;
							
						case "2":
							
							System.out.println("--------");
							((Immagine)m[3]).aumentaLuminosita();
							System.out.println("--------");
							
							break;
							
							
						case "3":
							
							System.out.println("--------");
							((Immagine)m[3]).diminuisciLuminosita();
							System.out.println("--------");
							
							break;
						
						
						
							
						}
						
						
						
						}while(!select2.equals("0"));
					
					
				}
				
				break;
				
			case "5":
				
				if(m[4] instanceof Video) {
					
					do {
					
					System.out.println("E' un video cosa vuoi fare?");
					System.out.println("1 - play()");
					System.out.println("2 - Aumenta la luminosità()");
					System.out.println("3 - Diminuisci la Luministà()");
					System.out.println("4 - Aumenta il Volume()");
					System.out.println("5 - Diminuisci il Volume()");
					System.out.println("0 - exit");
					
					select2=sc.nextLine();
					
					switch(select2) {
						
					case "1":
						System.out.println("--------");
						((Video)m[4]).play();
						System.out.println("--------");
						break;
						
					case "2":
						
						System.out.println("--------");
						((Video)m[4]).aumentaLuminosita();
						System.out.println("--------");
						
						break;
						
						
					case "3":
						
						System.out.println("--------");
						((Video)m[4]).diminuisciLuminosita();
						System.out.println("--------");
						
						break;
					
					
					case "4":
						
						System.out.println("--------");
						((Video)m[4]).alzaVolume();
						System.out.println("--------");
						
						break;
						
					case "5":
							
						System.out.println("--------");
						((Video)m[4]).abbassaVolume();
						System.out.println("--------");
						break;
						
					}
					
					
					
					}while(!select2.equals("0"));
					
				}else if(m[4] instanceof RegistrazioneAudio){
					
					
					do {
						
						System.out.println("E' un Audio cosa vuoi fare?");
						System.out.println("1 - play()");
						System.out.println("2 - Aumenta il Volume()");
						System.out.println("3 - Diminuisci il Volume()");
						System.out.println("0 - exit");
						
						select2=sc.nextLine();
						
						switch(select2) {
							
						case "1":
							System.out.println("--------");
							((RegistrazioneAudio)m[4]).play();
							System.out.println("--------");
							break;
							
						case "2":
							
							System.out.println("--------");
							((RegistrazioneAudio)m[4]).alzaVolume();
							System.out.println("--------");
							
							break;
							
							
						case "3":
							
							System.out.println("--------");
							((RegistrazioneAudio)m[4]).abbassaVolume();
							System.out.println("--------");
							
							break;
						
						
						
							
						}
						
						
						
						}while(!select2.equals("0"));
					
					
				}else if(m[4] instanceof Immagine) {

					do {
						
						System.out.println("E' un Immagine cosa vuoi fare?");
						System.out.println("1 - Show()");
						System.out.println("2 - Aumenta il Luminosità()");
						System.out.println("3 - Diminuisci il Luminosità()");
						System.out.println("0 - exit");
						
						select2=sc.nextLine();
						
						switch(select2) {
							
						case "1":
							System.out.println("--------");
							((Immagine)m[4]).show();
							System.out.println("--------");
							break;
							
						case "2":
							
							System.out.println("--------");
							((Immagine)m[4]).aumentaLuminosita();
							System.out.println("--------");
							
							break;
							
							
						case "3":
							
							System.out.println("--------");
							((Immagine)m[4]).diminuisciLuminosita();
							System.out.println("--------");
							
							break;
						
						
						
							
						}
						
						
						
						}while(!select2.equals("0"));
					
					
				}
			
				
				break;
			
			}
			
			
			
			
		}while(!select.equals("0"));
		
		
		
		System.out.println("close Programm");
		
	}

}
