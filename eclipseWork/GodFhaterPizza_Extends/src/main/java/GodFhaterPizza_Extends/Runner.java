package GodFhaterPizza_Extends;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import GodFhaterPizza_Extends.config.MenuConfig;
import GodFhaterPizza_Extends.config.OrdineConfiguration;
import GodFhaterPizza_Extends.config.TavoloConfiguration;
import GodFhaterPizza_Extends.model.Drink;
import GodFhaterPizza_Extends.model.Ordine;
import GodFhaterPizza_Extends.model.Pizza;
import GodFhaterPizza_Extends.model.StatoOrdine;
import GodFhaterPizza_Extends.model.Tavolo;



@Component
public class Runner implements CommandLineRunner{
Logger log = LoggerFactory.getLogger(Runner.class);
private static Map<Integer,Tavolo> listTavoli=new HashMap<Integer,Tavolo>();
private static Map<Integer,Ordine> listOrdini=new HashMap<Integer,Ordine>();
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		start_Beans();
		configWith_Bean();
	}

	
	public void start_Beans() {
		log.info("start...");
		GestioneMenu stampa = new GestioneMenu();
		stampa.stampaMenu();
		stampa.testTopping();
		
	}
	
	public static void configWith_Bean() {
		try (AnnotationConfigApplicationContext appContext_ordine = new AnnotationConfigApplicationContext(OrdineConfiguration.class);
				AnnotationConfigApplicationContext appContext_tavolo = new AnnotationConfigApplicationContext(TavoloConfiguration.class);
						AnnotationConfigApplicationContext appContext_menu = new AnnotationConfigApplicationContext(MenuConfig.class)		
				) {
			Tavolo tavolo= (Tavolo)appContext_tavolo.getBean("tavolo",1,4);
			Tavolo tavolo2= (Tavolo)appContext_tavolo.getBean("tavolo",2,3);
			listTavoli.put(tavolo.getNumeroTavolo(),tavolo);
			listTavoli.put(tavolo2.getNumeroTavolo(),tavolo2);
			
			Ordine ordine1=(Ordine) appContext_ordine.getBean("ordineTavolo",1,listTavoli.get(1),4);
			Ordine ordine2=(Ordine) appContext_ordine.getBean("ordineTavolo",2,listTavoli.get(2),3);
			
			Pizza margherita=(Pizza)appContext_menu.getBean("pizzaMargherita");
			Pizza salame=(Pizza)appContext_menu.getBean("pizzaSalami");
			
			Drink lemonade=(Drink)appContext_menu.getBean("drinkLemonade");
			
			ordine1.getFoodlist().add(margherita);
			ordine1.getFoodlist().add(salame);
			ordine1.getFoodlist().add(lemonade);
			
			ordine2.getFoodlist().add(margherita);
			ordine2.getFoodlist().add(margherita);
			ordine2.getFoodlist().add(salame);
			ordine2.getFoodlist().add(lemonade);
			ordine2.getFoodlist().add(lemonade);
			ordine2.getFoodlist().add(lemonade);
			
			listOrdini.put(ordine1.getNumero_ordine(), ordine1);
			listOrdini.put(ordine2.getNumero_ordine(), ordine2);
			
			System.out.println(tavolo+"\n");
			
			for(int i=1;i<=listOrdini.size();i++) {
				
				System.out.println("\n numero Ordine: "+listOrdini.get(i).getNumero_ordine());
				System.out.println(listOrdini.get(i).getTavolo());
				listOrdini.get(i).getFoodlist().forEach(f-> System.out.println(f.getName()+" "+f.getCalories()+" cal "+f.getPrice()+"€"));
				System.out.println(listOrdini.get(i).getTotale()+"€");
			}
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
