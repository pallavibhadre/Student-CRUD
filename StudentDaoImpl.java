package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Student;

public interface StudentDaoImpl {

	Student getStudentDao(int id);
	List<Student> getStudentsDao();
	String addStudentDao(Student student);
	String deleteStudentDao(int id);
	String updateStudentDao(int id, Student student);
}
