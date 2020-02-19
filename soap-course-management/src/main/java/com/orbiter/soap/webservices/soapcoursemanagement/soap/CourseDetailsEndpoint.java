package com.orbiter.soap.webservices.soapcoursemanagement.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.orbiter.courses.CourseDetails;
import com.orbiter.courses.GetAllCourseDetailsRequest;
import com.orbiter.courses.GetAllCourseDetailsResponse;
import com.orbiter.courses.GetCourseDetailsRequest;
import com.orbiter.courses.GetCourseDetailsResponse;
import com.orbiter.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	CourseDetailsService service;

	// method
	// input GetCourseDetailsRequest
	// response GetCourseDetailsResponse

	@PayloadRoot(namespace = "http://orbiter.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {

		Course course = service.findById(request.getId());
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();

		return mapCourseDetails(course, response);
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course, GetCourseDetailsResponse response) {

		CourseDetails courseDetails = mapCourse(course);

		response.setCourseDetails(courseDetails);

		return response;
	}

	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();

		for (Course course : courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}

	@PayloadRoot(namespace = "http://orbiter.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(
			@RequestPayload GetAllCourseDetailsRequest request) {

		List<Course> courses = service.findAll();

		return mapAllCourseDetails(courses);
	}

}
