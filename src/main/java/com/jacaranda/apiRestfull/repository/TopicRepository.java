package com.jacaranda.apiRestfull.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.apiRestfull.model.Course;
import com.jacaranda.apiRestfull.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, String> {
	public List<Topic> findByCourseObj(Course courseObj);

}
