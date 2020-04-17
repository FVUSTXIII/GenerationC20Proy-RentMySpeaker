package com.generationc20.RentMySpeakerRestAPI.model;

import java.util.Date;

public class ViewRentArrendador {
	
	private EstadoRenta estado_renta;
	
	private Integer id_solicitud;
	
	private String url_img_solicitante;
	
	private String nombre_solicitante;
	
	private Integer numero_dias_solicitud;
	
	private double precio_total;
	
	private Date fecha_renta;
	
	private String titulo_publicacion;
	
	private String url_img_publicacion;
	
	private double precio_dia_publicacion;
	
	
	public ViewRentArrendador(Renta renta, Solicitud solicitud, Publicacion publicacion, ImagenPublicacion img_publicacion, Usuario solicitante) {
	
		this.estado_renta = renta.getEstado_renta();
		this.id_solicitud = solicitud.getId();	
		this.url_img_solicitante = solicitante.getUrl_img();
		this.nombre_solicitante = solicitante.getNombre() + " " + solicitante.getApellidos();
		this.numero_dias_solicitud = solicitud.getNum_dias();
		this.precio_total = publicacion.getPrecio_dia() * solicitud.getNum_dias();
		this.fecha_renta = renta.getFecha();
		this.titulo_publicacion = publicacion.getTitulo_pub();
		this.url_img_publicacion = publicacion.getImagenes().get(0).getUrl_img();
		this.precio_dia_publicacion = publicacion.getPrecio_dia();
		
	}
	public EstadoRenta getEstado_renta() {
		return estado_renta;
	}
	public void setEstado_renta(EstadoRenta estado_renta) {
		this.estado_renta = estado_renta;
	}
	public String getUrl_img_solicitante() {
		return url_img_solicitante;
	}
	public void setUrl_img_solicitante(String url_img_solicitante) {
		this.url_img_solicitante = url_img_solicitante;
	}
	public Integer getNumero_dias_solicitud() {
		return numero_dias_solicitud;
	}
	public void setNumero_dias_solicitud(Integer numero_dias_solicitud) {
		this.numero_dias_solicitud = numero_dias_solicitud;
	}
	public double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
	public Date getFecha_renta() {
		return fecha_renta;
	}
	public void setFecha_renta(Date fecha_renta) {
		this.fecha_renta = fecha_renta;
	}
	public String getTitulo_publicacion() {
		return titulo_publicacion;
	}
	public void setTitulo_publicacion(String titulo_publicacion) {
		this.titulo_publicacion = titulo_publicacion;
	}
	public String getUrl_img_publicacion() {
		return url_img_publicacion;
	}
	public void setUrl_img_publicacion(String url_img_publicacion) {
		this.url_img_publicacion = url_img_publicacion;
	}
	public double getPrecio_dia_publicacion() {
		return precio_dia_publicacion;
	}
	public void setPrecio_dia_publicacion(double precio_dia_publicacion) {
		this.precio_dia_publicacion = precio_dia_publicacion;
	}
	public String getNombre_solicitante() {
		return nombre_solicitante;
	}
	public void setNombre_solicitante(String nombre_solicitante) {
		this.nombre_solicitante = nombre_solicitante;
	}
	
}
