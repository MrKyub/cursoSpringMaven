package com.cursoMaven.springMaven.service.impl;

import com.cursoMaven.springMaven.model.Direcciones;
import com.cursoMaven.springMaven.repository.DireccionRepository;
import com.cursoMaven.springMaven.service.DireccionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public List<Direcciones> listaDirecciones() {
        log.info("Entrando el metodo lista de direcciones");

        return direccionRepository.findAll();
    }

    @Override
    public ResponseEntity<Direcciones> guardarDireccion(Direcciones direccion) {

        log.info("Ingresando al metodo guardar Direccion");

        return ResponseEntity.ok(direccionRepository.save(direccion));
    }

    @Override
    public ResponseEntity<Object> actualizarDireccion(Direcciones direccion) {

        log.info("Ingresando al metodo actualizar DIrreccion");

        ResponseEntity<Object> response = null;

        Optional<Direcciones> existeDireccion = direccionRepository.findById(direccion.getDireccionId());

        if(existeDireccion.isPresent())
            response = ResponseEntity.ok(direccionRepository.save(direccion));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id de la direccion no se encontro");

        return response;
    }

    @Override
    public ResponseEntity<Object> eliminarDireccion(Long id) {

        log.info("Ingresando al metodo eliminar Direccion");

        ResponseEntity<Object> response = null;

        Optional<Direcciones> existeDireccion = direccionRepository.findById(id);

        if(existeDireccion.isPresent()){
            direccionRepository.deleteById(existeDireccion.get().getDireccionId());
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body("La direccion fue eliminada de la Base de datos");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No fue posible eliminar la direccion de la base de datos");
        }
        return response;
    }

    @Override
    public ResponseEntity<Object> buscarDireccionId(Long id) {

        log.info("Entrando al metodo buscar direccion por id");

        ResponseEntity<Object> response = null;

        Optional<Direcciones> existeDireccion = direccionRepository.findById(id);

        if(existeDireccion.isPresent())
            response = ResponseEntity.ok(direccionRepository.findById(id));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el id de la direccion");

        return response;
    }
}
