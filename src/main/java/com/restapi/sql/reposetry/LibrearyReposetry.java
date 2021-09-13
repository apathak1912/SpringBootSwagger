package com.restapi.sql.reposetry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entity.Libreary;

public interface LibrearyReposetry extends JpaRepository<Libreary, Integer> {

}
