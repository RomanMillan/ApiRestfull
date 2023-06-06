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
import com.jacaranda.apiRestfull.model.Topic;
import com.jacaranda.apiRestfull.service.CourseService;
import com.jacaranda.apiRestfull.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@Autowired
	CourseService courseService;
	
	
//	obtiene todos los temas
	@GetMapping("temas")
	public List<Topic> getTopics(){
		return topicService.getTopics();
	}
	
//	obtiene solo un tema
	@GetMapping("tema/{topicname}")
	public Topic getTopic(@PathVariable String topicname){
		return topicService.getTopic(topicname);
	}
	
//	agrega un tema
	@PostMapping("tema")
	public Topic addTopics(@RequestBody Topic topic ){
		return topicService.addTopic(topic);
	}
	
//	actualiza un tema
	@PutMapping("tema/{topicname}")
	public ResponseEntity<Topic> updateTopics(@PathVariable String topicname, @RequestBody Topic topic){
		if(topicService.getTopic(topicname) != null) {			
			Topic topicUpdate = topicService.addTopic(topic);
			return ResponseEntity.ok(topicUpdate);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	borra un tema
	@DeleteMapping("tema")
	public void deleteTopics(@RequestBody Topic topic){
		 topicService.deleteTopic(topic);
	}
	
	
}
