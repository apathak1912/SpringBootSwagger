package com.restapi.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibrearyDTO {
	
	
	private String bookName;
	
	
	private Integer studentId;
	
	@ApiParam(value = "date format will be like 'YYYY-MM-DD'")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate Date_of_Issue;

}
