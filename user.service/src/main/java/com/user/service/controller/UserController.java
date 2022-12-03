// 3. UserService is linked through the creation of the userServ attribute which is an object type 'UserService'

package com.user.service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.service.entity.User;
import com.user.service.model.Car;
import com.user.service.model.Motorcycle;
import com.user.service.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	// get all the users
	@GetMapping
	public ResponseEntity<List<User>> usersList(){
		List<User> users = userServ.getAllUsers();
		
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(users);
		}
	}
	
	// get one user by id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		User user = userServ.getUserById(id);
		if(user==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(user);
		}
	}
	
	//* you must use the annotation '@PostMapping' because you're going to add some data so you have to use "POST". "GET" is only for getting data
	// save an user
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User userAdded = userServ.saveUser(user);
		return ResponseEntity.ok(userAdded);
	}

	// this method is used in the Service to connect the Beans of the microservice 'car'
	@GetMapping("cars/{userId}")
	public ResponseEntity<List<Car>> getCarsOfAnUser(@PathVariable("userId") int userId){
		User user = userServ.getUserById(userId);
		if(user==null) {
			return ResponseEntity.notFound().build();
		} else {
			List<Car> cars = userServ.getAllCarsOfAnUser(userId);
			return ResponseEntity.ok(cars);
		}
	}
	
	// this method is used in the Service to connect the Beans of the microservice 'motorcycle'
		@GetMapping("cars/{userId}")
		public ResponseEntity<List<Motorcycle>> getMotorcyclesOfAnUser(@PathVariable("userId") int userId){
			User user = userServ.getUserById(userId);
			if(user==null) {
				return ResponseEntity.notFound().build();
			} else {
				List<Motorcycle> motorcycle = userServ.getAllMotorcyclesOfAnUser(userId);
				return ResponseEntity.ok(motorcycle);
			}
		}
	
}
