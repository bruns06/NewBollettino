package com.bollettino.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bollettino.entities.Bollettino;

public interface BollettinoDAO extends JpaRepository<Bollettino, Integer> {

}
