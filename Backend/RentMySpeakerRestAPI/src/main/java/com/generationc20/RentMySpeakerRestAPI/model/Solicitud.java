package com.generationc20.RentMySpeakerRestAPI.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "solicitud")
public class Solicitud {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer id_publicacion;
	
	private Integer id_usuario;
	
	private Integer num_dias;
	
	@Enumerated (EnumType.STRING)
	private EstadoSolicitud estado_solicitud;
	
	@Temporal (TemporalType.TIMESTAMP)
	private Date fecha;
	
	
	public Solicitud ()  {}

	public Integer getId () {
		return id;
	}
	
	public void setId (Integer id) {
		
		this.id = id;
	}
	
	public Integer getId_publicacion () {
		
		return id_publicacion;
	}

	public void setId_publicacion (Integer id_publicacion) {
		
		this.id_publicacion = id_publicacion;
	}
	
	public Integer getId_usuario () {
		
		return id_usuario;
	}

	public void setId_usuario (Integer id_usuario) {
		
		this.id_usuario = id_usuario;
	}

	public Integer getNum_dias () {
		
		return num_dias;
	}
	
	public void setNum_dias (Integer num_dias) {
		
		this.num_dias = num_dias;
	}
	
	public EstadoSolicitud getEstado_solicitud () {
		
		return estado_solicitud;
	}
	
	public void setEstado_solicitud (EstadoSolicitud estado_solicitud) {
		
		this.estado_solicitud = estado_solicitud;
	}
	
	public Date getFecha () {
		
		return fecha;
	}
	
	public void setFecha (Date fecha) {
		
		this.fecha = fecha;
	}
	
}
