package com.jbk.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Student;
import com.jbk.service.StudentService;
import com.jbk.service.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentServiceImpl;	
	
	@GetMapping("/getStudent/{id}")
	Student getStudent(@PathVariable int id) {
		return studentServiceImpl.getStudentService(id);
	}

	@GetMapping("/getStudents")
	List<Student> getStudents() {
		
		return studentServiceImpl.getStudentsService();
	}

	@PostMapping("/addStudent")
	String addStudent(@RequestBody Student student) {
		return studentServiceImpl.addStudentService(student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	String deleteStudent(@PathVariable int id) {
		return studentServiceImpl.deleteStudentService(id);
	}
	
	@PutMapping("/updateStudent/{id}")
	String updateStudent(@PathVariable int id, @RequestBody Student student) {
		return studentServiceImpl.updateStudentService(id, student);
	}
}
