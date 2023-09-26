package com.football.football.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GroupDTO implements Serializable {
    private List<TeamDTO> teamDTOList;
}
