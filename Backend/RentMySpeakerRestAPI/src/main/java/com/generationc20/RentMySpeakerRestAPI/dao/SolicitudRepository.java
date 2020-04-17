package com.generationc20.RentMySpeakerRestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generationc20.RentMySpeakerRestAPI.model.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository <Solicitud, Integer> {
	
}
