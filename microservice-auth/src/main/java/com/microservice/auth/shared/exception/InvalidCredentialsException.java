package com.microservice.auth.shared.exception;

public class InvalidCredentialsException extends RuntimeException{

    public InvalidCredentialsException(){
        super("Credenciales invalidas. Verifica tu correo o contraseña.");
    }
}
