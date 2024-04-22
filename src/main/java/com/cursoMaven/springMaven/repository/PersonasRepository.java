package com.cursoMaven.springMaven.repository;

import com.cursoMaven.springMaven.dto.request.PersonaRequest;
import com.cursoMaven.springMaven.dto.response.DatosPersonaResponse;
import com.cursoMaven.springMaven.model.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO personas (nombre, edad, genero, direccion_id, empleo_id) "
            + "VALUES "
            + "(:#{#request.nombre}, :#{#request.edad}, :#{#request.genero}, :#{#request.direccionId}, :#{#request.empleoId})", nativeQuery = true)
    Integer guardarPersonaNativa(@Param("request") PersonaRequest request);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE personas SET nombre = :#{#request.nombre} WHERE persona_id = :#{#request.personaId}", nativeQuery = true)
    Integer actualizarPersonaNativa(@Param("request")PersonaRequest request);

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM personas WHERE persona_id = :id", nativeQuery = true)
    void eliminarPersonaNativa(@Param("id") int id);

}