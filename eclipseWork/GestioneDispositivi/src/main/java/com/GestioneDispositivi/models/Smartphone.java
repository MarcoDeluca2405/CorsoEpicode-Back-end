package com.GestioneDispositivi.models;

import com.GestioneDispositivi.enumeration.Status;
import com.GestioneDispositivi.enumeration.Tipo_connettività;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Smartphone  extends Dispositivo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Tipo_connettività connettività;
}
