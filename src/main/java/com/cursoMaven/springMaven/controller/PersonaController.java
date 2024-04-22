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

    @GetMapping("/persona-por-id/{id}")
    @Operation(summary = "Operacion para buscar una persona por su Id")
    public Personas buscarPersonaId(@PathVariable Long id){

        return personaService.buscarPersonaId(id);
    }

    @PutMapping("/persona-actualizar-datos")
    @Operation(summary = "Operacion para actualizar un registro en la BD")
    public ResponseEntity<Object> actualizarPersona(@RequestBody PersonaRequest request){
        return personaService.actualizarPersona(request);
    }

    @DeleteMapping("persona-borrar-registro/{id}")
    @Operation(summary = "Operacion para eliminar el registro de una persona de la BD")
    public void eliminarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
    }

    @GetMapping("/personas-genero/{genero}")
    @Operation(summary = "Operacion para obtener los datos por genero")
    public List<String> obtenerNombrePersonaPorGenero(@PathVariable String genero){
        return personaService.obtenerPersonasPorGenero(genero);
    }

    @GetMapping("/personas/informacion-filtro/{id}}")
    @Operation(summary = "Operacion para obtener solo ciertos datos de la persona")
    public ResponseEntity<Object> obtenerDatosPersonaFiltro(@PathVariable Integer id){
        return personaService.obtenerDatosPersonaFiltro(id);
    }

    @PostMapping("/persona/guardar/forma-nativa")
    @Operation(summary = "Operacion para guardar los en BD manera nativa")
    public ResponseEntity<?> guardarPersonaFormaNativa(@RequestBody PersonaRequest request){
        return personaService.guardarPersonaFormaNativa(request);
    }

    @PutMapping("/person/actualizar/forma-nativa")
    @Operation(summary = "Operacion para actualizar BD forma nativa")
    public ResponseEntity<?> actualizarPersonaFormaNativa(@RequestBody PersonaRequest request){
        return personaService.actualizarPersonaFormaNativa(request);
    }

    @DeleteMapping("persona/eliminar/forma-nativa")
    @Operation(summary = "Operacion para eliminar en la BD de forma nativa")
    public boolean eliminarPersonaFormaNativa(int id) {
        return personaService.eliminarPersonaFormaNativa(id);
    }

}
