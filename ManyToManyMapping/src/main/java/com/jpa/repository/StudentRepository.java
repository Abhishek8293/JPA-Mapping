package com.jpa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	/*If the method parameter name matches the named parameter in the JPQL query, you don't need to use '@Param'.
     *If the method parameter name and the named parameter in the JPQL query are different, use '@Param' to explicitly map them to avoid errors.
     **and they don't need to match the id field name of the entity.
	 * */

	@Query("SELECT s FROM Student s JOIN s.courses c WHERE c.id = :cId")
	Set<Student> findStudentsByCourseId(@Param("cId") Integer mycourseId);
}


