package com.generationc20.RentMySpeakerRestAPI.service;

import java.util.List;
import java.util.Optional;

import com.generationc20.RentMySpeakerRestAPI.model.ImagenPublicacion;
import com.generationc20.RentMySpeakerRestAPI.model.Publicacion;
import com.generationc20.RentMySpeakerRestAPI.model.Solicitud;
import com.generationc20.RentMySpeakerRestAPI.model.Usuario;

public interface UsuarioService {
	
	Usuario createUsuario (Usuario usuario);
	Publicacion createPubli (Integer id_usuario ,Publicacion publicacion);
	ImagenPublicacion asignImgToPost (Integer id_publicacion, ImagenPublicacion imagen_publicacion);
	Solicitud createSolici (Solicitud solicitud);
	List<Usuario> getAllUsuarios();
	List<Publicacion> getAllPublicaciones();
	Optional<Usuario> getById (Integer id);
	Usuario update (Integer id, Usuario usuario);
	void esconderSolicitud (Integer id, Solicitud solicitud);
	
}
