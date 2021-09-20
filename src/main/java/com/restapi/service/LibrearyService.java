package com.restapi.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import com.restapi.dto.LibrearyDTO;
@Service
public interface LibrearyService {
	
	public boolean saveLibreary(LibrearyDTO dto);

	public boolean deletedIssuedBook(@Size @NotNull Integer studentId, String bookName);

}
