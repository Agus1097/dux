package com.dux.challenge.exception.model;

public class TeamBadRequestException extends RuntimeException {

    public TeamBadRequestException() {
        super("La solicitud es inválida");
    }
}
