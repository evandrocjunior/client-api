package com.app.client.exception;

public class CPFAlreadyExistException extends RuntimeException {
    public CPFAlreadyExistException(String message) {
        super(message);
    }
}
