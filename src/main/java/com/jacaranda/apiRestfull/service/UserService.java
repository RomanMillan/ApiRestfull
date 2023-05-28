package com.jacaranda.apiRestfull.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.apiRestfull.model.User;
import com.jacaranda.apiRestfull.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
//	obtiene todos los usuarios
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
//	obtiene un usuario
	public User getUser(String username) {
		return userRepository.findById(username).orElse(null);
	}
	
//	añadir un usuario
	public User addUser(User username) {
		return userRepository.save(username);
	}
	
//	borrar un usuario
	public void deleteUser(User username) {
		userRepository.delete(username);
	}
	

}
