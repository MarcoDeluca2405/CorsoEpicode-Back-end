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
public class Tavolo {
	
	private int  numeroTavolo;
	private int max_coperti;
	private boolean stato;
	
	public Tavolo(int numeroTavolo, int max_coperti) {
		super();
		this.numeroTavolo = numeroTavolo;
		this.max_coperti = max_coperti;
		this.stato=false;
	}
	
	

}
