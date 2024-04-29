package com.dux.challenge.dto;

import com.dux.challenge.model.Team;
import lombok.Data;

import java.util.List;

@Data
public class TeamListDTO {
    private List<Team> teams;
}
