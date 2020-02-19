package com.orbiter.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.orbiter.soap.webservices.soapcoursemanagement.soap.Course;

@Component
public class CourseDetailsService {

	private static List<Course> courses = new ArrayList<>();

	static {
		Course c1 = new Course(1, "Spring", "Java 5");
		Course c2 = new Course(2, "Hibernate ", "Java 6");
		Course c3 = new Course(3, "Boot", "Java 7");
		Course c4 = new Course(4, "Maven", "Java 8");

		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);

	}

	public Course findById(int id) {
		for (Course course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		return null;
	}

	public List<Course> findAll() {
		return courses;
	}

	public int deleteById(int i) {
		Iterator<Course> itr = courses.iterator();
		while (itr.hasNext()) {
			Course course = itr.next();
			if (course.getId() == i) {
				itr.remove();
				return 1;
			}
		}

		return 0;

	}

}
