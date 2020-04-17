package com.generationc20.RentMySpeakerRestAPI.model;

import java.util.Date;

public class ViewSolicitudRecibida {
	
	private EstadoSolicitud estado_solicitud;
	private String url_imagen_publicacion;
	private double precio_dia;
	private String url_imagen_usuario;
	private String nombre_usuario;
	private Integer dias_solicitud;
	private double precio_total;
	private Date fecha_solicitud;
	private Integer id_solicitud;
	private Integer id_publicacion;
	private String titulo_publicacion;
	
	public ViewSolicitudRecibida(Solicitud solicitud, Publicacion publicacion, Usuario usuario, ImagenPublicacion imagen_publicacion) {
		this.id_solicitud = solicitud.getId();
		this.id_publicacion = publicacion.getId();
		this.titulo_publicacion = publicacion.getTitulo_pub();
		this.estado_solicitud = solicitud.getEstado_solicitud();
		this.url_imagen_publicacion = imagen_publicacion.getUrl_img();
		this.precio_dia = publicacion.getPrecio_dia();
		this.url_imagen_usuario = usuario.getUrl_img();
		this.nombre_usuario = usuario.getNombre() + " " + usuario.getApellidos();
		this.dias_solicitud = solicitud.getNum_dias();
		this.precio_total = publicacion.getPrecio_dia() * solicitud.getNum_dias();
		this.fecha_solicitud = solicitud.getFecha();
	}
	public EstadoSolicitud getEstado_solicitud() {
		return estado_solicitud;
	}
	public void setEstado_solicitud(EstadoSolicitud estado_solicitud) {
		this.estado_solicitud = estado_solicitud;
	}
	public String getUrl_imagen_publicacion() {
		return url_imagen_publicacion;
	}
	public void setUrl_imagen_publicacion(String url_imagen_publicacion) {
		this.url_imagen_publicacion = url_imagen_publicacion;
	}
	public double getPrecio_dia() {
		return precio_dia;
	}
	public void setPrecio_dia(double precio_dia) {
		this.precio_dia = precio_dia;
	}
	public String getUrl_imagen_usuario() {
		return url_imagen_usuario;
	}
	public void setUrl_imagen_usuario(String url_imagen_usuario) {
		this.url_imagen_usuario = url_imagen_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public Integer getDias_solicitud() {
		return dias_solicitud;
	}
	public void setDias_solicitud(Integer dias_solicitud) {
		this.dias_solicitud = dias_solicitud;
	}
	public double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}
	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}
	
}
