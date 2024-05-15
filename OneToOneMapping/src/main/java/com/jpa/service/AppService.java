package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Laptop;
import com.jpa.entity.Student;
import com.jpa.repository.LaptopRepository;
import com.jpa.repository.StudentRepository;

@Service
public class AppService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private LaptopRepository laptopRepository;

	public Student saveStudents(Student student) {

		return this.studentRepository.save(student);
	}

	public List<Student> getAllStudent() {
		return this.studentRepository.findAll();
	}

	public Student getStudent(Integer id) {
		return this.studentRepository.findById(id).orElseThrow();
	}

	public void deleteStudent(Integer id) {
		this.studentRepository.deleteById(id);
	}

	public Laptop getLaptop(Integer id) {
		return this.laptopRepository.findById(id).orElseThrow();
	}

	public Laptop addLaptop(Laptop laptop) {
		return this.laptopRepository.save(laptop);
	}

	public List<Laptop> getAllLaptop() {
		return this.laptopRepository.findAll();
	}

	public void deleteLaptop(Integer id) {
		this.laptopRepository.deleteById(id);
		
	}

}
