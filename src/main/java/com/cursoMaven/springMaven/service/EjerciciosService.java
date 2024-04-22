package com.cursoMaven.springMaven.service;

import com.cursoMaven.springMaven.dto.response.Posts;

import java.util.List;

public interface EjerciciosService {

    List<String> getListaNombres();

    Posts getPosts(int id);

}
