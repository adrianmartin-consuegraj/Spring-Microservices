// 2. UserRepository is linked through the creation of the userRepo attribute which is an object type 'UserRepository'

package com.user.service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entity.User;
import com.user.service.model.Car;
import com.user.service.model.Motorcycle;
import com.user.service.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//* injecting the RestTemplate Object to recover the Class Car from the 'car.microservice' through the endpoint of that microservice
	// get all the Cars of an specific User
	public List<Car> getAllCarsOfAnUser(int userId){
		List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/user/" + userId, List.class);
		return cars;
	}
	
	//* injecting the RestTemplate Object to recover the Motorcycle Car from the 'motorcycle.microservice' through the endpoint of that microservice
	// get all the Motorcycles of an specific User
		public List<Motorcycle> getAllMotorcyclesOfAnUser(int userId){
			List<Motorcycle> motorcycles = restTemplate.getForObject("http://localhost:8003/motorcycle/user/" + userId, List.class);
			return motorcycles;
		}
	
	// get all users
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	// get one user by id
	// with the method 'orElse(null)' we can control that exception providing a null in case there's no User found
	public User getUserById(int id) {
		return userRepo.findById(id).orElse(null);
	}

	// save an user
	public User saveUser(User user) {
		User newUser = userRepo.save(user);
		return newUser;
	}
	
}
