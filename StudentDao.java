package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Student;

@Repository
public class StudentDao implements StudentDaoImpl {

	@Autowired
	SessionFactory sessionFactory;

	public Student getStudentDao(int id) {
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, id);

		return student;
	}

	public List<Student> getStudentsDao() {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		return students;
	}

	public String addStudentDao(Student student) {
		try {
			Session session = sessionFactory.openSession();

			session.save(student);
			session.beginTransaction().commit();
			return "Student added";
		} catch (Exception ex) {
			return "Error occured while adding Student : " + ex.getMessage();
		}
	}

	public String deleteStudentDao(int id) {
		try {

			Session session = sessionFactory.openSession();
			Student student = session.get(Student.class, id);

			if (student == null) {
				return "Student not found";
			}

			session.delete(student);
			session.beginTransaction().commit();
			return "Student deleted";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "Error occured while deleting Student : " + ex.getMessage();
		}
	}

	public String updateStudentDao(int id, Student student) {
		Session session = sessionFactory.openSession();
		Student student1 = session.get(Student.class, id);

		if (student1 == null) {
			return "Student not found";
		}
		
		student1.setId(student.getId());
		student1.setName(student.getName());
		student1.setAge(student.getAge());
		
		session.update(student1);
		session.beginTransaction().commit();
		return "Student updated";
	}
}
