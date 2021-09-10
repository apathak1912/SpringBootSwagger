package com.restapi.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.tomcat.jni.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restapi.entity.CompositeStudent;
import com.restapi.entity.Libreary;
import com.restapi.entity.Student;
import com.restapi.http.Response;
import com.restapi.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = {"local/student","int/studentInfo"})
public class RestController {
	
	@Autowired
	StudentService studentService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);
	
	@GetMapping(value = "/healthcheck")
	public String healthCheck() {
		return "ok";
	}

/*	@ResponseStatus
	@ApiOperation(value = "this Api is used for save StudentInfo" ,notes ="This Api is used to persist the Student Info")
	@ApiResponses(value = { @ApiResponse(code = 200 ,message ="Feched student information success fully"),
			 @ApiResponse(code = 500 ,message ="Internol Server Error", response = String.class)
	})
	@PostMapping(value ="/studentId/{studentId}/firstName/{firstName}/LastName/{LastName}/saveStudentInfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> saveStudentDetails(
			@Valid
			@Size(min = 2 ,message = "Id shold be atleast 2 char",max = 20)
			@PathVariable(name = "studentId" ,required = true) String studentId,
			@PathVariable(name ="firstName" , required = true) String firstName,
			@PathVariable(name ="LastName" , required = true) String lastName,
			@ApiParam(value ="date format will be like 'YYYY-MM-DD'")
			@RequestParam(value ="dbo")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    		LocalDate dob){
		
		return ResponseEntity.ok(Response.builder().firstName(firstName).LastName(lastName).DOB(dob).studentId(studentId).build());
		
	}*/
	@ResponseStatus
	@ApiOperation(value = "This rest use to save studen information" , notes = "This Api is used to persist the student information")
	@ApiResponses(value = {@ApiResponse(code = 200 , message = "Saved Student Details Successfully.."),
						   @ApiResponse(code = 500 , message = "Internol server Error"),
						   @ApiResponse(code = 403,  message =  "unauthrised access" )})
	@PostMapping(value = "/studentId/{studentId}/firstName/{firstName}/saveStudentInfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveStudentDetails(
			@NotNull(message = "Please enter id")
			@PathVariable(name = "studentId", required = true) Integer studentID,
			@Valid
			@Size(min = 3 ,max = 15,message = "First Name should be atLeast 3 char or maximum char will be 13")
			@PathVariable(name = "firstName" , required = true) String firstName,
			@RequestParam(name = "LastName" ,required = false) String LastName,
			@ApiParam(value = "date format will be like 'YYYY-MM-DD'")
			@RequestParam(name = "dbo")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)	LocalDate dob){
		LOGGER.info("recive the request for save Student details ..");
		
		CompositeStudent compositeStudent = CompositeStudent.builder()
				.DOB(dob)
				.studentId(studentID)
				.build();
		Libreary lib = Libreary.builder().bookName("Math2").DOB(dob).studentId(studentID).build();
		ArrayList<Libreary> liblist = new ArrayList<Libreary>();
		liblist.add(lib);
		//Student student = Student.builder().firstName(firstName).LastName(LastName).student(compositeStudent).libreary(liblist).build();
		Student student = Student.builder().firstName(firstName).LastName(LastName).student(compositeStudent).build();
	    boolean response = studentService.saveStudent(student);
		return response?ResponseEntity.ok(HttpStatus.ACCEPTED.toString()):ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR.toString());
	}
	
	@ResponseStatus
	@ApiOperation(value = "This Api is used to get Student Details" , notes = "This Api is used to get Student Details")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Retrived Student Successfully ..."),
						   @ApiResponse(code = 500, message = "Internol Server Error"),
						   @ApiResponse(code = 403, message = "UnAuthorised Access")})
	@GetMapping(value = "/studentId/{studentId}")
	public ResponseEntity<Object> getStudentDetails(@PathVariable(name = "studentId") Integer id){
		
		Student student =  studentService.getStudentById(id);
		
		return (student!=null)?ResponseEntity.ok(student):ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR.toString());		
	}
	
	
	public ResponseEntity<String> bookIssuedToStudent(){
		return null;
		
	}
	
}
