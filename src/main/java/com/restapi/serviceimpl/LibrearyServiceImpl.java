package com.restapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dao.LibrearyDao;
import com.restapi.dto.LibrearyDTO;
import com.restapi.service.LibrearyService;
import com.restapi.util.Mapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class LibrearyServiceImpl implements LibrearyService {
	
	@Autowired
	Mapping mapping;
	
	@Autowired 
	LibrearyDao libdao;

	@Override
	public boolean saveLibreary(LibrearyDTO dto) {
		try {
		return libdao.saveLibreary(mapping.mapLibrearyDtoToLibreary(dto));
		}catch (Exception e) {
			log.error("error in service class " +e);
			return false;
		}
		 
	}

}
