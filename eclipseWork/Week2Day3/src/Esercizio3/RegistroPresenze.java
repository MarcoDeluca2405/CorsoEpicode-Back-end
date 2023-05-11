package Esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.*;

public class RegistroPresenze {
	
	private static List<Presenza> listPresenza=new ArrayList<Presenza>();
	private static String path="dati/presenze.txt";
	private static File file=new File(path);

	public static void main(String[] args) {
		Logger log=LoggerFactory.getLogger(RegistroPresenze.class);
	
		
		try {
			//creaPresenze();
			//salvaPresenzeSuFile();
			leggiPresenzeDaFile();
			
			listPresenza.forEach(p -> System.out.println(p));
		} catch (IOException e) {
			log.error("Errore Io file"+e.getMessage());
			//e.printStackTrace();
		}
		
	}

	
	public static void creaPresenze() {
		listPresenza.add(new Presenza("Mario",5));
		listPresenza.add(new Presenza("Giuseppe",9));
		listPresenza.add(new Presenza("Francesco",7));
	}
	
	public static void salvaPresenzeSuFile() throws IOException {
		String presenzeTxt="";
		for(Presenza presenza: listPresenza) {
			if(presenzeTxt.length() !=0) {
				presenzeTxt+="#";
			}
			presenzeTxt+=presenza;
		}
		FileUtils.writeStringToFile(file, presenzeTxt,"UTF-8");
		
	}
	
	public static void leggiPresenzeDaFile() throws IOException {
		String  presenzeTxt=FileUtils.readFileToString(file,"UTF-8");
		String [] arr=presenzeTxt.split("#");
		
		for(String i: arr) {
			String [] arrPersona=i.split("@");
		Presenza p=new Presenza(arrPersona[0],Integer.parseInt(arrPersona[1]));
		listPresenza.add(p);
		}
		
		//System.out.println(presenzeTxt);
		
	}
}
