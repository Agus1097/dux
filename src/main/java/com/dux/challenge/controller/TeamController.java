package com.dux.challenge.controller;

import com.dux.challenge.controller.impl.TeamControllerImpl;
import com.dux.challenge.dto.TeamDTO;
import com.dux.challenge.model.Team;
import com.dux.challenge.service.TeamService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
@RequiredArgsConstructor
@Tag(name = "Equipos")
public class TeamController implements TeamControllerImpl {

    private final TeamService teamService;

    @Override
    @GetMapping
    public ResponseEntity<List<Team>> getTeams() {
        return ResponseEntity.ok(teamService.getTeams());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @Override
    @GetMapping("/buscar")
    public ResponseEntity<List<Team>> getTeamsByNames(@RequestParam("nombre") List<String> names) {
        return ResponseEntity.ok(teamService.getTeamsByName(names));
    }

    @Override
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO teamDTO) {
        return new ResponseEntity<>(teamService.createTeam(teamDTO), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody TeamDTO teamDTO) {
        return ResponseEntity.ok(teamService.updateTeam(id, teamDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }

}
