package Esercizio1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainProject {

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
		
		List<Product> listaProdotti2=new ArrayList<Product>();
		listaProdotti2.add(prodotto8);
		listaProdotti2.add(prodotto9);
		listaProdotti2.add(prodotto10);
		listaProdotti2.add(prodotto11);
		listaProdotti2.add(prodotto12);
		listaProdotti2.add(prodotto13);
		listaProdotti2.add(prodotto14);

		
		List<Product> filterList=filtraLista(listaProdotti,"Books",100);
		
		filterList.forEach(f -> System.out.println(f));
		Order order=new Order(0001,"Nel Carello",listaProdotti);
		Order order2=new Order(0002,"Nel Carello",listaProdotti2);
		
		
		List<Order> listOrder=new ArrayList<Order>();
		listOrder.add(order);
		listOrder.add(order2);
		
		List<Product> filterOrder=filterOrder(listOrder,"Baby");
		filterOrder.forEach(f-> System.out.println(f));
		
	}
	
	
	
	public static List<Product> filtraLista(List <Product> list,String category,double price) {
		return list.stream()
				.filter(l -> l.getCategory().equals(category) && String.valueOf(l.getPrice()).equals( String.valueOf(price)))
				.collect(Collectors.toList());
	}
	
	
	public static List<Product> filterOrder(List<Order> order,String category){
		List<Product> listProdotti = new ArrayList<Product>();
		
		order.forEach(f->listProdotti.add((Product) f.getProducts()));
		return listProdotti;
		
				
		
	}

}
