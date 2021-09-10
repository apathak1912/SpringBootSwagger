package com.restapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Address")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "First_Line")
	private String firstLine;
	
	@Column(name = "State")
	private String State;
	
	@Column(name = "Pin")
	private Integer pin;
	
	@Column(name = "City")
	private String city;
	
	@Column(name ="STUDENT_ID",length = 10)
	private Integer studentId;
	
}
