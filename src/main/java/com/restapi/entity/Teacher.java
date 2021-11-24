package com.restapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "Teachers")
@Builder
@Data
public class Teacher {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer TEACHER_ID;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SPECIAL_SUB")
	private String SpecialSub;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(insertable = false,updatable = false,name = "TEACHER_ID" ,referencedColumnName = "TEACHER_ID" )
	Address address;
	
	
	
	
	
	

}
