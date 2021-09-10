package com.restapi.service;

import org.springframework.stereotype.Service;

import com.restapi.dto.LibrearyDTO;
@Service
public interface LibrearyService {
	
	public boolean saveLibreary(LibrearyDTO dto);

}
