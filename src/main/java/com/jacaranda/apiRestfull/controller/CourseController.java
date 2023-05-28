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

import com.jacaranda.apiRestfull.model.Course;
import com.jacaranda.apiRestfull.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
//	obtiene todos los cursos
	@GetMapping("cursos")
	public List<Course> getCourses(){
		return courseService.getCourses();
	}
	
//	obtiene solo un curso
	@GetMapping("curso/{corsename}")
	public Course getCourse(@PathVariable String corsename){
		return courseService.getCourse(corsename);
	}
	
//	agrega un curso
	@PostMapping("curso/add")
	public Course addCourse(@RequestBody Course course){
		return courseService.addCourse(course);
	}
	
//	actualiza un curso
	@PutMapping("curso/update/{corsename}")
	public ResponseEntity<Course> updateCourse(@PathVariable String corsename, @RequestBody Course course){
		if(courseService.getCourse(corsename) != null) {			
			Course courseUpdate = courseService.addCourse(course);
			return ResponseEntity.ok(courseUpdate);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	borra un curso
	@DeleteMapping("curso/delete")
	public void deleteCourse(@RequestBody Course course){
		courseService.deleteCourse(course);
	}
	
	
}
