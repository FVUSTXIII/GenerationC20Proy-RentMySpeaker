package com.generationc20.RentMySpeakerRestAPI.model;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;

import javax.persistence.Entity;

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
@Table (name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (length = 45)
	private String nombre;
	
	@Column (length = 60)
	private String apellidos;
	
	@Column (length = 125)
	private String correo;
	
	@Column (length = 100)
	private String contra;
	
	@Column (length = 30)
	private String url_img;
	
	@Column (length = 16)
	private String numero_telefonico;
	
	@Temporal (TemporalType.TIMESTAMP)
	private Date fecha;
	
	@OneToMany (targetEntity = Publicacion.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn (name = "id_usuario", referencedColumnName = "id")
	private List <Publicacion> publicaciones;
	
	@OneToMany (targetEntity = Solicitud.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn (name = "id_usuario", referencedColumnName = "id")
	private List <Solicitud> solicitudes;
	
	@OneToMany (targetEntity = Renta.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn (name = "id_usuario", referencedColumnName = "id")
	private List <Renta> rentas;
	
	
	public Usuario () {}
	
	public Usuario (Integer id, String nombre, String apellidos, String correo, String contra, String url_img,
			Date fecha) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contra = contra;
		this.url_img = url_img;
		this.fecha = fecha;
		
	}
	
	public String getNumero_telefonico () {
		
			return numero_telefonico;
			
	}

	public void setNumero_telefonico (String numero_telefonico) {
		
		this.numero_telefonico = numero_telefonico;
			
	}
	
	public Integer getId () {
		
			return id;
			
	}
	
	public void setId (Integer id) {
		
		this.id = id;
		
	}
	
	public String getNombre () {
		
			return nombre;
		
	}
	
	public void setNombre (String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public String getApellidos () {
		
			return apellidos;
		
	}
	
	public void setApellidos (String apellidos) {
		
		this.apellidos = apellidos;
		
	}
	
	public String getCorreo () {
		
			return correo;
		
	}
	
	public void setCorreo (String correo) {
		
		this.correo = correo;
		
	}
	
	public String getContra () {
		
			return contra;
	}
	
	public void setContra (String contra) {
		
		this.contra = contra;
		
	}
	
	public String getUrl_img () {
		
			return url_img;
			
	}
	
	public void setUrl_img (String url_img) {
		
		this.url_img = url_img;
		
	}
	
	public Date getFecha () {
		
			return fecha;
			
	}
	
	public void setFecha (Date fecha) {
		
		this.fecha = fecha;
	}
	

	public List <Publicacion> getPublicaciones () {
		
			return publicaciones;
			
	}
	
	public void setPublicaciones (List <Publicacion> publicaciones) {
		
		this.publicaciones = publicaciones;
		
	}

	public List <Solicitud> getSolicitudes () {
		
			return solicitudes;
			
	}
	
	public void setSolicitudes (List <Solicitud> solicitudes) {
		
		this.solicitudes = solicitudes;
		
	}

	public List <Renta> getRentas () {
		 
			return rentas;
		
	}

	public void setRentas (List <Renta> rentas) {
		
		this.rentas = rentas;
	}
	
}
