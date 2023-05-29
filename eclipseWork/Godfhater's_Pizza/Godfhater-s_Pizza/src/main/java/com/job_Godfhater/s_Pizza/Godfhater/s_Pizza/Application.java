package com.job_Godfhater.s_Pizza.Godfhater.s_Pizza;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.metrics.ApplicationStartup;

import com.Configuration_Beans.Configuration_Beans;
import com.Beans.*;

@SpringBootApplication
public class Application {
 static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		MenuPizza();
		
	}

	
	
	public static void MenuPizza() {
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext(Configuration_Beans.class);
		
		Pizza p1=(Pizza) appContext.getBean("pizzaMargherita");
		
		List<Ingredienti> Arrabiata=new ArrayList<Ingredienti>();
		List<Ingredienti> Prosciutto_cotto=new ArrayList<Ingredienti>();
		List<Ingredienti> Funghi=new ArrayList<Ingredienti>();
		List<Ingredienti> Carciofi=new ArrayList<Ingredienti>();
		List<Ingredienti> Wurstel=new ArrayList<Ingredienti>();
		List<Ingredienti> Patatine=new ArrayList<Ingredienti>();
		List<Ingredienti> Quatro_stagioni=new ArrayList<Ingredienti>();
		
		
		Ingredienti salame_piccante=new Ingredienti("Salame Piccante",1);
		Ingredienti patatine=new Ingredienti("Patatine",1);
		Ingredienti olive=new Ingredienti("Olive",1);
		Ingredienti caperi=new Ingredienti("caperi",1);
		Ingredienti carciofi=new Ingredienti("carciofi",1);
		Ingredienti funghi=new Ingredienti("funghi",1);
		Ingredienti prosciutto_cotto=new Ingredienti("prosciutto_cotto",1);
		Ingredienti wurstel=new Ingredienti("wurstel",1);
		
		
		Arrabiata.add(salame_piccante);
		Prosciutto_cotto.add(prosciutto_cotto);
		Funghi.add(funghi);
		Carciofi.add(carciofi);
		Wurstel.add(wurstel);
		Patatine.add(patatine);
		Collections.addAll(Quatro_stagioni,wurstel,prosciutto_cotto);
		
		Pizza p2=(Pizza) appContext.getBean("pizza","Arrabiata",Arrabiata,800,5.5);
		Pizza p3=(Pizza) appContext.getBean("pizza","Prosciutto_cotto",Prosciutto_cotto,750,5.5);
		Pizza p4=(Pizza) appContext.getBean("pizza","Funghi",Funghi,850,6.5);
		Pizza p5=(Pizza) appContext.getBean("pizza","Carciofi",Carciofi,820,6.0);
		Pizza p6=(Pizza) appContext.getBean("pizza","Wurstel",Wurstel,1200,5.5);
		Pizza p7=(Pizza) appContext.getBean("pizza","Patatine",Patatine,1050,5.0);
		Pizza p8=(Pizza) appContext.getBean("pizza","Quatro_stagioni",Quatro_stagioni,2500,7);
		
		List<Pizza> pizza=new ArrayList<Pizza>();
		
		Collections.addAll(pizza, p1,p2,p3,p4,p5,p6,p7,p8);
		
		Integer scelta;
		do {
		
			System.out.println("\n1-Menu Pizza\n");
			System.out.println("2-Menu Bibita\n");
			System.out.println("3-Menu Accessori\n");
			System.out.println("0-exit\n");
			
		scelta=Integer.parseInt(scan.nextLine());
		switch(scelta) {
		
		
		case 1:
			
			System.out.println("----------Menu Piza----------\n");
			pizza.forEach(p-> System.out.println(pizza.indexOf(p)+"- "+p.readPizza()));
			
			System.out.println("scegli la tua pizza!\n");
			Integer scelta2=Integer.parseInt(scan.nextLine());
			
			try {
			if(pizza.toArray().length>=scelta2) {
				System.out.println("hai scelto: "+pizza.get(scelta2).readPizza());
				
				System.out.println("vuoi aggiungere ingredienti in piu? true/false");
				boolean scelta3=Boolean.parseBoolean(scan.nextLine());
				if(scelta3) {
					
					Integer scelta4;
					
					do {
						
						
					pizza.get(scelta2).getIngrediente().forEach(i-> System.out.println(pizza.get(scelta2).getIngrediente().indexOf(i)+"- "+i));
					
					System.out.println("Scegli ingrediente. per uscire premi 10 ");
					scelta4=Integer.parseInt(scan.nextLine());
				
					if(scelta4!=10) {
						System.out.println(pizza.get(scelta2).getIngrediente().get(scelta4)+"\n");
						System.out.println("inserisci quantita");
					Integer quantita=Integer.parseInt(scan.nextLine());
					if(quantita>=1) {
					
					pizza.get(scelta2).getIngrediente().get(scelta4).setQuantita(quantita);
					Pizza newpizza=new Pizza(pizza.get(scelta2).getNome(),pizza.get(scelta2).getIngrediente(),pizza.get(scelta2).getCal(),pizza.get(scelta2).getPrezzo());
					
					pizza.set(scelta2,newpizza);
					
					}else {
						System.out.println("puoi solo aggiugere almeno 1 di quantità \n");
					}
					}
					}while(!scelta4.equals(10));
					
					System.out.println("il costo della tua pizza è: "+pizza.get(scelta2).getPrezzo()+" €");

					
				}else {
					System.out.println("il costo della tua pizza è: "+pizza.get(scelta2).getPrezzo()+" €");
				}
				
			}
			
			}catch(IndexOutOfBoundsException e) {
				System.out.println("non hai scelto nessuna pizza! \n");
			}
			
			break;
			
		case 2:
			
			break;
			
		case 3:
			
			break;
			
		 default:
			 System.out.println("non hai fatto nessuna scelta \n");
			 break;
		}
		
		}while(!scelta.equals(0));
		
			
			
			System.out.println("----------Menu Bibita----------");
			
			
			System.out.println("----------Menu Accessori----------");
			
		}
}
