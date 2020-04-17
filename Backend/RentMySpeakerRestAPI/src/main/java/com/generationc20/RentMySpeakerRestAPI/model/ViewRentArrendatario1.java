package com.generationc20.RentMySpeakerRestAPI.model;

import java.util.Date;

public class ViewRentArrendatario1 {
	
	private EstadoRenta estado_renta;
	private String titulo_publicacion;
	private String url_img_publicacion;
	private double precio_dia;
	private Date fecha_renta;
	private String telefono;
	private Integer id_solicitud;
	private Integer id_publicacion;
	
	
	
	public ViewRentArrendatario1(Renta renta, String telefono, Publicacion publicacion, Integer id_solicitud) {
		this.id_solicitud = id_solicitud;
		this.id_publicacion = publicacion.getId();
		this.estado_renta = renta.getEstado_renta();
		this.titulo_publicacion = publicacion.getTitulo_pub();
		this.url_img_publicacion = publicacion.getImagenes().get(0).getUrl_img();
		this.precio_dia = publicacion.getPrecio_dia();
		this.fecha_renta = renta.getFecha();
		this.telefono = telefono;
	}
	public EstadoRenta getEstado_renta() {
		return estado_renta;
	}
	public void setEstado_renta(EstadoRenta estado_renta) {
		this.estado_renta = estado_renta;
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
	public double getPrecio_dia() {
		return precio_dia;
	}
	public void setPrecio_dia(double precio_dia) {
		this.precio_dia = precio_dia;
	}
	public Date getFecha_renta() {
		return fecha_renta;
	}
	public void setFecha_renta(Date fecha_renta) {
		this.fecha_renta = fecha_renta;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
