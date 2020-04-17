package com.generationc20.RentMySpeakerRestAPI.service;

import java.util.List;

import java.util.Optional;

import com.generationc20.RentMySpeakerRestAPI.model.ImagenPublicacion;

import com.generationc20.RentMySpeakerRestAPI.model.Publicacion;

import com.generationc20.RentMySpeakerRestAPI.model.Renta;

import com.generationc20.RentMySpeakerRestAPI.model.Solicitud;
import com.generationc20.RentMySpeakerRestAPI.model.TipoArticulo;
import com.generationc20.RentMySpeakerRestAPI.model.Usuario;
import com.generationc20.RentMySpeakerRestAPI.model.ViewRentArrendador;
import com.generationc20.RentMySpeakerRestAPI.model.ViewRentArrendatario1;
import com.generationc20.RentMySpeakerRestAPI.model.ViewSolicitudPublicacion;

import com.generationc20.RentMySpeakerRestAPI.model.ViewSolicitudRecibida;


public interface UsuarioService {
	
	Usuario createUsuario (Usuario usuario);
	
	Publicacion createPubli (Integer id_usuario ,Publicacion publicacion);
	
	ImagenPublicacion asignImgToPost (Integer id_publicacion, ImagenPublicacion imagen_publicacion);
	
	Solicitud createSolici (Integer id_usuario, Integer id_publicacion, Solicitud solicitud);
	
	Renta createRenta (Integer id_solicitud);
	
	Solicitud changeSoliciState (Integer id_solicitud,Integer state);
	
	Renta changeRentState (Integer id_renta, Integer state);
	
	List <Usuario> getAllUsuarios();
	
	List <Publicacion> getAllPublicaciones();
	
	List <Publicacion> getAllFromTypeFilteredByUserID (Integer tipo_articulo, Integer id_usuario);
	
	List <Publicacion> getAllFromType (Integer tipo_articulo);
	
	List <Publicacion> getLastElements (Integer threshold);
	
	List <Publicacion> getPostsByIdOwner (Integer id_usuario);
	
	List <Publicacion> filterPostByType (List <Publicacion> publicaciones, Integer id_usuario);
	
	List <Solicitud> getAllSolicitudes();
	
	List <Solicitud> getSolicitudesByPostId (Integer id_publicacion);
	
	List <Solicitud> getSolicitudByStateAndOwerId (Integer id_arrendador);
	
	List <Solicitud> getSolicitudByPost (List <Publicacion> publicaciones);
	
	List <Solicitud> filterByState (Integer estado_solicitud, List <Solicitud> solicitudes_raw);
	
	List <Renta> getRentasByUserId (Integer id_usuario);
	
	List <Renta> filterByState (List <Renta> rentas_raw);
	
	List <ViewSolicitudRecibida> getAllSolicitudesRecibidas (Integer id_usuario);
	
	List <ViewSolicitudPublicacion> getAllSolicitudesEnEspera (Integer id_usuario);
	
	List <ViewRentArrendador> mostrarRentasEnProceso (Integer id_usuario);
	
	List <ViewRentArrendatario1> mostrarRentasAceptadas (Integer id_usuario);
	
	Optional <Usuario> getUsuarioById (Integer id);
	
	Optional <Publicacion> getPublicacionById (Integer id);
	
	Optional <Solicitud> getSolicitudById (Integer id);
	
	Usuario update (Integer id, Usuario usuario);
	
	void esconderSolicitud (Integer id, Solicitud solicitud);
	
}
