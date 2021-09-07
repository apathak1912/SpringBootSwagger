package com.restapi.http;

import java.time.LocalDate;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Validated
@Builder
@Data
@AllArgsConstructor
public class Response {
	
	@JsonProperty("Student Id")
	public String studentId;
	
	@JsonProperty("First Name")
	public String firstName;
	
	@JsonProperty("Last Name")
	public String LastName;
	
	@JsonProperty("DOB")
	public LocalDate DOB;

}
