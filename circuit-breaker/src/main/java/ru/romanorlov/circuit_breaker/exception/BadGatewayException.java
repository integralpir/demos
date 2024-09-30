package ru.romanorlov.circuit_breaker.exception;

import lombok.Getter;

@Getter
public class BadGatewayException extends RuntimeException {

    private final String status;
    private final String message;

    public BadGatewayException(String status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}
