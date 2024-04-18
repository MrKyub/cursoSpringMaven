package com.cursoMaven.springMaven.repository;

import com.cursoMaven.springMaven.dto.response.DatosPersonaResponse;
import com.cursoMaven.springMaven.model.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Long> {

    @Query(value = "SELECT p.nombre FROM Personas p WHERE p.genero = :genero")
    List<String> personarPorGenero(@Param("genero") String genero);

    @Query(value = "SELECT p.nombre, e.titulo, e.salario FROM personas p "
            + "JOIN empleos e ON p.empleo_id = e.empleo_id "
            + "WHERE p.persona_id = :personaId", nativeQuery = true)
    DatosPersonaResponse obtenerDatosPersona(@Param("personaId") Integer personaId);

}