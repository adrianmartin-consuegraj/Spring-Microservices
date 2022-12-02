package com.car.service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.car.service.model.Car;
import com.car.service.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepo;


	// get all cars
	public List<Car> getAllCars(){
		return carRepo.findAll();
	}

	// get one car by id
	public Car getCarById(int id) {
		return carRepo.findById(id).orElse(null);
	}

	// save a car
	public Car saveCar(Car car) {
		Car newCar = carRepo.save(car);
		return newCar;
	}
	
	public List<Car> getCarsByUserId(int userId){
		return carRepo.findCarsByUserId(userId);
	}

}
