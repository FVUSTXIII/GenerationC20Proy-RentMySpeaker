package com.generationc20.RentMySpeakerRestAPI.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table (name = "publicacion")
public class Publicacion {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer id_usuario;
	private boolean disponible;
	@Column (length = 150)
	private String titulo_pub;
	@Enumerated(EnumType.STRING)
	private TipoArticulo tipo_articulo;
	@Column (length = 1800)
	private String descripcion;
	private double precio_dia;
	@OneToMany (targetEntity = ImagenPublicacion.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn (name = "id_publicacion", referencedColumnName = "id")
	private List<ImagenPublicacion> imagenes = new ArrayList();
	@OneToMany (targetEntity = Solicitud.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn (name = "id_publicacion", referencedColumnName = "id")
	private List<Solicitud> solicitudes_recibidas;
	public List<Solicitud> getSolicitudes_recibidas() {
		return solicitudes_recibidas;
	}
	public void setSolicitudes_recibidas(List<Solicitud> solicitudes_recibidas) {
		this.solicitudes_recibidas = solicitudes_recibidas;
	}
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	public Publicacion () {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getTitulo_pub() {
		return titulo_pub;
	}
	public void setTitulo_pub(String titulo_pub) {
		this.titulo_pub = titulo_pub;
	}
	public TipoArticulo getTipo_articulo() {
		return tipo_articulo;
	}
	public void setTipo_articulo(TipoArticulo tipo_articulo) {
		this.tipo_articulo = tipo_articulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio_dia() {
		return precio_dia;
	}
	public void setPrecio_dia(double precio_dia) {
		this.precio_dia = precio_dia;
	}
	public void addImagen (ImagenPublicacion img) {
		this.imagenes.add(img);
	}
	public List<ImagenPublicacion> getImagenes() {
		return imagenes;
	}
	public void setImagenes(List<ImagenPublicacion> imagenes) {
		this.imagenes = imagenes;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
		
}
