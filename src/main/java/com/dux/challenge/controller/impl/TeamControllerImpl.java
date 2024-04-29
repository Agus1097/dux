package com.dux.challenge.controller.impl;


import com.dux.challenge.dto.TeamDTO;
import com.dux.challenge.dto.TeamListDTO;
import com.dux.challenge.model.Team;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeamControllerImpl {

    @Operation(summary = "Endpoint para obtener todos los equipos disponibles",
            description = "Este endpoint va a buscar todos los equipos que tenemos en la base de datos y los va a visualizar en la response. Importante agregar el token antes de realizar la consulta")
    @ApiResponses(value = {
            @ApiResponse(description = "OK", responseCode = "200", content = @Content(schema = @Schema(implementation = TeamListDTO.class), mediaType = "application/json")),
            @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<List<Team>> getTeams();

    @Operation(summary = "Endpoint para obtener un equipo por ID",
            description = "Este endpoint va a buscar el equipo por ID que tenemos en la base de datos y lo va a visualizar en la response. Importante agregar el token antes de realizar la consulta")
    @ApiResponses(value = {
            @ApiResponse(description = "OK", responseCode = "200", content = @Content(schema = @Schema(implementation = Team.class), mediaType = "application/json")),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"mensaje\": \"Equipo no encontrado\", \"codigo\": 404}"))),
            @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<Team> getTeamById(Long id);

    @Operation(summary = "Endpoint para obtener uno o mas equipos por nombre/s",
            description = "Este endpoint va a buscar uno o mas equipos por nombre y lo va a visualizar en la response. Importante agregar el token antes de realizar la consulta")
    @ApiResponses(value = {
            @ApiResponse(description = "OK", responseCode = "200", content = @Content(schema = @Schema(implementation = TeamListDTO.class), mediaType = "application/json")),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"mensaje\": \"Equipo no encontrado\", \"codigo\": 404}"))),
            @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<List<Team>> getTeamsByNames(List<String> names);

    @Operation(summary = "Endpoint va a crear un equipo",
            description = "Este endpoint va a crear un equipo. Los parametros son nombre, equipo y liga. Importante agregar el token antes de realizar la consulta")
    @ApiResponses(value = {
            @ApiResponse(description = "Created", responseCode = "201", content = @Content(schema = @Schema(implementation = Team.class), mediaType = "application/json")),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"mensaje\": \"La solicitud es inválidao\", \"codigo\": 400}"))),
            @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<Team> createTeam(TeamDTO teamDTO);

    @Operation(summary = "Endpoint va a actulizar alguno de los parametros de un equipo",
            description = "Este endpoint va a actulizar un equipo. Los parametros que se pueden actualizar son nombre, equipo y liga. Importante agregar el token antes de realizar la consulta")
    @ApiResponses(value = {
            @ApiResponse(description = "OK", responseCode = "200", content = @Content(schema = @Schema(implementation = Team.class), mediaType = "application/json")),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"mensaje\": \"Equipo no encontrado\", \"codigo\": 404}"))),
            @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<Team> updateTeam(Long id, TeamDTO teamDTO);

    @Operation(summary = "Endpoint va a eliminar un equipo",
            description = "Este endpoint va a eliminar un equipo de la base de datos. Importante agregar el token antes de realizar la consulta")
    @ApiResponses(value = {
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content(mediaType = "application/json")),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"mensaje\": \"Equipo no encontrado\", \"codigo\": 404}"))),
            @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<?> deleteTeam(Long id);
}
