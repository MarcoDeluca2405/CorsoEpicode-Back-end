package com.GestioneIncendi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.GestioneIncendi.model.Sonda;
import com.GestioneIncendi.service.Service_Sonda;

class TestSonda {
	@Autowired Service_Sonda ss;
	Sonda s;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	System.out.println("inizio del test");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	System.out.println("fine del test");
	}

	@BeforeEach
	void setUp() throws Exception {
		s= new Sonda();
		s.setId((long) 1);
		s.setAltidudine(1234);
		s.setLongitudine(3432);
		s.setLivello_fummo(6);
	}

	@AfterEach
	void tearDown() throws Exception {
		s=null;
	}

	@Test
	void testAllarm() {
		assertTrue(s.getLivello_fummo()>5);
	}
	
	@Test
	void testDifferentObject() {
		Sonda newS=(Sonda) s.clone();
		newS.setLivello_fummo(4);
		newS.setId((long)2);
		//newS.setAltidudine(2345);
		newS.setLongitudine(345);
		
		assertTrue(s.getId()!= newS.getId() && (s.getAltidudine()!= newS.getAltidudine() || s.getLongitudine()!= newS.getLongitudine()),"gli oggetti sono uguali");
		
	}
	
	@Test
	void removedListAllarmById() {
		List<Sonda> allarmi=new ArrayList<>();
		
		Sonda n1=(Sonda)s.clone();
		n1.setId((long)1);
		n1.setLivello_fummo(7);
		n1.setAltidudine(1234);
		n1.setLongitudine(5432);
			
		Sonda n2=(Sonda)s.clone();
		n2.setId((long)2);
		n2.setLivello_fummo(8);
		n2.setAltidudine(1231);
		n2.setLongitudine(542);
		
		Sonda n3=(Sonda)s.clone();
		n3.setId((long)3);
		n3.setLivello_fummo(10);
		n3.setAltidudine(12443);
		n3.setLongitudine(5666);
		
		Collections.addAll(allarmi,n1,n2,n3);
		
		int size=allarmi.size();
		int newSize;
		
		
		for(Sonda so: allarmi) {
			if(so.getId().equals(n2.getId())) {
				allarmi.remove(so);
			}
		}
		
		allarmi.forEach(so-> System.out.println("id: "+so.getId()+" -> "+so));
		

		newSize=allarmi.size();
		
		assertNotEquals(size, newSize);
		
	}
	

}
