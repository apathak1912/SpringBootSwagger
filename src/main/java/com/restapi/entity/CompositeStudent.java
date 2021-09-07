package com.restapi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompositeStudent implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="STUDENT_ID",length = 10)
	private Integer studentId;
	
	@Column(name ="DOB")
	public LocalDate DOB;

}
