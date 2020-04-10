package com.generationc20.RentMySpeakerRestAPI.controller;

import java.util.Date;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.generationc20.RentMySpeakerRestAPI.model.ImagenPublicacion;
import com.generationc20.RentMySpeakerRestAPI.model.Publicacion;
import com.generationc20.RentMySpeakerRestAPI.model.Usuario;
import com.generationc20.RentMySpeakerRestAPI.service.UsuarioService;

@RestController
@RequestMapping ("/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuario_service;
	
	@PostMapping ("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create (@RequestBody Usuario usuario) {
		//usuario.setFecha(new Date());
		return usuario_service.createUsuario(usuario);
	}
	
	@PostMapping ("/{id}/createpublicacion")
	@ResponseStatus (HttpStatus.CREATED)
	public Publicacion createPublicacion (@PathVariable("id") Integer id_usuario, @RequestBody Publicacion publicacion) {
			return usuario_service.createPubli(id_usuario, publicacion);
	}
	
	@PostMapping ("/{id}/publicacion/{id_publicacion}/submitimg")
	@ResponseStatus (HttpStatus.CREATED)
	public ImagenPublicacion submitImg (@PathVariable("id_publicacion") Integer id_publicacion, @RequestBody ImagenPublicacion imagen_publicacion) {
		
		return usuario_service.asignImgToPost(id_publicacion, imagen_publicacion);
	}
	
	@GetMapping ("/publicaciones")
	@ResponseStatus (HttpStatus.OK)
	public List<Publicacion> getPublicaciones () {
		return usuario_service.getAllPublicaciones();
	}
	@GetMapping ("/Usuarios")
	@ResponseStatus (HttpStatus.OK)
	public List<Usuario> getUsuarios () {
		return usuario_service.getAllUsuarios();
	}
	@GetMapping("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public Usuario getUsuarioById (@PathVariable("id") Integer id) {
		return usuario_service.getById(id).get();
	}
}

