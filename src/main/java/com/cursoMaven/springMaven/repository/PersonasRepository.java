package com.cursoMaven.springMaven.repository;

import com.cursoMaven.springMaven.model.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Long> {

}