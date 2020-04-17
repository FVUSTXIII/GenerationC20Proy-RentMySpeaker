package com.generationc20.RentMySpeakerRestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generationc20.RentMySpeakerRestAPI.model.Publicacion;


@Repository
public interface PublicacionRepository  extends JpaRepository <Publicacion, Integer> {

}
