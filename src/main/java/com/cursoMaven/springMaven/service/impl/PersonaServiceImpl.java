package com.cursoMaven.springMaven.service.impl;

import com.cursoMaven.springMaven.dto.request.PersonaRequest;
import com.cursoMaven.springMaven.dto.response.DatosPersonaResponse;
import com.cursoMaven.springMaven.model.Personas;
import com.cursoMaven.springMaven.repository.PersonasRepository;
import com.cursoMaven.springMaven.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public List<Personas> findAllPersons() {
        return personasRepository.findAll();
    }

    @Override
    public ResponseEntity<Personas> guardarPersona(Personas persona) {

        return ResponseEntity.ok(personasRepository.save(persona));
    }

    @Override
    public ResponseEntity<Personas> guardarPersona2(PersonaRequest request) {

        Personas personas = new Personas();
        personas.setNombre(request.getNombre());
        personas.setEdad(request.getEdad());
        personas.setGenero(request.getGenero());
        //personas.setDireccionId(request.getDireccionId());
        //personas.setEmpleoId(request.getEmpleoId());

        return ResponseEntity.ok(personasRepository.save(personas));
    }

    @Override
    public Personas buscarPersonaId(Long id) {

        Optional<Personas> datosPersona = personasRepository.findById(id);

        return datosPersona.get();
    }

    @Override
    public ResponseEntity<Object> actualizarPersona(PersonaRequest request) {

        ResponseEntity<Object> response = null;

        Optional<Personas> existePersona = personasRepository.findById(request.getPersonaid());

        if(existePersona.isPresent()) {

            Personas personas = new Personas();
            personas.setPersonaId(request.getPersonaid());
            personas.setNombre(request.getNombre());
            personas.setEdad(request.getEdad());
            personas.setGenero(request.getGenero());
            //personas.setDireccionId(request.getDireccionId());
            //personas.setEmpleoId(request.getEmpleoId());

            response = ResponseEntity.ok(personasRepository.save(personas));
        } else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la persona");
        }
        return response;
    }

    @Override
    public void eliminarPersona(Long id) {
        personasRepository.deleteById(id);
    }

    @Override
    public List<String> obtenerPersonasPorGenero(String genero){
        return personasRepository.personarPorGenero(genero);
    }

    @Override
    public ResponseEntity<Object> obtenerDatosPersonaFiltro(Integer id){

        ResponseEntity<Object> response = null;

        try{
            Optional<DatosPersonaResponse> infoPersona = Optional.ofNullable(personasRepository.obtenerDatosPersona(id));

            if(infoPersona.isPresent()){
                response = ResponseEntity.ok(infoPersona.get());
            }else{
                response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontraron los datos de la persona con ID" + id);
            }
        }catch (Exception e){
            log.error("Error en metodo obtenerDatosPersonaFiltro" + e.getMessage());
        }

        return  response;
    }

}
