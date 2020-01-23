package com.orbiter.soap.webservices.soapcoursemanagement.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.orbiter.courses.CourseDetails;
import com.orbiter.courses.GetCourseDetailsRequest;
import com.orbiter.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {
	
	//method
	//input GetCourseDetailsRequest
	//response GetCourseDetailsResponse
	
	@PayloadRoot(namespace = "http://orbiter.com/courses" , localPart ="GetCourseDetailsRequest" )
	@ResponsePayload
	public GetCourseDetailsResponse 
			processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		
		GetCourseDetailsResponse  response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("spring boot");
		courseDetails.setDescription("making soap vweb services");
		response.setCourseDetails(courseDetails);
		
		return response ;
	}
}
