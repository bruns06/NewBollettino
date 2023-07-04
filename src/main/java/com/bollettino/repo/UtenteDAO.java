package com.bollettino.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bollettino.entities.Utente;

public interface UtenteDAO extends JpaRepository<Utente, Integer> {

}
