package com.jacaranda.apiRestfull.controller;

import java.util.ArrayList;
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
import com.jacaranda.apiRestfull.model.TopicDto;
import com.jacaranda.apiRestfull.service.CourseService;
import com.jacaranda.apiRestfull.service.TopicService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@Autowired
	CourseService courseService;
	
	
//	obtiene todos los temas
	@GetMapping("temas")
	public List<TopicDto> getTopics(){
		List<Topic> topicList = topicService.getTopics();
		List<TopicDto> topicListDto = getTopicsDto(topicList);
		return topicListDto;
	}
//	metodo para usar la clase DTO (Mostrar todos los temas)
	private List<TopicDto> getTopicsDto(List<Topic> topicList){
		List<TopicDto> topicListDto = new ArrayList<TopicDto>();
		
		for(Topic topic : topicList) {
			
			TopicDto tDto = new TopicDto();
			
			tDto.setTopicname(topic.getTopicname());
			tDto.setContent(topic.getContent());
			tDto.setPages(topic.getPages());
			tDto.setPrice(topic.getPrice());
			tDto.setCourse(topic.getCourseObj().getCorsename());
			
			topicListDto.add(tDto);
		}
		
		return topicListDto;
	}
	
	
//	obtiene solo un tema
	@GetMapping("tema/{topicname}")
	public TopicDto getTopic(@PathVariable String topicname){
		Topic topic = topicService.getTopic(topicname);
		TopicDto topicDto = getTopicDto(topic);
		return topicDto;
	}
	
	private TopicDto getTopicDto(Topic topic) {
		TopicDto tDto = new TopicDto();
		
		tDto.setTopicname(topic.getTopicname());
		tDto.setContent(topic.getContent());
		tDto.setPages(topic.getPages());
		tDto.setPrice(topic.getPrice());
		tDto.setCourse(topic.getCourseObj().getCorsename());
		
		return tDto;
	}
	
	
//	agrega un tema
	@PostMapping("tema")
	public Topic addTopics(@RequestBody TopicDto topicDto ){
		Topic topic = setTopic(topicDto);
		return topicService.addTopic(topic);
	}
	
//	Obtine un tema con curso string y devuelve de un tema con objeto curso
	private Topic setTopic(TopicDto topicDto){	
		Course course =  courseService.getCourse(topicDto.getCourse());
		
		Topic topic = new Topic();
		
		topic.setTopicname(topicDto.getTopicname());
		topic.setContent(topicDto.getContent());
		topic.setPages(topicDto.getPages());
		topic.setPrice(topicDto.getPrice());
		topic.setCourseObj(course);
		
		return topic;
	}
	
	
	
//	actualiza un tema
	@PutMapping("tema/{topicname}")
	public ResponseEntity<Topic> updateTopics(@PathVariable String topicname, @RequestBody TopicDto topicDto){
		if(topicService.getTopic(topicname) != null) {			
			Topic topic = setTopic(topicDto);
			Topic topicUpdate = topicService.addTopic(topic);
			return ResponseEntity.ok(topicUpdate);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
//	borra un tema
	@DeleteMapping("tema/{topicname}")
	public void deleteTopics(@PathVariable String topicname){
		Topic topicDelete = topicService.getTopic(topicname);
		 topicService.deleteTopic(topicDelete);
	}
	
	
}
