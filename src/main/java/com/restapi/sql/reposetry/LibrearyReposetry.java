package com.restapi.sql.reposetry;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restapi.entity.Libreary;

public interface LibrearyReposetry extends JpaRepository<Libreary, Integer> {

	@Modifying
	@Transactional
	@Query("Delete from Libreary where STUDENT_ID = :studentId AND Book_Name = :bookName ")
	int deleteIssuedBook(@Size @NotNull 
			@Param("studentId") Integer studentId, @Param("bookName") String bookName);

}
