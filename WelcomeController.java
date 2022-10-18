package com.jbk.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.entity.Student;
import com.jbk.model.User;

@Controller
public class WelcomeController {

	@RequestMapping("/testjsp")
	public String welcome() {
		System.out.println("inside testjsp");
		return "index.html";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute User user) {			
		ModelAndView modelAndView = new ModelAndView();
		
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			modelAndView.setViewName("students");
			
			ArrayList<Student> list = new ArrayList<Student>();
			list.add(new Student(1, "jbk", 23));
			list.add(new Student(2, "jbkiran", 33));
			list.add(new Student(3, "javabykiran", 37));
			
			modelAndView.addObject("stulist", list);		
			
		}else {
			modelAndView.setViewName("login");
			
			modelAndView.addObject("msg", "Login unsuccessful");
		}		
		
		return modelAndView;
	}

	@RequestMapping("/allstudents")
	public ModelAndView fecthStudents() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("students");
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "jbk", 23));
		list.add(new Student(2, "jbkiran", 33));
		list.add(new Student(3, "javabykiran", 37));
		
		modelAndView.addObject("stulist", list);
		return modelAndView;
	}
}
