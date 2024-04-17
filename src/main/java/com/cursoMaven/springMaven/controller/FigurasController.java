package com.cursoMaven.springMaven.controller;

import com.cursoMaven.springMaven.dto.CirculoDto;
import com.cursoMaven.springMaven.dto.RectanguloDto;
import com.cursoMaven.springMaven.dto.TrianguloDto;
import com.cursoMaven.springMaven.service.CirculoService;
import com.cursoMaven.springMaven.service.RectanguloService;
import com.cursoMaven.springMaven.service.TrianguloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/figuras-spring-maven")
@Tag(name = "API para calculo de figuras con maven")
@Slf4j
public class FigurasController {

    @Autowired
    private RectanguloService rectanguloService;

    @Autowired
    private TrianguloService trianguloService;

    @Autowired
    private CirculoService circuloService;

    //@GetMapping("/area-rectangulo/{base}/{altura}")
    @RequestMapping(method = RequestMethod.GET, value = "/area-rectangulo/{base}/{altura}")
    @Operation(summary = "Operacon para calcular el area de un rectangulo recibiendo 2 parametros")
    public double calcularAreaRectangulo(@PathVariable @Schema(description = "Base del rectangulo", example = "20.46") double base,
                                         @PathVariable @Schema(description = "Altura del rectangulo", example = "10.57") double altura){
        return base * altura;
    }

    @PostMapping("/area-rectangulo")
    @Operation(summary = "Operacon para calcular el area de un rectangulo recibiendo 2 parametros con JSON")
    public double calcularAreaRectangulo(@RequestBody RectanguloDto request){

        double area = request.getBase() * request.getAltura();

        return area;
    }

    @PostMapping("/area-rectangulo2")
    @Operation(summary = "Operacon para calcular el area de un rectangulo con inyeccion de deoendencias")
    public double calcularAreaRectangulo2(@RequestBody RectanguloDto request){
        return rectanguloService.calcularAreaRectangulo(request);
    }

    @PostMapping("/perimetro-rectangulo")
    @Operation(summary = "Operacion para calcular el perimetro del rectangulo")
    public double calcularPerimetroRectangulo(@RequestBody RectanguloDto request){
        return rectanguloService.calcularPerimetroRectangulo(request);
    }

    //Calculos para el triangulo

    @PostMapping("/area-triangulo")
    @Operation(summary = "Operacion para calcular el area del triangulo")
    public double calcularAreaTriangulo(@RequestBody TrianguloDto request){
        return trianguloService.calcularAreaTriangulo(request);
    }

    @PostMapping("/perimetro-triangulo")
    @Operation(summary = "Operacion para calcular el perimetro del triangulo")
    public double calcularPerimetroTriangulo(@RequestBody TrianguloDto request){
        return trianguloService.calcularPerimetroTriangulo(request);
    }

    //calculos para el circulo
    @PostMapping("/area-circulo")
    @Operation(summary = "Operacion para calcular el area del circulo")
    public double calcularAreaCirculo(@RequestBody CirculoDto request){
        return circuloService.calcularAreaCirculo(request);
    }

    @PostMapping("/perimetro-circulo")
    @Operation(summary = "Operacion para calcular el perimetro del circulo")
    public double calcularPerimetroCirculo(@RequestBody CirculoDto request){
        return circuloService.calcularPermietroCirculo(request);
    }
}