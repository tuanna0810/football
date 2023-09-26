package com.football.football.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class TeamDTO implements Serializable {
    private Long id;

    private String name;
    private String coach;

    private String national;

}
