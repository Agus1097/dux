package com.dux.challenge.security.exception;

public class LoginUnauthorizedException extends RuntimeException {
    public LoginUnauthorizedException() {
        super("Usuario o contraseña incorrecta");
    }
}
