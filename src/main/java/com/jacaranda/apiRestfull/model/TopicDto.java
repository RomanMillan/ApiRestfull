package com.jacaranda.apiRestfull.model;



public class TopicDto {
	private String topicname;
	private String content;
	private int pages;
	private double price;
	private String course;
	
//	constructores
	public TopicDto(String topicname, String content, int pages, double price, String course) {
		super();
		this.topicname = topicname;
		this.content = content;
		this.pages = pages;
		this.price = price;
		this.course = course;
	}
	public TopicDto() {
		super();
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	
	
	
}
