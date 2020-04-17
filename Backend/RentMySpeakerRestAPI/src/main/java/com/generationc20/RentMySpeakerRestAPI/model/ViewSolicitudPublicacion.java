package com.generationc20.RentMySpeakerRestAPI.model;

import java.util.Date;


public class ViewSolicitudPublicacion {
	
	private EstadoSolicitud estadoSolicitud;
	private Date fecha_solicitud;
	private String titulo_publicacion;
	private TipoArticulo tipo_articulo_p;
	private double precio_dia;
	private String url_img;
	private Integer id_solicitud;
	private Integer id_publicacion;
	
	public ViewSolicitudPublicacion (Solicitud solicitud, Publicacion publicacion, ImagenPublicacion imagen_publicacion) {
		this.id_solicitud = solicitud.getId();
		this.id_publicacion = publicacion.getId();
		this.estadoSolicitud = solicitud.getEstado_solicitud();
		this.fecha_solicitud = solicitud.getFecha();
		this.titulo_publicacion = publicacion.getTitulo_pub();
		this.tipo_articulo_p = publicacion.getTipo_articulo();
		this.precio_dia = publicacion.getPrecio_dia();
		this.url_img = imagen_publicacion.getUrl_img();
		
	}
	public String getUrl_img() {
		return url_img;
	}
	public void setUrl_img(String url_img) {
		this.url_img = url_img;
	}
	public EstadoSolicitud getEstadoSolicitud() {
		return estadoSolicitud;
	}
	public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}
	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}
	public String getTitulo_publicacion() {
		return titulo_publicacion;
	}
	public void setTitulo_publicacion(String titulo_publicacion) {
		this.titulo_publicacion = titulo_publicacion;
	}
	public TipoArticulo getTipo_articulo_p() {
		return tipo_articulo_p;
	}
	public void setTipo_articulo_p(TipoArticulo tipo_articulo_p) {
		this.tipo_articulo_p = tipo_articulo_p;
	}
	public double getPrecio_dia() {
		return precio_dia;
	}
	public void setPrecio_dia(double precio_dia) {
		this.precio_dia = precio_dia;
	}
	
	
	
}
