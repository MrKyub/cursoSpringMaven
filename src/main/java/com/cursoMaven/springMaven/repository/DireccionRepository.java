package com.cursoMaven.springMaven.repository;

import com.cursoMaven.springMaven.model.Direcciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direcciones, Long> {
}
