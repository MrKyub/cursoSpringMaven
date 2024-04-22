package com.cursoMaven.springMaven.service.impl;

import com.cursoMaven.springMaven.dto.request.DatosTablasRequest;
import com.cursoMaven.springMaven.model.Direcciones;
import com.cursoMaven.springMaven.model.Empleos;
import com.cursoMaven.springMaven.model.Personas;
import com.cursoMaven.springMaven.repository.DireccionRepository;
import com.cursoMaven.springMaven.repository.EmpleoRepository;
import com.cursoMaven.springMaven.repository.PersonasRepository;
import com.cursoMaven.springMaven.service.DatosTablasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DatosTablasServiceImpl implements DatosTablasService {

    @Autowired
    private PersonasRepository personasRepository;
    @Autowired
    private EmpleoRepository empleoRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public ResponseEntity<Object> guardarDatosTablas(DatosTablasRequest datosTablasRequest) {

        log.info("Entando al metodo guardar datos tablas");

        ResponseEntity<Object> response = null;

        //intancia de los objetos que se ingresaran a la base de datos
        Empleos empleo = new Empleos();
        Direcciones direccion = new Direcciones();
        Personas persona = new Personas();

        //asignacion de datos para empleo
        empleo.setTitulo(datosTablasRequest.getDatosEmpleo().getTitulo());
        empleo.setEmpresa(datosTablasRequest.getDatosEmpleo().getEmpresa());
        empleo.setSalario(datosTablasRequest.getDatosEmpleo().getSalario());

        //asignacion de datos para direccion
        direccion.setCalle(datosTablasRequest.getDatosDireccion().getCalle());
        direccion.setCiudad(datosTablasRequest.getDatosDireccion().getCiudad());
        direccion.setEstado(datosTablasRequest.getDatosDireccion().getEstado());
        direccion.setCodigoPostal(datosTablasRequest.getDatosDireccion().getCodigoPostal());

        log.info("Asignacion de datos realizada para empleos y direcciones");

        try{
            log.info("entrando al try catch para realisar la incercion en los datos de empleo y direccion a la base de datos");
            empleoRepository.save(empleo);
            direccionRepository.save(direccion);

            log.info("Obteniendo Id asiganados a los datos de empleo y direccion que se acaban de ingresar");
            List<Empleos> listaEmpleos = empleoRepository.findAll();
            empleo.setEmpleoId(listaEmpleos.get(listaEmpleos.size() - 1).getEmpleoId());

            List<Direcciones> listaDirecciones = direccionRepository.findAll();
            direccion.setDireccionId(listaDirecciones.get(listaDirecciones.size() - 1).getDireccionId());

            log.info("El empleo_id es: " + empleo.getEmpleoId() + " Y direccion_id es: " + direccion.getDireccionId());

            log.info("Asiganando datos a la clase personas con los id correspindientes a los datos de empleados y direcciones antes ingresados");
            persona.setNombre(datosTablasRequest.getDatosPersona().getNombre());
            persona.setEdad(datosTablasRequest.getDatosPersona().getEdad());
            persona.setGenero(datosTablasRequest.getDatosPersona().getGenero());
            persona.setDireccionId(direccion.getDireccionId());
            persona.setEmpleoId(empleo.getEmpleoId());

            personasRepository.save(persona);

            response = ResponseEntity.status(HttpStatus.ACCEPTED).body("Los datos de las tablas fueron ingresados con exito");

        }catch (Exception e){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No fue posible ingresar los datos de las tablas a la base de datos" + e.getMessage());
        }
        return response;
    }
}
