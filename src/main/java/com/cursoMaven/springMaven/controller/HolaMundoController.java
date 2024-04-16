package com.cursoMaven.springMaven.controller;

import com.cursoMaven.springMaven.dto.Persona;
import com.cursoMaven.springMaven.service.EjerciciosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/curso-spring-maven")
@Slf4j
@Tag(name = "Hola Mundo Controller con maven")
public class HolaMundoController {


    //injeccion de la dependencia
    @Autowired
    private EjerciciosService ejerciciosService;

    @GetMapping("/hola")
    @Operation(summary = "Operacion para mostrar un hola mundo")
    public String holaMundo(){
        return "Hola mundo desde spring con gradle";
    }

    @GetMapping(path = "/hola/{nombre}")
    @Operation(summary = "Operacion para mostrar un hola mundo mandando un parametro")
    public String holaMundoCustom(@PathVariable String nombre){
        log.info("El nombre que se envia atraves de la url es : " + nombre);
        return "Hola mundo " + nombre;
    }

    @PostMapping("/persona")
    @Operation(summary = "Operacion para mostrar los datos de una persona")
    public Persona datosPersona(@Valid @RequestBody Persona persona){

        return persona;
    }

    @GetMapping("/nombres")
    @Operation(summary = "Operacion para mostrar una lista de nombres")
    public List<String> getListaNombres(){

        return ejerciciosService.getListaNombres();
    }

}
