package GodFhaterPizza_Extends.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


public class PizzaMargherita extends PizzaBase {
	
	public PizzaMargherita() {
		super("Pizza Margherita (tomato, cheese)", 4.99, 1104d);
	}

}
