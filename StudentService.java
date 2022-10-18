package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDao;
import com.jbk.dao.StudentDaoImpl;
import com.jbk.entity.Student;

@Service
public class StudentService implements StudentServiceImpl{
	
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	public Student getStudentService(int id) {
		return studentDaoImpl.getStudentDao(id);
	}
	
	public List<Student> getStudentsService(){
		return studentDaoImpl.getStudentsDao();
	}
	
	public String addStudentService(Student student) {
		return studentDaoImpl.addStudentDao(student);
	}
	
	public String deleteStudentService(int id) {
		return studentDaoImpl.deleteStudentDao(id);
	}
	
	public String updateStudentService(int id, Student student) {
		return studentDaoImpl.updateStudentDao(id, student);
	}
}
