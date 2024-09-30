package ru.romanorlov.circuit_breaker.exception;

import lombok.Getter;

@Getter
public class UnhandledException extends RuntimeException {

    private final String code;
    private final String message;

    public UnhandledException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
