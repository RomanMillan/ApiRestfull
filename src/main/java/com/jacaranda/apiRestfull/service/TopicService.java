package com.jacaranda.apiRestfull.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.apiRestfull.model.Course;
import com.jacaranda.apiRestfull.model.Topic;
import com.jacaranda.apiRestfull.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRespository;
	
//	obtiene todo los temas
	public List<Topic> getTopics(){
		return topicRespository.findAll();
	}
	
//	obtiene un tema
	public Topic getTopic(String topicname) {
		return topicRespository.findById(topicname).orElse(null);
	}
	
//	obtener todos los temas de un curso
	public List<Topic> getTopicsCourse(Course coursename){
		return topicRespository.findByCourseObj(coursename);
	}
	
//	añadir un tema
	public Topic addTopic(Topic topic) {
		return topicRespository.save(topic);
	}
	
//	borrar un tema
	public void deleteTopic(Topic topic) {
		 topicRespository.delete(topic);
	}
}
