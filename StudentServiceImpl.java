package com.jbk.service;

import java.util.List;

import com.jbk.entity.Student;

public interface StudentServiceImpl {
	Student getStudentService(int id);

	List<Student> getStudentsService();

	String addStudentService(Student student);

	String deleteStudentService(int id);
	
	String updateStudentService(int id, Student student);
}
