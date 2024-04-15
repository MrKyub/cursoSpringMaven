package com.cursoMaven.springMaven.controller;

import com.cursoMaven.springMaven.dto.Persona;
import com.cursoMaven.springMaven.service.EjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso-spring-maven")
@Slf4j
public class HolaMundoController {

    @Autowired
    private EjerciciosService ejerciciosService;

    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola mundo desde spring con maven";
    }

    @GetMapping("/hola/{nombre}")
    public String holaMundoCustom(@PathVariable String nombre){
        log.info("El nombre que se envia atraves de la url es: " + nombre);
        return "Hola mundo " + nombre;
    }

    @PostMapping("/persona")
    public Persona datosPersona(@RequestBody Persona persona){
        return persona;
    }

    @GetMapping("/nombres")
    public List<String> getListaNombres(){
        return ejerciciosService.getListaNombres();
    }

}
