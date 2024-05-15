package com.jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 * 
@JsonManagedReference and @JsonBackReference are annotations provided by the Jackson library,
 which is commonly used in Java to serialize and deserialize JSON data.
  These annotations are used to handle bi-directional relationships in JSON serialization to prevent infinite recursion.
  */

@Entity
@Table(name = "student_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String studentName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "laptop_fk")
	@JsonManagedReference
	private Laptop laptop;

}
