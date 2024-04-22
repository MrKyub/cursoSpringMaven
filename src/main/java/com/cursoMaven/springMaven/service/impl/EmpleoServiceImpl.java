package com.cursoMaven.springMaven.service.impl;

import com.cursoMaven.springMaven.model.Empleos;
import com.cursoMaven.springMaven.repository.EmpleoRepository;
import com.cursoMaven.springMaven.service.EmpleoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmpleoServiceImpl implements EmpleoService {

    @Autowired
    private EmpleoRepository empleoRepository;

    @Override
    public List<Empleos> listaEmpleos() {


        log.info("Entrando al metodo lista Empleos");

        return empleoRepository.findAll();
    }

    @Override
    public ResponseEntity<Empleos> guardarEmpleo(Empleos empleo) {

        log.info("Entrando al metodo guardarEmpleo");

        return ResponseEntity.ok(empleoRepository.save(empleo));
    }

    @Override
    public ResponseEntity<Object> actualizarEmpleo(Empleos empleo) {

        log.info("Entrando al metodo actaualizar Empleo");

        ResponseEntity<Object> respose = null;

        Optional<Empleos> existeEmpleo = empleoRepository.findById(empleo.getEmpleoId());

        if(existeEmpleo.isPresent())
            respose = ResponseEntity.ok(empleoRepository.save(empleo));
        else
            respose = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el id del empleo");

        return respose;
    }

    @Override
    public ResponseEntity<Object> eliminarEmpleo(Long id) {

        log.info("Entrando al metodo eliminaar Empleo");

        ResponseEntity<Object> response = null;

        Optional<Empleos> existeEmpleo = empleoRepository.findById(id);

        if(existeEmpleo.isPresent()){
            empleoRepository.deleteById(existeEmpleo.get().getEmpleoId());
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body("El empleo fue eliminado de la base de datos");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El empleo no se pudo elminar de la base de datos");
        }
        return response;
    }

    @Override
    public ResponseEntity<Object> buscarEmpleoId(Long id) {

        log.info("Entrando al metodo buscar empleo por Id");

        ResponseEntity<Object> response = null;

        Optional<Empleos> existeEmpleo = empleoRepository.findById(id);

        if(existeEmpleo.isPresent())
            response = ResponseEntity.ok(empleoRepository.findById(id));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el id del empleo");

        return response;
    }
}
