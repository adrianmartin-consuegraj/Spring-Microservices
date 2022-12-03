package com.car.service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.car.service.model.Car;
import com.car.service.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carServ;	
	
	// get all the cars
		@GetMapping
		public ResponseEntity<List<Car>> getAllCars(){
			List<Car> users = carServ.getAllCars();
			
			if(users.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(users);
			}
		}
		
		// get one car by id
		@GetMapping("/{id}")
		public ResponseEntity<Car> getCarById(@PathVariable("id") int id){
			Car car = carServ.getCarById(id);
			if(car==null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(car);
			}
		}
		
		// save a car
		@PostMapping
		public ResponseEntity<Car> saveCar(@RequestBody Car car){
			Car carAdded = carServ.saveCar(car);
			return ResponseEntity.ok(carAdded);
		}
		
		// get all the car a specific user owns
		@GetMapping("/user/{userId}")
		public ResponseEntity<List<Car>> getAllCarsbyUserId(@PathVariable("userId") int id){
			List<Car> cars = carServ.getCarsByUserId(id);
			if(cars.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(cars);
			}
		}
		
}
