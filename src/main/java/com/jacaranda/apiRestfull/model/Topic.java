package com.jacaranda.apiRestfull.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="topicdb")
public class Topic {

	@Id
	private String topicname;
	private String content;
	private int pages;
	private double price;
	@ManyToOne
	@JoinColumn(name="key_course")
	private Course courseObj;
	@OneToMany(mappedBy="topicObj")
	private List<Study> study;
	
	
//	constructores
	public Topic() {
		super();
	}
	
	public Topic(String topicname, String content, int pages, double price, Course courseObj, List<Study> study) {
		super();
		this.topicname = topicname;
		this.content = content;
		this.pages = pages;
		this.price = price;
		this.courseObj = courseObj;
		this.study = study;
	}


//	getter and setter
	public String getTopicname() {
		return topicname;
	}
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Course getCourseObj() {
		return courseObj;
	}
	public void setCourseObj(Course courseObj) {
		this.courseObj = courseObj;
	}
	
	public List<Study> getStudy() {
		return study;
	}

	public void setStudy(List<Study> study) {
		this.study = study;
	}

	//	hascode and equals
	@Override
	public int hashCode() {
		return Objects.hash(topicname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		return Objects.equals(topicname, other.topicname);
	}
	
	
	
	
}
