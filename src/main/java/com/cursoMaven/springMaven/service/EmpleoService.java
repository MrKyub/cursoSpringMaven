package com.cursoMaven.springMaven.service;

import com.cursoMaven.springMaven.model.Empleos;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmpleoService {

    List<Empleos> listaEmpleos();

    ResponseEntity<Empleos> guardarEmpleo(Empleos empleo);

    ResponseEntity<Object> actualizarEmpleo(Empleos empleo);

    ResponseEntity<Object> eliminarEmpleo(Long id);

    ResponseEntity<Object> buscarEmpleoId(Long id);

}
