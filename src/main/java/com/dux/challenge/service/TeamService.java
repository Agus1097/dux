package com.dux.challenge.service;

import com.dux.challenge.dto.TeamDTO;
import com.dux.challenge.exception.model.TeamBadRequestException;
import com.dux.challenge.exception.model.TeamNotFoundException;
import com.dux.challenge.model.Team;
import com.dux.challenge.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public List<Team> getTeams() {
        return teamRepository.findAllByOrderById();
    }

    public Team getTeamById(Long id) {
        try {
            return teamRepository.findById(id).orElseThrow();
        } catch (Exception ex) {
            throw new TeamNotFoundException();
        }
    }

    public List<Team> getTeamsByName(List<String> names) {
        List<Team> teams = names.stream()
                .map(teamRepository::findByNombre)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (teams.isEmpty()) {
            throw new TeamNotFoundException();
        }
        return teams;
    }

    public Team createTeam(TeamDTO teamDTO) {
        try {
            Team team = Team.builder()
                    .nombre(teamDTO.getNombre())
                    .liga(teamDTO.getLiga())
                    .pais(teamDTO.getPais())
                    .build();

            return teamRepository.save(team);
        } catch (Exception ex) {
            throw new TeamBadRequestException();
        }
    }

    public Team updateTeam(Long id, TeamDTO teamDTO) {
        Team team = getTeamById(id);

        team.setNombre(Objects.nonNull(teamDTO.getNombre()) ? teamDTO.getNombre() : team.getNombre());
        team.setLiga(Objects.nonNull(teamDTO.getLiga()) ? teamDTO.getLiga() : team.getLiga());
        team.setPais(Objects.nonNull(teamDTO.getPais()) ? teamDTO.getPais() : team.getPais());

        return team;
    }

    public void deleteTeam(Long id) {
        Team team = getTeamById(id);
        teamRepository.delete(team);
    }

}
