package com.jacaranda.apiRestfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.apiRestfull.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, String> {

}
