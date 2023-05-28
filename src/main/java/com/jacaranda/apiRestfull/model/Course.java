package com.jacaranda.apiRestfull.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
	private String corsename;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy="courseObj")
	private List<Topic> topic;
	
//	Constructoress
	public Course() {
		super();
	}

	
public Course(String corsename, String description, List<Topic> topic) {
	super();
	this.corsename = corsename;
	this.description = description;
	this.topic = topic;
}


//	getter and setter
	public String getCorsename() {
		return corsename;
	}

	public void setCorsename(String corsename) {
		this.corsename = corsename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public List<Topic> getTopic() {
		return topic;
	}

	public void setTopic(List<Topic> topic) {
		this.topic = topic;
	}


	//	hasCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(corsename);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(corsename, other.corsename);
	}
	
	
	
	

}
