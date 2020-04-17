package com.generationc20.RentMySpeakerRestAPI.model;

import java.util.Date;

import javax.persistence.Id;

import javax.persistence.Table;

import javax.persistence.Entity;

import javax.persistence.Temporal;

import javax.persistence.EnumType;

import javax.persistence.Enumerated;

import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;


@Entity
@Table (name="renta")
public class Renta {
	
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated (EnumType.STRING)
	private EstadoRenta estado_renta;
	
	@Temporal (TemporalType.TIMESTAMP)
	private Date fecha;
	
	private Integer id_solicitud;
	
	private Integer id_usuario;
	
	
	public Renta () {}

	public void setId (Integer id) {
		
		this.id = id;
	}
	
	public void setEstado_renta (EstadoRenta estado_renta) {
		
		this.estado_renta = estado_renta;
	}
	
	public void setFecha (Date fecha) {
		
		this.fecha = fecha;
		
	}
		
	public void setId_solicitud (Integer id_solicitud) {
		
		this.id_solicitud = id_solicitud;
		
	}

	public void setId_usuario (Integer id_usuario) {
		
		this.id_usuario = id_usuario;
		
	}
	
	public Integer getId () {
		
			return this.id;
			
	}
	
	public EstadoRenta getEstado_renta () {
		
			return this.estado_renta;
			
	}
	
	public Integer getId_solicitud () {
		
			return this.id_solicitud;
	
	}
	
	public Date getFecha () {
		
		return this.fecha;
	
	}
	
	public Integer getId_usuario () {
		
		return this.id_usuario;
	}
	
}
