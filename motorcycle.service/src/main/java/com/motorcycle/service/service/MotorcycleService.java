package com.motorcycle.service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.motorcycle.service.model.Motorcycle;
import com.motorcycle.service.repository.MotorcycleRepository;

@Service
public class MotorcycleService {
	
	@Autowired
	private MotorcycleRepository motorcycleRepo;


	// get all cars
	public List<Motorcycle> getAllMotorcycles(){
		return motorcycleRepo.findAll();
	}

	// get one car by id
	public Motorcycle getMotorcycleById(int id) {
		return motorcycleRepo.findById(id).orElse(null);
	}

	// save a car
	public Motorcycle saveMotorcycle(Motorcycle motorcycle) {
		Motorcycle newMotorcycle = motorcycleRepo.save(motorcycle);
		return newMotorcycle;
	}
	
	public List<Motorcycle> getMotorcyclesByUserId(int userId){
		return motorcycleRepo.findMotorcyclesByUserId(userId);
	}

}
