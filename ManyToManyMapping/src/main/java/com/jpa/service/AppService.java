package com.jpa.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Course;
import com.jpa.entity.Student;
import com.jpa.repository.CourseRepository;
import com.jpa.repository.StudentRepository;

@Service
public class AppService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	// API service logic for student entity

	public Student saveStudent(Student student) {
		return this.studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	public Student getStudentById(Integer id) {
		return this.studentRepository.findById(id).get();
	}

	public void deleteStudent(Integer id) {
		this.studentRepository.deleteById(id);
	}

	// API service logic for course entity

	public Course saveCourse(Course course) {
		return this.courseRepository.save(course);
	}

	public List<Course> getAllCourses() {
		return this.courseRepository.findAll();
	}

	public Course getCourseById(Integer id) {
		return this.courseRepository.findById(id).get();
	}

	public void deleteCourse(Integer id) {
		removeCourseFromStudent(id);
		this.courseRepository.deleteById(id);
	}

	// Assigning course to student
	public Student assignCourseToStudent(Integer studentId, Integer courseId) {

		// to get the existing student and course
		Student existingStudent = this.studentRepository.findById(studentId).get();
		Course newCourse = this.courseRepository.findById(courseId).get();

		// check if the student already has the course enrolled
		boolean alreadyEnrolled = existingStudent.getCourses().stream()
				.anyMatch(course -> course.getCourseId().equals(courseId));

		if (!alreadyEnrolled) {

			// retrive current set of enrolled course
			Set<Course> currentCourses = existingStudent.getCourses();
			// create new set of course and add current course
			Set<Course> updatedCourses = new HashSet<>(currentCourses);
			// add the new course to the updated course
			updatedCourses.add(newCourse);
			// set the updated course to existing student
			existingStudent.setCourses(updatedCourses);

		}

		return this.studentRepository.save(existingStudent);

	}

	// method to remove course from the student in association table
	public void removeCourseFromStudent(Integer courseId) {

		Set<Student> studentList = this.studentRepository.findStudentsByCourseId(courseId);
		for (Student student : studentList) {
			student.getCourses().removeIf(course -> course.getCourseId().equals(courseId));
			this.studentRepository.save(student);
		}

	}

}
