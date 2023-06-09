package com.GestioneDispositivi.models;

import com.GestioneDispositivi.enumeration.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String model;
	
	@Column(name="cpu_core",nullable=false)
	private int CPU_core;
	
	@Column(nullable=false)
	private int storage;
	
	@Column(name="storage_ram",nullable=false)
	private int storage_RAM;
	
	@Enumerated
	private Status status;
}
