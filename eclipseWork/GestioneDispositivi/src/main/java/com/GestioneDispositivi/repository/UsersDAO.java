package com.GestioneDispositivi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestioneDispositivi.security.entity.User;
import java.util.List;
import com.GestioneDispositivi.models.Dispositivo;


@Repository
public interface UsersDAO extends JpaRepository<User, Long> {
	
	public boolean existsByUsername(String username);
}
