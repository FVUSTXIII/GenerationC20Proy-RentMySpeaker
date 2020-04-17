package com.generationc20.RentMySpeakerRestAPI.dao;



import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generationc20.RentMySpeakerRestAPI.model.Session;



@Repository
public interface SessionRepository extends JpaRepository <Session, Integer> {

	//@Query("SELECT u.id FROM Usuario u WHERE u.correo = :correo AND u.contra = :contra")
	@Query("SELECT u.id FROM Usuario u WHERE u.correo = :correo")
	Integer getCredencialsUsuario (String correo);
	
	
}
