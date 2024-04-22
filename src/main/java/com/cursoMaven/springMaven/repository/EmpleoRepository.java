package com.cursoMaven.springMaven.repository;

import com.cursoMaven.springMaven.model.Empleos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleoRepository extends JpaRepository<Empleos, Long> {
}
