package com.dux.challenge.exception.model;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException() {
        super("Equipo no encontrado");
    }
}
