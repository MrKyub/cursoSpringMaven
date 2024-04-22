package com.cursoMaven.springMaven.service.impl;

import com.cursoMaven.springMaven.dto.response.Posts;
import com.cursoMaven.springMaven.service.EjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EjerciciosServiceImpl implements EjerciciosService {

    @Override
    public List<String> getListaNombres() {
        log.info("Entro al metodo getListaNombres");

        List<String> response = new ArrayList<>();
        List<String> listaNombres = new ArrayList<>();

        listaNombres.add("Alexis");
        listaNombres.add("Johan");
        listaNombres.add("Cecilia");
        listaNombres.add("Isaac");

        for (String nombre : listaNombres){
            if(nombre.contains("o") || nombre.contains("O")){
                log.info("Entro al if de lista nombres");
                response.add(nombre);
            }
        }
        return response;
    }

    public Posts getPosts(int id) {

        ResponseEntity<Posts> resultPost = null;

        try{

            String url = "https://jsonplaceholder.typicode.com/todos/" + id;

            RestTemplate restTemplate = new RestTemplate();

            //forma 1
            //resultPost = restTemplate.exchange(url, HttpMethod.GET, null, Posts.class);

            //forma 2
            Posts response = restTemplate.getForObject(url, Posts.class);
            resultPost = ResponseEntity.ok(response);
        }catch (Exception e){
            log.error("Error al consumir el servicio");
        }
        return resultPost.getBody();
    }

}
