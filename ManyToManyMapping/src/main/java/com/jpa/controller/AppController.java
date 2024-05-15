package com.jpa.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Course;
import com.jpa.entity.Student;
import com.jpa.service.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService appService;

	// API for student entity

	@PostMapping("/add/student")
	public Student saveStudent(@RequestBody Student student) {
		return this.appService.saveStudent(student);
	}

	@GetMapping("/getall/student")
	public List<Student> getAllStudents() {
		return this.appService.getAllStudents();

	}

	@GetMapping("/get/student/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return this.appService.getStudentById(id);

	}

	@DeleteMapping("/delete/student/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		this.appService.deleteStudent(id);
		return "Deleted student";
	}

	@PutMapping("/assign/course/{studentId}/{courseId}")
	public Student assignCourseToStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) {
		return this.appService.assignCourseToStudent(studentId, courseId);
	}

	// API for course entity

	@PostMapping("/add/course")
	public Course saveCourse(@RequestBody Course course) {
		return this.appService.saveCourse(course);

	}

	@GetMapping("/getall/course")
	public List<Course> getAllCourses() {
		return this.appService.getAllCourses();

	}

	@GetMapping("/get/course/{id}")
	public Course getCourseById(@PathVariable Integer id) {
		return appService.getCourseById(id);

	}

	@DeleteMapping("/delete/course/{id}")
	public String deleteCourse(@PathVariable Integer id) {
		appService.deleteCourse(id);
		return "Deleted Course";
	}
	
	/*
	@GetMapping("/check/{courseId}")
	public Set<Student> checkMethod(@PathVariable Integer courseId){
		return this.appService.removeCourseFromStudent(courseId);
	}
	*/
}
