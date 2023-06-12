package com.jacaranda.apiRestfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.apiRestfull.model.Course;
import com.jacaranda.apiRestfull.model.Topic;
import com.jacaranda.apiRestfull.service.CourseService;
import com.jacaranda.apiRestfull.service.TopicService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	TopicService topicService;
	
//	obtiene todos los cursos
	@GetMapping("cursos")
	public List<Course> getCourses(){
		List<Course> courses =  courseService.getCourses();
		return courses;
	}
	
//	obtiene solo un curso
	@GetMapping("curso/{corsename}")
	public Course getCourse(@PathVariable String corsename){
		return courseService.getCourse(corsename);
	}
	
//	obtine los temas de un curso
	@GetMapping("listaTemas/{corsename}")
	public List<Topic> getTopicsOfCourses(@PathVariable String corsename){
		Course course = courseService.getCourse(corsename);
		List<Topic> listTopics =  topicService.getTopicsCourse(course);
		return listTopics;
	}
	
//	agrega un curso
	@PostMapping("curso")
	public Course addCourse(@RequestBody Course course){
		return courseService.addCourse(course);
	}
	
//	actualiza un curso
	@PutMapping("curso/{corsename}")
	public ResponseEntity<Course> updateCourse(@PathVariable String corsename, @RequestBody Course course){
		if(courseService.getCourse(corsename) != null) {			
			Course courseUpdate = courseService.addCourse(course);
			return ResponseEntity.ok(courseUpdate);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	borra un curso
	@DeleteMapping("curso/{corsename}")
	public void deleteCourse(@PathVariable String corsename){
		Course course = courseService.getCourse(corsename);
		courseService.deleteCourse(course);
	}
	
	
}
