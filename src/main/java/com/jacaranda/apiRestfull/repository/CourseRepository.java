package com.jacaranda.apiRestfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.apiRestfull.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

}
