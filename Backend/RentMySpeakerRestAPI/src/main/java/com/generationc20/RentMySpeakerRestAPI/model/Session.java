package com.generationc20.RentMySpeakerRestAPI.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "Session")
public class Session {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer id_usuario;
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio_sesion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date final_sesion;
	
	public Session () {}
	
	public Session(Integer id, Integer id_usuario, Date inicio_sesion, Date final_sesion) {
		
		this.id = id;
		this.id_usuario = id_usuario;
		this.inicio_sesion = inicio_sesion;
		this.final_sesion = final_sesion;
	}

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
	
	public Date getInicio_sesion() {
		return inicio_sesion;
	}
	
	public void setInicio_sesion(Date inicio_sesion) {
		this.inicio_sesion = inicio_sesion;
	}
	
	public Date getFinal_sesion() {
		return final_sesion;
	}
	
	public void setFinal_sesion(Date final_sesion) {
		this.final_sesion = final_sesion;
	}
	
}
