package com.GestioneDispositivi.security.service;

import com.GestioneDispositivi.security.payload.LoginDto;
import com.GestioneDispositivi.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
