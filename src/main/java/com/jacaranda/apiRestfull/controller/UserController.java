package com.jacaranda.apiRestfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jacaranda.apiRestfull.model.ApiError;
import com.jacaranda.apiRestfull.model.User;
import com.jacaranda.apiRestfull.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	public ResponseEntity<?> getUser(@PathVariable String username){
		if(userService.getUser(username) != null) {			
			User user = userService.getUser(username);
			return ResponseEntity.ok(user);
		}else {
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,"No encontrado el usuario");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
		}
	}
	
//	agrega un usuario
	@PostMapping("usuario")
	public ResponseEntity<?> addUser(@RequestBody User user){
		if(userService.getUser(user.getUsername()) == null) {
			userService.addUser(user);
			return ResponseEntity.ok(user);
		}else {
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,"El usuario ya existe");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
		}
		
	}
	
//	actualiza un usuario
	@PutMapping("usuario/{username}")
	public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User user){
		if(userService.getUser(username) != null) {			
			User userUpdate = userService.addUser(user);
			return ResponseEntity.ok(userUpdate);
		}else {
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,"no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
		}
	}
	
	

//	borra un usuario
	@DeleteMapping("usuario/{username}")
	public void deleteUser(@PathVariable String username){
		User user = userService.getUser(username);
		userService.deleteUser(user);
	}
	
	
}
