package com.motorcycle.service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.motorcycle.service.entity.Motorcycle;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer>{

	List<Motorcycle> findMotorcyclesByUserId(int usuarioId);
	
}