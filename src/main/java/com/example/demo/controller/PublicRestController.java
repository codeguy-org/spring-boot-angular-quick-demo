package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Course;


@RestController
public class PublicRestController {
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public List<Course> data(HttpSession session) {
		if(session.getAttribute("courses") != null)
			return (ArrayList<Course>)session.getAttribute("courses");
		else
			return new ArrayList<Course>();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/add")
	public Map<String, Object> add(HttpSession session, @RequestParam(name="courseId", required=true) Integer courseId, 
			                       @RequestParam(name="subject", required=true) String subject,
                                   @RequestParam(name="courseNumber", required=true) String courseNumber) {
			Map<String, Object> returnValues = new HashMap<String, Object>();
			
			List<Course> courses;
			if(session.getAttribute("courses") != null)
				courses = (ArrayList<Course>)session.getAttribute("courses");
			else
				courses = new ArrayList<Course>();
			
			courses.add(new Course(courseId, subject, courseNumber));
			session.setAttribute("courses", courses);
			
			returnValues.put("courses", courses);
			
			return returnValues;
	}
}