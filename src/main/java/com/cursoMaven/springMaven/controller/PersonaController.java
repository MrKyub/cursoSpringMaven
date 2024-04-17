package com.cursoMaven.springMaven.controller;

import com.cursoMaven.springMaven.dto.request.PersonaRequest;
import com.cursoMaven.springMaven.model.Personas;
import com.cursoMaven.springMaven.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas-spring-maven")
@Tag(name = "Manejo datos tabla Personas con Maven")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas-obtener")
    @Operation(summary = "Operacion para obtener todos los datos de personas")
    public List<Personas> obtenerPersonas(){

        return personaService.findAllPersons();
    }

    @PostMapping("/personas-guardar")
    @Operation(summary = "Operacion para guardar personas en BD")
    public ResponseEntity<Personas> guardarPersonas(@RequestBody Personas persona){

        return personaService.guardarPersona(persona);
    }

    @PostMapping("/personas-guardar2")
    @Operation(summary = "Operacion para guardar personas en BD usando una clase para asignar datos")
    public ResponseEntity<Personas> guardarPersonas2(@RequestBody PersonaRequest persona) {

        return personaService.guardarPersona2(persona);
    }
}
