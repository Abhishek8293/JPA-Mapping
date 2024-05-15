package com.jpa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.jpa.entity.Laptop;
import com.jpa.entity.Student;
import com.jpa.service.AppService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	private AppService appService;

	@PostMapping("/add/student")
	public Student saveStudent(@RequestBody Student student) {

		return this.appService.saveStudents(student);
	}

	@GetMapping("/getall/student")
	public List<Student> getAllStudent() {
		return this.appService.getAllStudent();
	}

	@GetMapping("/get/student/{id}")
	public Student getSudStudent(@PathVariable Integer id) {
		System.out.println(id);
		return this.appService.getStudent(id);
	}

	@DeleteMapping("/delete/student/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		this.appService.deleteStudent(id);
		return "Student Deleted";
	}

	@PostMapping("/add/laptop")
	public Laptop addLaptop(@RequestBody Laptop laptop) {
		return this.appService.addLaptop(laptop);
	}

	@GetMapping("/getall/laptop")
	public List<Laptop> getAllLaptop() {
		return this.appService.getAllLaptop();
	}

	@GetMapping("/get/laptop/{id}")
	public Laptop getLaptop(@PathVariable Integer id) {
		return this.appService.getLaptop(id);
	}
	
	@DeleteMapping("/delete/laptop/{id}")
	public String deleteLaptop(@PathVariable Integer id) {
		this.appService.deleteLaptop(id);
		return "Laptop Deleted";
	
		
	}

}
