package com.restapi.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;

import com.restapi.entity.Student;
import com.restapi.sql.reposetry.StudentReposetry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StudentDao {
	
	@Autowired
	StudentReposetry reposetry;
	
	public boolean persistStudent(Student student) {
		try {
		Student savedStudent = reposetry.saveAndFlush(student);
		return (savedStudent != null)?true:false;
		}catch (DataIntegrityViolationException | JpaSystemException e) {
			//This exception thrown while insert or update the record when vilation of an integrity constraint
			log.error("DataIntegrityViolationException "+e);
			return false;
		} catch (NoResultException | EmptyResultDataAccessException e) {
			log.error("NoResultException "+e);
			return false;
		} catch (DataAccessResourceFailureException e) {
			log.error("DataAccessResourceFailureException "+e);
			return false;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public Student getStudentById(Integer id) {
		try {
			return reposetry.getStudentByID(id);
			//return reposetry.getById(id);
		} catch (NoResultException | EmptyResultDataAccessException e) {
			return null;
		} catch (DataAccessResourceFailureException | JpaSystemException e) {
			return null;
		} catch(Exception e) {
			return null;
		}
	}

	public List<Student> getListOfStudents() {
		try {
			return reposetry.getListOfStudents();
			//return reposetry.getById(id);
		} catch (NoResultException | EmptyResultDataAccessException e) {
			return null;
		} catch (DataAccessResourceFailureException | JpaSystemException e) {
			return null;
		} catch(Exception e) {
			return null;
		}
	}

}
