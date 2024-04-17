package com.cursoMaven.springMaven.service.impl;

import com.cursoMaven.springMaven.dto.request.PersonaRequest;
import com.cursoMaven.springMaven.model.Personas;
import com.cursoMaven.springMaven.repository.PersonasRepository;
import com.cursoMaven.springMaven.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public List<Personas> findAllPersons() {
        return personasRepository.findAll();
    }

    @Override
    public ResponseEntity<Personas> guardarPersona(Personas persona) {

        return ResponseEntity.ok(personasRepository.save(persona));
    }

    @Override
    public ResponseEntity<Personas> guardarPersona2(PersonaRequest request) {

        Personas personas = new Personas();
        personas.setNombre(request.getNombre());
        personas.setEdad(request.getEdad());
        personas.setGenero(request.getGenero());
        personas.setDireccionId(request.getDireccionId());
        personas.setEmpleoId(request.getEmpleoId());

        return ResponseEntity.ok(personasRepository.save(personas));
    }
}
