package com.restapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
public class Student {
	

	@EmbeddedId
	CompositeStudent student;//for composite primery key
	
	@Column(name ="FIRST_NAME")
	public String firstName;
	
	@Column(name ="LAST_NAME")
	public String LastName;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumns({@JoinColumn(insertable = false,updatable = false ,name = "STUDENT_ID" ,referencedColumnName = "STUDENT_ID"),
		@JoinColumn(insertable = false,updatable = false,name = "DOB" ,referencedColumnName = "DOB")})
	List<Libreary> libreary;
	
	/*@Temporal(value = TemporalType.DATE)
	@Column(name = "LOG_DATE")
	private Date logts;*/


}
