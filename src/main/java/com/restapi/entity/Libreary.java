package com.restapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Libreary" )
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Libreary {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(name ="Book_Name")
	private String bookName;
	
	@Column(name ="STUDENT_ID",length = 10)
	private Integer studentId;
	
	@Column(name ="Date_of_Issue")
	public LocalDate Date_of_Issue;
	
	

}
