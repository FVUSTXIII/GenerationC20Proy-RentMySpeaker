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
	
	private Integer id_solicitud;
	
	private Integer num_dias;
	@Enumerated(EnumType.STRING)
	private EstadoSolicitud estado_solicitud;
	/*
	 * 
	 * 1 - Solamente si el estado de la solicitud es "Pendiente" se mostrará la solicitud en el menú de las solicitudes 
	 * 2 - Si se acepta la solicitud esta genera una renta
	 * 
	 * */
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	public Solicitud ()  {}
	
	public boolean mostrar () {
		
		if(getEstado_solicitud() == estado_solicitud.PENDIENTE) {
			return true;
		}
			return false;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_solicitud() {
		return id_solicitud;
	}
	public void setId_solicitud(Integer id_solicitud) {
		this.id_solicitud = id_solicitud;
	}
	public Integer getNum_dias() {
		return num_dias;
	}
	public void setNum_dias(Integer num_dias) {
		this.num_dias = num_dias;
	}
	public EstadoSolicitud getEstado_solicitud() {
		return estado_solicitud;
	}
	public void setEstado_solicitud(EstadoSolicitud estado_solicitud) {
		this.estado_solicitud = estado_solicitud;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

}
