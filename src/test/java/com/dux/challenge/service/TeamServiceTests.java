package com.dux.challenge.service;

import com.dux.challenge.dto.TeamDTO;
import com.dux.challenge.exception.model.TeamBadRequestException;
import com.dux.challenge.exception.model.TeamNotFoundException;
import com.dux.challenge.model.Team;
import com.dux.challenge.repository.TeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.dux.challenge.factory.TeamDTOFactory.sampleTeamDTO;
import static com.dux.challenge.factory.TeamDTOFactory.sampleUpdatedTeamDTO;
import static com.dux.challenge.factory.TeamFactory.*;
import static com.dux.challenge.factory.TeamNamesFactory.sampleTeamNamesList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamServiceTests {

    @InjectMocks
    TeamService teamService;

    @Mock
    TeamRepository teamRepository;

    @Test
    void getAllTeams_returnListOfTeams() {
        List<Team> expected = sampleTeamList();

        when(teamRepository.findAllByOrderById()).thenReturn(expected);
        List<Team> result = teamService.getTeams();

        assertEquals(expected, result);
        Assertions.assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void getTeamById_returnTeam() {
        Team expected = sampleTeam();

        when(teamRepository.findById(anyLong())).thenReturn(Optional.of(expected));
        Team result = teamService.getTeamById(sampleTeam().getId());

        assertEquals(expected, result);
        Assertions.assertNotNull(result);
    }

    @Test
    void getTeamById_teamNotFoundException() {
        Team expected = sampleTeam();

        when(teamRepository.findById(anyLong())).thenReturn(null);

        assertThrows(TeamNotFoundException.class, () -> teamService.getTeamById(expected.getId()));
    }

    @Test
    void getTeamsByName_returnListOfTeams() {
        Team expected = sampleTeam();
        List<Team> expectedList = sampleTeamList();
        List<String> names = sampleTeamNamesList();

        when(teamRepository.findByNombre(anyString())).thenReturn(expected);
        List<Team> resultList = teamService.getTeamsByName(names);

        assertEquals(expectedList, resultList);
        Assertions.assertNotNull(resultList);
    }

    @Test
    void getTeamsByName_teamNotFoundException() {
        List<String> names = sampleTeamNamesList();

        when(teamRepository.findByNombre(anyString())).thenReturn(null);

        assertThrows(TeamNotFoundException.class, () -> teamService.getTeamsByName(names));
    }

    @Test
    void createTeam_returnTeam() {
        TeamDTO teamDTO = sampleTeamDTO();
        Team expected = sampleTeam();

        when(teamRepository.save(any(Team.class))).thenReturn(expected);
        Team result = teamService.createTeam(teamDTO);

        assertEquals(expected, result);
        Assertions.assertNotNull(result);
    }

    @Test
    void createTeam_teamBadRequestException() {
        TeamDTO teamDTO = sampleTeamDTO();

        when(teamRepository.save(any(Team.class))).thenThrow(new TeamBadRequestException());

        assertThrows(TeamBadRequestException.class, () -> teamService.createTeam(teamDTO));
    }

    @Test
    void updateTeam_returnTeam() {
        TeamDTO teamDTO = sampleUpdatedTeamDTO();
        Team expected = sampleUpdatedTeam();

        when(teamRepository.findById(anyLong())).thenReturn(Optional.of(expected));
        Team result = teamService.updateTeam(expected.getId(), teamDTO);

        assertEquals(expected, result);
        Assertions.assertNotNull(result);
    }

    @Test
    void deleteTeam() {
        Team expected = sampleTeam();

        when(teamRepository.findById(anyLong())).thenReturn(Optional.of(expected));
        teamService.deleteTeam(expected.getId());

        verify(teamRepository).delete(expected);
    }
}
