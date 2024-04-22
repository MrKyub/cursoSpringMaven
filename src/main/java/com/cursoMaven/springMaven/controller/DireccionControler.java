package com.cursoMaven.springMaven.controller;

import com.cursoMaven.springMaven.model.Direcciones;
import com.cursoMaven.springMaven.service.DireccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud-direcciones.maven")
@Tag(name = "Menejo de datos de la tabla direcciones")
public class DireccionControler {

    @Autowired
    private DireccionService direccionService;

    @GetMapping("/direcciones-obtener-lista")
    @Operation(summary = "Operacion para obtener la lista de direcciones de la base de datos")
    public List<Direcciones> listaDirecciones(){
        return direccionService.listaDirecciones();
    }

    @PostMapping("/direcciones-guardar")
    @Operation(summary = "Operacion para guardar los datos de una direccion en la base de datos")
    public ResponseEntity<Direcciones> guardarDireccion(@RequestBody Direcciones direccion){
        return direccionService.guardarDireccion(direccion);
    }

    @PutMapping("/direcciones-actualizar}")
    @Operation(summary = "Operacion para actualizar los datos de una direccion en la base de datos")
    public ResponseEntity<Object> actualizarDireccion(@RequestBody Direcciones direccion){
        return direccionService.actualizarDireccion(direccion);
    }

    @DeleteMapping("/direcciones-eliminar/{id}")
    @Operation(summary = "Operaicon para eliminar los datos una direccion de la base de datos")
    public ResponseEntity<Object> eliminarDireccion(@PathVariable Long id){
        return direccionService.eliminarDireccion(id);
    }

    @GetMapping("/direcciones-buscar-por-id/{id}")
    @Operation(summary = "Operacion para buscar una direccion de la base de datos por id")
    public ResponseEntity<Object> buscarDireccionId(@PathVariable Long id){
        return direccionService.buscarDireccionId(id);
    }
}
