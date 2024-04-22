package com.cursoMaven.springMaven.controller;

import com.cursoMaven.springMaven.model.Empleos;
import com.cursoMaven.springMaven.service.EmpleoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud-empleos-maven")
@Tag(name = "Menejo de datos de la tabla empleos")
public class EmpleoControler {

    @Autowired
    private EmpleoService empleoService;

    @GetMapping("/empleos-obetener-lista")
    @Operation(summary = "Operacion para obtener la lista de empleos de la bse de datos")
    public List<Empleos> listaEmpleos() {
        return empleoService.listaEmpleos();
    }

    @PostMapping("/empleos-guardar")
    @Operation(summary = "Operacion para guardar datos de un empleo a la base de datos")
    public ResponseEntity<Empleos> guardarEmpleo(@RequestBody Empleos empleo) {
        return empleoService.guardarEmpleo(empleo);
    }

    @PutMapping("/empleos-actualizar")
    @Operation(summary = "Operacion para actualizar los datos de un empleo en la base de datos")
    public ResponseEntity<Object> actualizarEmpleo(@RequestBody Empleos empleo) {
        return empleoService.actualizarEmpleo(empleo);
    }

    @DeleteMapping("/empleos-eliminar/{id}")
    @Operation(summary = "Operacion para eliminar los datos de un empleo de la base de datos")
    public ResponseEntity<Object> eliminarEmpleo(@PathVariable Long id) {
        return empleoService.eliminarEmpleo(id);
    }

    @GetMapping("/empleos-buscar-por-id/{id}")
    @Operation(summary = "Operacion para buscar un empleo en la base de datos por Id")
    public ResponseEntity<Object> buscarEmpleoId(@PathVariable Long id) {
        return empleoService.buscarEmpleoId(id);
    }
}
