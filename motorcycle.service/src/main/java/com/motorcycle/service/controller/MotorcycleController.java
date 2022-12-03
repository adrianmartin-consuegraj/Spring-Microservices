package com.motorcycle.service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motorcycle.service.entity.Motorcycle;
import com.motorcycle.service.service.MotorcycleService;

@RestController
@RequestMapping("/motorcycle")
public class MotorcycleController {
	
	@Autowired
	private MotorcycleService motorcycleServ;	
	
	// get all the motorcycles
		@GetMapping
		public ResponseEntity<List<Motorcycle>> getAllMotorcycles(){
			List<Motorcycle> motorcycles = motorcycleServ.getAllMotorcycles();
			
			if(motorcycles.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(motorcycles);
			}
		}
		
		// get one motorcycle by id
		@GetMapping("/{id}")
		public ResponseEntity<Motorcycle> getMotorcycleById(@PathVariable("id") int id){
			Motorcycle motorcycle = motorcycleServ.getMotorcycleById(id);
			if(motorcycle==null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(motorcycle);
			}
		}
		
		// save a motorcycle
		@PostMapping
		public ResponseEntity<Motorcycle> saveCar(@RequestBody Motorcycle motorcycle){
			Motorcycle motorcycleAdded = motorcycleServ.saveMotorcycle(motorcycle);
			return ResponseEntity.ok(motorcycleAdded);
		}
		
		// get all the motorcycles a specific user owns
		@GetMapping("/user/{userId}")
		public ResponseEntity<List<Motorcycle>> getAllMotorcyclesbyUserId(@PathVariable("userId") int id){
			List<Motorcycle> motorcycles = motorcycleServ.getMotorcyclesByUserId(id);
			if(motorcycles.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(motorcycles);
			}
		}
		
}
