package GodFhaterPizza_Extends.model;
import org.springframework.beans.factory.annotation.Value;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@PropertySource("classpath:application.properties")
@ToString
public class Ordine {
private int numero_ordine;
private Tavolo tavolo;
private List<FoodItem> foodlist;
private StatoOrdine stato_ordine;
private LocalDateTime orario;
private int numero_coperti;
private double costoCoperto;




public Ordine(int numero_ordine, Tavolo tavolo, int numero_coperti,double costoCoperto) throws Exception {
	super();
	this.numero_ordine = numero_ordine;
	this.tavolo =tavolo;
	this.tavolo.setStato(true);
	this.foodlist=new ArrayList<FoodItem>();
	this.numero_coperti = controlloCoperti(numero_coperti);
	this.stato_ordine=StatoOrdine.INCORSO;
	this.orario=LocalDateTime.now();
	this.costoCoperto=costoCoperto;
}

public int controlloCoperti(int numeroCoperti) throws Exception {
	if(this.tavolo.getMax_coperti()<numeroCoperti) {
		throw new Exception("numero coperti errato");
	}else {
		return numeroCoperti;
	}
}


public Double getTotale() {
	double  totale=0;
	double costoCoperti=costoCoperto*numero_coperti;
	for(FoodItem f:foodlist) {
		totale+=f.getPrice();
	}
	
	return totale + costoCoperti;
}

}
