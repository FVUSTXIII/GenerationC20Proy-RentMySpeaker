package com.generationc20.RentMySpeakerRestAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.RentMySpeakerRestAPI.dao.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	SessionRepository sesion;

	@Override
	public Integer userExist(String correo) {
		
		System.out.println(sesion.getCredencialsUsuario(correo));
		
		return sesion.getCredencialsUsuario(correo);
		
	}
	
	
	
}
