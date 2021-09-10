package com.restapi.dao;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;

import com.restapi.entity.Libreary;
import com.restapi.reposetry.LibrearyReposetry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LibrearyDao {
	
	@Autowired
	LibrearyReposetry librearyRepo;
	
	public boolean saveLibreary(Libreary libreary) {
		try {
			Libreary lib = librearyRepo.saveAndFlush(libreary);
			return (lib!= null)?true:false;
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
		}catch(Exception e) {
			log.error("Error while persisting Libreary Book issued "+e);
			return false;
		}
		
	}

}
