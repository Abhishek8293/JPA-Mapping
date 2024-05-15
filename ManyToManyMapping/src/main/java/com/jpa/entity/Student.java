package com.jpa.entity;

import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer studentId;
	private String studentName;
	
	@ManyToMany
	@JoinTable(name = "student_course_table",
	joinColumns = {@JoinColumn(name="student_id")},
	inverseJoinColumns = {@JoinColumn(name="course_id")})
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Course> courses;
	
	
	

}
