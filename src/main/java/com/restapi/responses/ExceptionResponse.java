package com.restapi.responses;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {
	
	private String message;
    private LocalDateTime dateTime;	

}
