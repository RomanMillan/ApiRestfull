package com.jacaranda.apiRestfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.apiRestfull.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
