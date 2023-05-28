package com.jacaranda.apiRestfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.jacaranda.apiRestfull.model.User;
import com.jacaranda.apiRestfull.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
//	obtiene todos los usuarios
	@GetMapping("usuarios")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
//	obtiene solo un usuario
	@GetMapping("usuario/{username}")
	public User getUser(@PathVariable String username){
		return userService.getUser(username);
	}
	
//	agrega un usuario
	@PostMapping("usuario/add")
	public User addUser(@RequestBody User user){
		return userService.addUser(user);
	}
	
//	actualiza un usuario
	@PutMapping("usuario/update/{username}")
	public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user){
		if(userService.getUser(username) != null) {			
			User userUpdate = userService.addUser(user);
			return ResponseEntity.ok(userUpdate);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	borra un usuario
	@DeleteMapping("usuario/delete")
	public void deleteUser(@RequestBody User user){
		userService.deleteUser(user);
	}
	
	
}