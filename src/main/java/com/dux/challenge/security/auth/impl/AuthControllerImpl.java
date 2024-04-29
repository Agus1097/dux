package com.dux.challenge.security.auth.impl;

import com.dux.challenge.security.auth.AuthResponse;
import com.dux.challenge.security.auth.LoginRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthControllerImpl {

    @Operation(summary = "Endpoint para loguearse",
            description = "Este endpoint va a loguearnos y nos va a devolver un token. Los parámetros que tenemos que pasarle son usuario y contraseña. Los valores por default son, username: test y password: 12345")
    @ApiResponses(value = {
            @ApiResponse(description = "OK", responseCode = "200", content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Token", value = "{\"token\": \"ey.ass5d4a5sd4a5d4sa5d4ssf54a\"}"))),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Usuario o contraseña incorrecta", value = "{\"mensaje\": \"Usuario o contraseña incorrecta\", \"codigo\": 401}"))),
    })
    ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request);
}
