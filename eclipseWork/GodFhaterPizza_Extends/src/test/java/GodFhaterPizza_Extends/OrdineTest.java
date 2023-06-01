package GodFhaterPizza_Extends;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GodFhaterPizza_Extends.model.DrinkLemonade;
import GodFhaterPizza_Extends.model.Ordine;
import GodFhaterPizza_Extends.model.PizzaHawaiian;
import GodFhaterPizza_Extends.model.PizzaMargherita;
import GodFhaterPizza_Extends.model.PizzaSalami;
import GodFhaterPizza_Extends.model.Tavolo;

class OrdineTest {

	Tavolo t;
	Ordine o;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Inizio test");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		t=new Tavolo(1,4);
		o=new Ordine(1,t,2,0.5);

		Collections.addAll(o.getFoodlist(),new PizzaMargherita(),new PizzaSalami(),new DrinkLemonade() );
	}

	


	@Test
	void testGetTotale() {
		assertEquals(13.27, o.getTotale());
	}


	@Test
	void testNewGetTavolo() {
		t=new Tavolo(1,4);
		assertEquals(false, t.isStato());
		System.out.println("testGetTavolo "+t.isStato());
	}
	
	@Test
	void testGetTavolo() {
		assertEquals(true, t.isStato());
		System.out.println("testGetTavolo "+t.isStato());
	}

	

	@Test
	void testGetNumero_coperti() {
		
		assertTrue(t.getMax_coperti()>=o.getNumero_coperti());
		System.out.println("test numeri coperti");
	}
	

	@AfterEach
	void tearDown() throws Exception {
		t=null;
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("fine test");
	}

}
