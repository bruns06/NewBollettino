package com.bollettino.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bollettino.entities.Bollettino;

public interface BollettinoDAO extends JpaRepository<Bollettino, Integer> {

	@Query(value = "SELECT MAX(id) FROM `bollettini`",nativeQuery = true)
	int findLastId();
}
