package com.generationc20.RentMySpeakerRestAPI.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.generationc20.RentMySpeakerRestAPI.dao.ImagenPublicacionRepository;
import com.generationc20.RentMySpeakerRestAPI.dao.PublicacionRepository;
import com.generationc20.RentMySpeakerRestAPI.dao.UsuarioRepository;
import com.generationc20.RentMySpeakerRestAPI.model.ImagenPublicacion;
import com.generationc20.RentMySpeakerRestAPI.model.Publicacion;
import com.generationc20.RentMySpeakerRestAPI.model.Solicitud;
import com.generationc20.RentMySpeakerRestAPI.model.Usuario;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuariorep;
	@Autowired
	private PublicacionRepository publirep;
	@Autowired
	private ImagenPublicacionRepository img_publirep;
	
	@Override
	public Usuario createUsuario(Usuario usuario) {
		String password = usuario.getContra();
		String hashPass = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		usuario.setContra(hashPass);
		usuario.setFecha(new Date());
		return usuariorep.save(usuario);
	}
	@Override
	public Publicacion createPubli(Integer id_usuario,Publicacion publicacion) {
		publicacion.setId_usuario(id_usuario);
		publicacion.setFecha(new Date());
		return publirep.save(publicacion);
	}
	@Override
	public Solicitud createSolici(Solicitud solicitud) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return usuariorep.findAll();
	}
	@Override
	public Optional<Usuario> getById(Integer id) {
		// TODO Auto-generated method stub
		return usuariorep.findById(id);
	}
	@Override
	public Usuario update(Integer id, Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void esconderSolicitud(Integer id, Solicitud solicitud) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Publicacion> getAllPublicaciones() {
		// TODO Auto-generated method stub
		return publirep.findAll();
	}
	@Override
	public ImagenPublicacion asignImgToPost(Integer id_publicacion, ImagenPublicacion imagen_publicacion) {
		// TODO Auto-generated method stub
		imagen_publicacion.setId_publicacion(id_publicacion);
		imagen_publicacion.setFecha(new Date());
		return img_publirep.save(imagen_publicacion);
	}
	
	
}
