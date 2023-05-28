package com.jacaranda.apiRestfull.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.apiRestfull.model.Course;
import com.jacaranda.apiRestfull.model.Topic;
import com.jacaranda.apiRestfull.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
//	obtiene todos los cursos
	public List<Course> getCourses(){
		return courseRepository.findAll();
	}
	
//	obtiene un curso
	public Course getCourse(String corsename) {
		return courseRepository.findById(corsename).orElse(null);
	}
	
//	añadir un curso
	public Course addCourse(Course corsename) {
		return courseRepository.save(corsename);
	}
	
//	borrar un curso
	public void deleteCourse(Course corsename) {
		courseRepository.delete(corsename);
	}
	
}
