package com.dux.challenge.factory;

import com.dux.challenge.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamFactory {

    public static Team sampleTeam() {
        Team team = new Team();
        team.setId(1L);
        team.setNombre("Real Madrid");
        team.setLiga("La Liga");
        team.setPais("España");

        return team;
    }

    public static Team sampleUpdatedTeam() {
        Team team = new Team();
        team.setId(1L);
        team.setNombre("Independiente");
        team.setLiga("Superliga");
        team.setPais("Argentina");

        return team;
    }

    public static List<Team> sampleTeamList() {
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            teams.add(sampleTeam());
        }
        return teams;
    }
}
