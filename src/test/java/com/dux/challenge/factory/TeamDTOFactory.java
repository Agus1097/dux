package com.dux.challenge.factory;

import com.dux.challenge.dto.TeamDTO;

public class TeamDTOFactory {

    public static TeamDTO sampleTeamDTO() {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setNombre("Real Madrid");
        teamDTO.setLiga("La Liga");
        teamDTO.setPais("España");

        return teamDTO;
    }

    public static TeamDTO sampleUpdatedTeamDTO() {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setNombre("Independiente");
        teamDTO.setLiga("Superliga");
        teamDTO.setPais("Argentina");

        return teamDTO;
    }
}
