package com.generationc20.RentMySpeakerRestAPI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generationc20.RentMySpeakerRestAPI.model.Renta;

@Repository
public interface RentaRepository extends JpaRepository <Renta, Integer> {

	@Query("SELECT r FROM Renta r WHERE r.id_solicitud = :id_solicitud")
	List<Renta> findById_Solicitud(@Param ("id_solicitud") Integer id_solicitud);
}
