package com.example.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="course")
	private List<Review> reviews=new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students=new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	
	public Course(Long id, String name, LocalDateTime lastUpdatedTime, LocalDateTime createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.lastUpdatedDate = lastUpdatedTime;
		this.createdDate = createdDate;
	}

	public Course() {
	}

	public Course(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	


	public Course(String name) {
		super();
		this.name = name;
	}

	public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedDate = lastUpdatedTime;
	}
	
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review reviews) {
		this.reviews.add(reviews);
	}
	
	public void removeReviews(Review reviews) {
		this.reviews.remove(reviews);
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
