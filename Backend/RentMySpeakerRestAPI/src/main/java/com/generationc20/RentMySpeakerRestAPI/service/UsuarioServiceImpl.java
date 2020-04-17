package com.generationc20.RentMySpeakerRestAPI.service;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.generationc20.RentMySpeakerRestAPI.dao.ImagenPublicacionRepository;

import com.generationc20.RentMySpeakerRestAPI.dao.PublicacionRepository;

import com.generationc20.RentMySpeakerRestAPI.dao.RentaRepository;

import com.generationc20.RentMySpeakerRestAPI.dao.SolicitudRepository;

import com.generationc20.RentMySpeakerRestAPI.dao.UsuarioRepository;

import com.generationc20.RentMySpeakerRestAPI.model.EstadoRenta;

import com.generationc20.RentMySpeakerRestAPI.model.EstadoSolicitud;

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

import at.favre.lib.crypto.bcrypt.BCrypt;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuariorep;
	
	@Autowired
	private PublicacionRepository publirep;
	
	@Autowired
	private ImagenPublicacionRepository img_publirep;
	
	@Autowired
	private SolicitudRepository solirep;
	
	@Autowired
	private RentaRepository rentarep;
	
	
	@Override
	public Usuario createUsuario (Usuario usuario) {
		
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
	public List <Usuario> getAllUsuarios() {

			return usuariorep.findAll();
			
	}
	
	@Override
	public Usuario update (Integer id, Usuario usuario) {
	
			return null;
			
	}
	
	@Override
	public void esconderSolicitud (Integer id, Solicitud solicitud) {
		
	}
	
	@Override
	public List <Publicacion> getAllPublicaciones() {
	
			return publirep.findAll();
			
	}
	
	@Override
	public ImagenPublicacion asignImgToPost (Integer id_publicacion, ImagenPublicacion imagen_publicacion) {
	
		imagen_publicacion.setId_publicacion(id_publicacion);
		imagen_publicacion.setFecha(new Date());
		
			return img_publirep.save(imagen_publicacion);
	}
	
	@Override
	public Solicitud createSolici (Integer id_usuario, Integer id_publicacion, Solicitud solicitud) {
		
		solicitud.setEstado_solicitud(EstadoSolicitud.PENDIENTE);
		solicitud.setId_usuario(id_usuario);
		solicitud.setId_publicacion(id_publicacion);
		solicitud.setFecha(new Date());
		
			return solirep.save(solicitud);
	}
	
	@Override
	public List <Solicitud> getAllSolicitudes () {
	
			return solirep.findAll();
	}
	
	@Override
	public Optional <Usuario> getUsuarioById (Integer id) {

			return usuariorep.findById(id);
		
	}
	
	@Override
	public Optional <Publicacion> getPublicacionById (Integer id) {

			return publirep.findById(id);
		
	}
	
	@Override
	public Optional <Solicitud> getSolicitudById (Integer id) {

		return solirep.findById(id);
	}
	
	@Override
	public List <Solicitud> getSolicitudesByPostId (Integer id_publicacion) {
		
		Publicacion publicacion = getPublicacionById (id_publicacion).get();
		
			return publicacion.getSolicitudes_recibidas();
		
	}
	
	@Override
	public List <Publicacion> getAllFromTypeFilteredByUserID  (Integer tipo_articulo, Integer id_usuario) {
		
		List <Publicacion> lista_cruda = new ArrayList <> ();
		List <Publicacion> lista_filtrada = new ArrayList <> ();
		lista_cruda = getAllPublicaciones();
		
		switch (tipo_articulo) {
		
			case 0:
				for(Publicacion publi : lista_cruda) {
					if((publi.getTipo_articulo() == TipoArticulo.SONIDO) && (publi.getId_usuario() != id_usuario)) {
						lista_filtrada.add(publi);
					}
				}
				break;
				
			case 1:
				for(Publicacion publi : lista_cruda) {
					if((publi.getTipo_articulo() == TipoArticulo.PERCUSIONES) && (publi.getId_usuario() != id_usuario)) {
						
						lista_filtrada.add(publi);
					}
				}
				break;
				
			case 2:
				for(Publicacion publi : lista_cruda) {
					if((publi.getTipo_articulo() == TipoArticulo.INSTRUMENTOS) && (publi.getId_usuario() != id_usuario)) {
						lista_filtrada.add(publi);
					}
				}
				break;
				
			case 3:
				for(Publicacion publi : lista_cruda) {
					if((publi.getTipo_articulo() == TipoArticulo.ELECTRONICOS) && (publi.getId_usuario() != id_usuario)) {
						lista_filtrada.add(publi);
					}
				}
				break;
				
		}
			
			return lista_filtrada;
			
	}
	
	@Override
	public List <Publicacion> getLastElements (Integer Threshold) {
		
		List <Publicacion> publicaciones = getAllPublicaciones();
		List <Publicacion> last_items = new ArrayList <> ();
		
		for (int i = 0; i < Threshold; i++) {
			last_items.add(publicaciones.get((publicaciones.size()-1)-i));
		}
		
			return last_items;
		
	}
	
	@Override
	public List <Publicacion> getPostsByIdOwner (Integer id_usuario) {
		
		Usuario usuario = getUsuarioById(id_usuario).get();
		
			return usuario.getPublicaciones();
	}
	
	@Override
	public List <Solicitud> getSolicitudByStateAndOwerId (Integer id_arrendador) {
		
		Usuario usuario = getUsuarioById(id_arrendador).get();
		List <Solicitud> solicitudes_del_usuario_espera = filterByState (0, getSolicitudByPost(usuario.getPublicaciones()));
		
			return solicitudes_del_usuario_espera;
			
	}
	
	@Override
	public List <Solicitud> filterByState (Integer estado_solicitud, List <Solicitud> solicitudes_raw) {
		
		List <Solicitud> lista_filtrada = new ArrayList <> ();
		
		switch (estado_solicitud) {
		
		case 0:
			for (Solicitud soli : solicitudes_raw) {
				if (soli.getEstado_solicitud() == EstadoSolicitud.PENDIENTE) {
					lista_filtrada.add(soli);
				}
			}
			break;
			
		case 1:
			for (Solicitud soli : solicitudes_raw) {
				if (soli.getEstado_solicitud() == EstadoSolicitud.ACEPTADA) {
					lista_filtrada.add(soli);
				}
			}
			break;
			
		case 2:
			for (Solicitud soli : solicitudes_raw) {
				if (soli.getEstado_solicitud() == EstadoSolicitud.RECHAZADA) {
					lista_filtrada.add(soli);
				}
			}
			break;
			
		}
		
			return lista_filtrada;
		
	}
	
	@Override
	public List <Solicitud> getSolicitudByPost (List<Publicacion> publicaciones) {
		
		List <Solicitud> list_solicitudes_a = new ArrayList<> ();
		
		for (Publicacion publi : publicaciones) {
			list_solicitudes_a.addAll(publi.getSolicitudes_recibidas());
		}
		
			return list_solicitudes_a;
		
	}
	
	@Override
	public Solicitud changeSoliciState (Integer id_solicitud, Integer state) {
		
		Solicitud solicitud = getSolicitudById(id_solicitud).get();
		
		switch (state) {
		
			case 1:
				solicitud.setEstado_solicitud(EstadoSolicitud.RECHAZADA);
				break;
				
			case 2:
				solicitud.setEstado_solicitud(EstadoSolicitud.ACEPTADA);
				break;
				
		}
		
			return solirep.save(solicitud);
			
	}
	
	@Override
	public List <ViewSolicitudPublicacion> getAllSolicitudesEnEspera (Integer id_usuario) {
		
		Usuario usuario = getUsuarioById(id_usuario).get();
		List <Solicitud> solicitudes_usuario = filterByState(0, usuario.getSolicitudes());
		List <ViewSolicitudPublicacion> vl = new ArrayList <> ();
		
		for (Solicitud soli : solicitudes_usuario) {
			Publicacion publicacion = getPublicacionById(soli.getId_publicacion()).get();
			ImagenPublicacion img_pub = publicacion.getImagenes().get(0);
			ViewSolicitudPublicacion v = new ViewSolicitudPublicacion(soli, publicacion, img_pub);
			vl.add(v);
		}
		
			return vl;
			
	}
	
	@Override
	public List <ViewSolicitudRecibida> getAllSolicitudesRecibidas (Integer id_usuario) {
		
		Usuario usuario = getUsuarioById(id_usuario).get();
		List <ViewSolicitudRecibida> vl = new ArrayList <> ();
		
		if(!usuario.getPublicaciones().isEmpty()) {
			
			List <Publicacion> publicaciones = usuario.getPublicaciones();
			List <Solicitud> solicitudes = filterByState(0, getSolicitudByPost(publicaciones));
			
			for (Solicitud soli : solicitudes) {
				Publicacion publicacion = getPublicacionById(soli.getId_publicacion()).get();
				ImagenPublicacion img_pub = publicacion.getImagenes().get(0);
				Usuario usuario_parametro = getUsuarioById(soli.getId_usuario()).get();
				ViewSolicitudRecibida v = new ViewSolicitudRecibida(soli, publicacion, usuario_parametro, img_pub);
				vl.add(v);
			}
		}
		
			return vl;
			
	}

	@Override
	public Renta createRenta (Integer id_solicitud) {
		
		Renta renta = new Renta();
		Solicitud solicitud = getSolicitudById(id_solicitud).get();
		Publicacion publicacion = getPublicacionById(solicitud.getId_publicacion()).get();
		renta.setId_usuario(publicacion.getId_usuario());
		renta.setId_solicitud(id_solicitud);
		renta.setEstado_renta(EstadoRenta.EN_ESPERA);
		renta.setFecha(new Date());
		changeSoliciState(id_solicitud, 2);
		
			return rentarep.save(renta);
			
	}

	@Override
	public List <Renta> getRentasByUserId (Integer id_usuario) {
		
		Usuario usuario = getUsuarioById(id_usuario).get();
		List <Renta> rentas = filterByState(usuario.getRentas());
		
			return rentas;
			
	}

	@Override
	public List <Renta> filterByState (List <Renta> rentas_raw) {
		
		List <Renta> rentas_filtradas = new ArrayList <> ();
		
		for (Renta rent: rentas_raw) {
			if(rent.getEstado_renta() != EstadoRenta.FINALIZADA) {
				rentas_filtradas.add(rent);
			}
		}
		
			return rentas_filtradas;
			
	}

	@Override
	public Renta changeRentState (Integer id_renta, Integer state) {

		Renta renta = rentarep.findById(id_renta).get();
		
		switch (state) {
			
			case 1:
				renta.setEstado_renta(EstadoRenta.EN_PROCESO);
				break;
				
			case 2:
				renta.setEstado_renta(EstadoRenta.FINALIZADA);
				break;
				
		}
		
				return rentarep.save(renta);
			
	}

	@Override
	public List <ViewRentArrendador> mostrarRentasEnProceso (Integer id_usuario) {
			
			List <Renta> rentas = getRentasByUserId(id_usuario);
			List <ViewRentArrendador> vl = new ArrayList <> ();
			
			for (Renta rent : rentas) {
				Solicitud solicitud = getSolicitudById(rent.getId_solicitud()).get();
				Publicacion publicacion = getPublicacionById(solicitud.getId_publicacion()).get();
				ImagenPublicacion img_publicacion = publicacion.getImagenes().get(0);
				Usuario solicitante = getUsuarioById(solicitud.getId_usuario()).get();
				ViewRentArrendador v = new ViewRentArrendador(rent, solicitud, publicacion, img_publicacion, solicitante);
				vl.add(v);				
			}
			
				return vl;
				
	}

	@Override
	public List<ViewRentArrendatario1> mostrarRentasAceptadas(Integer id_usuario) {
		
		Usuario usuario = getUsuarioById(id_usuario).get();
		List <Solicitud> solicitudes = filterByState(1, usuario.getSolicitudes());
		List <Publicacion> publicaciones = new ArrayList <> ();
		List <String> numeros_telefonicos = new ArrayList <> ();
		List <Renta> rentas = new ArrayList <> ();
		List<ViewRentArrendatario1> vl = new ArrayList <> ();
		List <Integer> id_solicitudes = new ArrayList <> (); 
				
		for (Solicitud soli : solicitudes) {

			/*Renta renta = rentarep.findById_Solicitud(soli.getId()).get(0);*/
			Renta renta = rentarep.findById_Solicitud(soli.getId()).get(0);
			System.out.println("Id de la renta: "+ renta.getId());
			Publicacion publicacion = getPublicacionById(soli.getId_publicacion()).get();
			String telefono = getUsuarioById(publicacion.getId_usuario()).get().getNumero_telefonico();
			rentas.add(renta);
			publicaciones.add(publicacion);
			numeros_telefonicos.add(telefono);
			id_solicitudes.add(soli.getId());
		}
		
		rentas = filterByState(rentas);
		System.out.println(rentas);
		int i = 0;
		
		for (Renta rent : rentas) {
			ViewRentArrendatario1 v = new ViewRentArrendatario1(rent, numeros_telefonicos.get(i), publicaciones.get(i), id_solicitudes.get(i));
			vl.add(v);
			i++;
		}
		
			return vl;
			
	}

	@Override
	public List<Publicacion> filterPostByType(List<Publicacion> publicaciones, Integer id_usuario) {
		
		List <Publicacion> dump_into = new ArrayList<> ();
		for (Publicacion pub : publicaciones) {
			if (pub.getId_usuario() != id_usuario) {
				dump_into.add(pub);
			}
		}
		
			return dump_into;
	}

	@Override
	public List<Publicacion> getAllFromType(Integer tipo_articulo) {
		List <Publicacion> lista_cruda = new ArrayList <> ();
		List <Publicacion> lista_filtrada = new ArrayList <> ();
		lista_cruda = getAllPublicaciones();
		
		switch (tipo_articulo) {
		
			case 0:
				for(Publicacion publi : lista_cruda) {
					if(publi.getTipo_articulo() == TipoArticulo.SONIDO) {
						lista_filtrada.add(publi);
					}
				}
				break;
				
			case 1:
				for(Publicacion publi : lista_cruda) {
					if(publi.getTipo_articulo() == TipoArticulo.PERCUSIONES) {
						
						lista_filtrada.add(publi);
					}
				}
				break;
				
			case 2:
				for(Publicacion publi : lista_cruda) {
					if(publi.getTipo_articulo() == TipoArticulo.INSTRUMENTOS) {
						lista_filtrada.add(publi);
					}
				}
				break;
				
			case 3:
				for(Publicacion publi : lista_cruda) {
					if(publi.getTipo_articulo() == TipoArticulo.ELECTRONICOS) {
						lista_filtrada.add(publi);
					}
				}
				break;
				
		}
			
			return lista_filtrada;
	}
	
}
