package com.restapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="student2")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Student {
	

/*	@EmbeddedId
	CompositeStudent student;//for composite primery key*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="STUDENT_ID",length = 10)
	private Integer studentId;
	
	@Column(name ="DOB")
	public LocalDate DOB;
	
	@Column(name ="FIRST_NAME")
	public String firstName;
	
	@Column(name ="LAST_NAME")
	public String LastName;
	
	/*@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumns({@JoinColumn(insertable = false,updatable = false ,name = "STUDENT_ID" ,referencedColumnName = "STUDENT_ID"),
		@JoinColumn(insertable = false,updatable = false,name = "DOB" ,referencedColumnName = "DOB")})
	List<Libreary> libreary;*/
	
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(insertable = false,updatable = false,name = "STUDENT_ID" ,referencedColumnName = "STUDENT_ID")
	List<Libreary> libreary;
	
	/*@Temporal(value = TemporalType.DATE)
	@Column(name = "LOG_DATE")
	private Date logts;*/

	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL,optional = true)
	@JoinColumn(insertable = false, updatable = false, name = "STUDENT_ID" ,referencedColumnName = "STUDENT_ID")			
	Address address;

}
