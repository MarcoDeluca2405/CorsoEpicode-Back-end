package Esercizio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainProject {
	private static List<Product> listProdotti=new ArrayList<Product>(); 
	private static List<Order> listOrder=new ArrayList<Order>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product prodotto1=new Product(0001,"Signore degli anelli","Books",100);
		Product prodotto2=new Product(0002,"Dracula","Books",100);
		Product prodotto3=new Product(0003,"Marvel","Books",300);
		Product prodotto4=new Product(0004,"Sigfrid","Books",100);
		Product prodotto5=new Product(0005,"Topolino","Baby",50);
		Product prodotto6=new Product(0006,"Dora","Baby",20);
		Product prodotto7=new Product(0007,"Sandokan","Books",500);
		
		
		List<Product> listaProdotti=new ArrayList<Product>();
		listaProdotti.add(prodotto1);
		listaProdotti.add(prodotto2);
		listaProdotti.add(prodotto3);
		listaProdotti.add(prodotto4);
		listaProdotti.add(prodotto5);
		listaProdotti.add(prodotto6);
		listaProdotti.add(prodotto7);
		
		Product prodotto8=new Product(8,"Signore","Books",100);
		Product prodotto9=new Product(9,"dio","Baby",100);
		Product prodotto10=new Product(0010,"dsa","Baby",300);
		Product prodotto11=new Product(0011,"Artur","Books",100);
		Product prodotto12=new Product(0012,"Gardeland","Baby",50);
		Product prodotto13=new Product(0013,"shion","Baby",20);
		Product prodotto14=new Product(0014,"fre","Books",500);
		
		
	
		
		Customer c1=new Customer(1L,"Mario",1);
		Customer c2=new Customer(2L,"Sara",2);
		Customer c3=new Customer(3L,"Francesco",3);
		
		List<Product> listaProdotti2=new ArrayList<Product>();
		listaProdotti2.add(prodotto8);
		listaProdotti2.add(prodotto9);
		listaProdotti2.add(prodotto10);
		listaProdotti2.add(prodotto11);
		listaProdotti2.add(prodotto12);
		listaProdotti2.add(prodotto13);
		listaProdotti2.add(prodotto14);
		
		listProdotti.addAll(listaProdotti);
		listProdotti.addAll(listaProdotti2);
		
		List<Product> filterList=filtraLista(listProdotti,"Books",100);
		
		filterList.forEach(f -> System.out.println(f));
		Order order=new Order(0001,listaProdotti,c1);
		Order order2=new Order(0002,listaProdotti2,c2);
		Order order3=new Order(0002,Arrays.asList(prodotto2,prodotto10,prodotto11,prodotto1),c3);
		
		
		listOrder.add(order);
		listOrder.add(order2);
		listOrder.add(order3);
		
		List<Order> listaOrdineFiltrati=getOrder("Baby");
		listaOrdineFiltrati.forEach(p-> System.out.println(p));
		
		
		System.out.println("******** Lista Prodotti Boys scontati 10% *********");
		List<Product> listaProdottiScontati = getProdottiScont("Baby", 10);
		listaProdottiScontati.forEach(p -> System.out.println(p));
		
	
	
		
	}
	
	
	
	public static List<Product> filtraLista(List <Product> list,String category,double price) {
		return list.stream()
				.filter(l -> l.getCategory().equals(category) && l.getPrice()>=price)
				.collect(Collectors.toList());
	}
	
	public static List<Order> getOrder(String categoria){
		return listOrder.stream()
						.filter(o-> o.getProducts()
								.stream()
											.anyMatch(p->p.getCategory().equalsIgnoreCase(categoria))
											)
						.collect(Collectors.toList());
																								
													
	}
	
	
	public static List<Product> getProdottiScont(String category,double sconto){
		return listProdotti.stream()
				.filter(p-> p.getCategory().equals(category))
				.map(p-> {
					Product pr=p;
					double somSconto=(pr.getPrice()*sconto)/100;
					pr.setPrice(pr.getPrice()-somSconto);
					return pr;
					
				})
				.collect(Collectors.toList());
	}
	

	public static List<Product> getProdottiTier(Integer tier,LocalDate dataStart,LocalDate dataEnd){
		return listOrder.stream()
				.filter(o -> o.getCustomer().getTier()==tier)
				.filter(o -> o.getOrderDate().compareTo(dataStart) >= 0)
				.filter(o -> o.getOrderDate().compareTo(dataEnd)<=0)
				.flatMap(o -> o.getProducts().stream())
				.collect(Collectors.toList());
	}
	
}


