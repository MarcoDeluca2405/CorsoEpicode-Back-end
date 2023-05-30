package GodFhaterPizza_Extends.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Tavolo implements Ordini{
	
	private int  numero;
	private int max_coperti;
	private StatoTavolo stato;
	
	
	@Override
	public double getCost(double coperto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getAllOrdine(Menu ordine) {
		// TODO Auto-generated method stub
		
	}
	
}
