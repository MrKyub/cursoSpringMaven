package com.cursoMaven.springMaven.service;

import com.cursoMaven.springMaven.dto.request.PersonaRequest;
import com.cursoMaven.springMaven.model.Personas;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {

    List<Personas> findAllPersons();

    ResponseEntity<Personas> guardarPersona(Personas persona);

    ResponseEntity<Personas> guardarPersona2(PersonaRequest persona);

    Personas buscarPersonaId(Long id);

    ResponseEntity<Object> actualizarPersona(PersonaRequest persona);

    void eliminarPersona(Long id);

    List<String> obtenerPersonasPorGenero(String genero);

    ResponseEntity<Object> obtenerDatosPersonaFiltro(Integer id);

}
