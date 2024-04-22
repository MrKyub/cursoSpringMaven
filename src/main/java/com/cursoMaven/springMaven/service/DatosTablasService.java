package com.cursoMaven.springMaven.service;

import com.cursoMaven.springMaven.dto.request.DatosTablasRequest;
import org.springframework.http.ResponseEntity;

public interface DatosTablasService {

    ResponseEntity<Object> guardarDatosTablas(DatosTablasRequest datosTablasRequest);

}
