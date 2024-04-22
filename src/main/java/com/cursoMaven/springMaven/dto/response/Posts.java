package com.cursoMaven.springMaven.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Posts {

    //@JsonProperty(value = "user_id")
    private int userId;
    private int id;
    private String title;
    private boolean completed;

}
