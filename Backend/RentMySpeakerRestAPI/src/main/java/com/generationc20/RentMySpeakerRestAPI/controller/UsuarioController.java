package com.generationc20.RentMySpeakerRestAPI.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.generationc20.RentMySpeakerRestAPI.model.Usuario;
import com.generationc20.RentMySpeakerRestAPI.model.ViewRentArrendador;
import com.generationc20.RentMySpeakerRestAPI.model.ViewRentArrendatario1;
import com.generationc20.RentMySpeakerRestAPI.model.Solicitud;

import com.generationc20.RentMySpeakerRestAPI.model.Publicacion;
import com.generationc20.RentMySpeakerRestAPI.model.Renta;
import com.generationc20.RentMySpeakerRestAPI.service.UsuarioService;

import com.generationc20.RentMySpeakerRestAPI.model.ImagenPublicacion;

import com.generationc20.RentMySpeakerRestAPI.model.ViewSolicitudRecibida;

import com.generationc20.RentMySpeakerRestAPI.model.ViewSolicitudPublicacion;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping ("/v1/usuario")
public class UsuarioController {

	Integer i = 1;
	
	@Autowired
	private UsuarioService usuario_service;

	
	@PostMapping ("/create")
	@ResponseStatus (HttpStatus.CREATED)
	public Usuario create (@ModelAttribute Usuario usuario) {
		
			return usuario_service.createUsuario(usuario);
			
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping ("/test")
	@ResponseStatus (HttpStatus.CREATED)
	public Usuario createtest (@RequestBody Usuario usuario1) {
		
		return usuario_service.createUsuario(usuario1);
				
	}
	
	@PostMapping ("/{id}/createpublicacion")
	@ResponseStatus (HttpStatus.CREATED)
	public Publicacion createPublicacion (@PathVariable ("id") Integer id_usuario, @RequestBody Publicacion publicacion) {
		
			return usuario_service.createPubli(id_usuario, publicacion);
			
	}
	
	@PostMapping ("/{id}/publicacion/{id_publicacion}/solicitar") 
	@ResponseStatus (HttpStatus.CREATED)
	public Solicitud createSolicitud (@PathVariable ("id") Integer id_usuario, @PathVariable ("id_publicacion") Integer id_publicacion, @RequestBody Solicitud solicitud) {
		
			return usuario_service.createSolici(id_usuario, id_publicacion, solicitud);
			
	}
	
	@PostMapping ("/{id}/publicacion/{id_publicacion}/submitimg")
	@ResponseStatus (HttpStatus.CREATED)
	public ImagenPublicacion submitImg (@PathVariable ("id_publicacion") Integer id_publicacion, @RequestBody ImagenPublicacion imagen_publicacion) {
		
			return usuario_service.asignImgToPost(id_publicacion, imagen_publicacion);
			
	}
	
	@PostMapping ("/{id}/solicitudes/{id_solicitud}/acceptreq")
	@ResponseStatus (HttpStatus.CREATED)
	public Renta iniciarRenta (@PathVariable ("id_solicitud") Integer id_solicitud) {
		
			return usuario_service.createRenta(id_solicitud);
		
	}
	
	@GetMapping ("/publicaciones")
	@ResponseStatus (HttpStatus.OK)
	public List <Publicacion> getPublicaciones () {
		
			return usuario_service.getAllPublicaciones();
		
	}
	
	@GetMapping ("/Usuarios")
	@ResponseStatus (HttpStatus.OK)
	public List <Usuario> getUsuarios () {
		
			return usuario_service.getAllUsuarios();
		
	}
	
	@GetMapping ("/solicitudes")
	@ResponseStatus (HttpStatus.OK)
	public List <Solicitud> getSolicitudes () {
		
			return usuario_service.getAllSolicitudes();
		
	}
	
	@GetMapping("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public Usuario getUsuarioById (@PathVariable ("id") Integer id) {
		
			return usuario_service.getUsuarioById(id).get();
		
	}
	
	@GetMapping ("/publicacion/{id_publicacion}/solicitudes")
	@ResponseStatus (HttpStatus.OK)
	public List <Solicitud> getSolicitudesByIdP (@PathVariable ("id_publicacion") Integer id_publicacion) {
		
			return usuario_service.getSolicitudesByPostId(id_publicacion);
			
	}
	
	@GetMapping ("/{id}/publicaciones/type/{tipo_publicacion}")
	@ResponseStatus (HttpStatus.OK)
	public List <Publicacion> getPublicacionesByType (@PathVariable ("id") Integer id, @PathVariable ("tipo_publicacion") Integer tipo_publicacion) {
		
			return usuario_service.getAllFromTypeFilteredByUserID(tipo_publicacion, id);
			
	}
	
	@GetMapping ("/publicaciones/type/{tipo_publicacion}")
	@ResponseStatus (HttpStatus.OK)
	public List <Publicacion> getPublicacionesByType (@PathVariable ("tipo_publicacion") Integer tipo_publicacion) {
		
			return usuario_service.getAllFromType(tipo_publicacion);
		
	}
	
	@GetMapping ("/publicaciones/ultimaspublicaciones/{cantidad_publicaciones}")
	@ResponseStatus (HttpStatus.OK)
	public List <Publicacion> getLastestPosts (@PathVariable ("cantidad_publicaciones") Integer cantidad_publicaciones)  {
		
			return usuario_service.getLastElements(cantidad_publicaciones);
			
	}
	
	@GetMapping ("/{id}/publicaciones")
	@ResponseStatus (HttpStatus.OK)
	public List <Publicacion> getPostFromUser (@PathVariable ("id") Integer id_usuario) {
		
			return usuario_service.getPostsByIdOwner(id_usuario);
			
	}
	
	@GetMapping ("/{id}/solicitudes_recibidas")
	@ResponseStatus (HttpStatus.OK)
	public List <Solicitud> getSolicitudesRecibidas (@PathVariable ("id") Integer id_arrendador) {
		
			return usuario_service.getSolicitudByStateAndOwerId(id_arrendador);
			
	}
	
	@GetMapping ("/publicaciones/{id_publicacion}")
	@ResponseStatus (HttpStatus.OK)
	public Optional <Publicacion> getPublicacionByid(@PathVariable ("id_publicacion") Integer id_publicacion) {
		
			return usuario_service.getPublicacionById(id_publicacion);
		
	}
	
	@GetMapping ("/{id}/administracionrentaArrendatario/SolicitudesEnEspera")
	@ResponseStatus (HttpStatus.OK)
	public List <ViewSolicitudPublicacion> solicitudesEnEspera (@PathVariable ("id") Integer id_usuario) {
		
			return usuario_service.getAllSolicitudesEnEspera(id_usuario);
			
	}
	
	@GetMapping ("/{id}/administracionrentaArrendador/solicitudesRecibidasRentas")
	@ResponseStatus (HttpStatus.OK)
	public List <ViewSolicitudRecibida> solicitudesRecibidasMachote (@PathVariable ("id") Integer id_usuario) {
		
			return usuario_service.getAllSolicitudesRecibidas(id_usuario);
			
	}
	
	@GetMapping ("/{id_arrendador}/adminstracionDeRentaArrendador/rentasConfirmadas")
	@ResponseStatus (HttpStatus.OK)
	public List <ViewRentArrendador> getRentasQueAcepte (@PathVariable ("id_arrendador") Integer id_arrendador) {
		
			return usuario_service.mostrarRentasEnProceso(id_arrendador);
			
	}
	
	@GetMapping ("/{id_arrendatario}/administracionDeRentaArrendatario/rentasConfirmadas")
	@ResponseStatus (HttpStatus.OK)
	public List <ViewRentArrendatario1> getRentasQueMeAceptaron (@PathVariable ("id_arrendatario") Integer id_arrendatario) {

			return usuario_service.mostrarRentasAceptadas(id_arrendatario);
	}
	
	@PutMapping ("/solicitud/{id_solicitud}/changestatsol/{state}")
	@ResponseStatus (HttpStatus.ACCEPTED)
	public Solicitud switchSolicitudState (@PathVariable ("id_solicitud") Integer id_solicitud, @PathVariable ("state") Integer state) {
		
			return usuario_service.changeSoliciState(id_solicitud, state);
		
	}
	
	@PutMapping ("/rentas/{id_renta}/changestatren/{state}")
	@ResponseStatus (HttpStatus.ACCEPTED)
	public Renta switchRentaState (@PathVariable ("id_renta") Integer id_renta, @PathVariable ("state") Integer state) {
		
			return usuario_service.changeRentState(id_renta, state);
		
	}
	
}

