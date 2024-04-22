package com.cursoMaven.springMaven.service;

import com.cursoMaven.springMaven.model.Direcciones;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DireccionService {

    List<Direcciones> listaDirecciones();

    ResponseEntity<Direcciones> guardarDireccion(Direcciones direccion);

    ResponseEntity<Object> actualizarDireccion(Direcciones direccion);

    ResponseEntity<Object> eliminarDireccion(Long id);

    ResponseEntity<Object> buscarDireccionId(Long id);

}
