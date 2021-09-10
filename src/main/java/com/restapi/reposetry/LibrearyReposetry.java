package com.restapi.reposetry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entity.Libreary;

public interface LibrearyReposetry extends JpaRepository<Libreary, Integer> {

}
