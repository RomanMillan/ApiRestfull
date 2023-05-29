package com.jacaranda.apiRestfull.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studydb")
public class Study {

	@Id
	@ManyToOne
	@JoinColumn(name="key_user")
	private User userObj;
	@Id
	@ManyToOne
	@JoinColumn(name="key_topic")
	private Topic topicObj;
	@Id
	private String date_begin;
	private String date_end;
	private int score;
	
//	constructores

	

	public Study() {
		super();
	}

	
	public Study(User userObj, Topic topicObj, String date_begin, String date_end, int score) {
		super();
		this.userObj = userObj;
		this.topicObj = topicObj;
		this.date_begin = date_begin;
		this.date_end = date_end;
		this.score = score;
	}


	public User getUserObj() {
		return userObj;
	}
	
	
	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}
	
	
	public Topic getTopicObj() {
		return topicObj;
	}
	
	
	public void setTopicObj(Topic topicObj) {
		this.topicObj = topicObj;
	}
	
	
	public String getDate_begin() {
		return date_begin;
	}
	
	
	public void setDate_begin(String date_begin) {
		this.date_begin = date_begin;
	}
	
	
	public String getDate_end() {
		return date_end;
	}
	
	
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
	
	
	public int getScore() {
		return score;
	}
	
	
	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public int hashCode() {
		return Objects.hash(date_begin, topicObj, userObj);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Study other = (Study) obj;
		return Objects.equals(date_begin, other.date_begin) && Objects.equals(topicObj, other.topicObj)
				&& Objects.equals(userObj, other.userObj);
	}
	
	
		
	
	
	
	
}
