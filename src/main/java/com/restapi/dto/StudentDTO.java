package com.restapi.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restapi.entity.Address;
import com.restapi.entity.Libreary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO {
	
	private Integer studentId;
	
	public String DOB;
	
	public String firstName;
	
	public String LastName;
	
	private Address address;
	
	private List<Libreary> libreary;

}
