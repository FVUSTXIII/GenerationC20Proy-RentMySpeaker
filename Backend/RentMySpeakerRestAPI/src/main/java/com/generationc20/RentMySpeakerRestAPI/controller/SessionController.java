package com.generationc20.RentMySpeakerRestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.generationc20.RentMySpeakerRestAPI.service.SessionService;

@RestController
@RequestMapping ("/login")
public class SessionController {

	@Autowired
	private SessionService service;
	
	@GetMapping ("/user/{c}/a/{ks}")
	@ResponseStatus (HttpStatus.OK)
	public Integer getConfirmation (@PathVariable ("c") String correo, @PathVariable ("ks") String contra) {
		
			return service.userExist(correo);
			
	}
	
}
