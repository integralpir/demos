package ru.romanorlov.circuit_breaker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romanorlov.circuit_breaker.integration.MockApiIntegration;
import ru.romanorlov.circuit_breaker.model.MockApiResponse;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppService {

    private final MockApiIntegration integration;

    public MockApiResponse normalRequest() {
        return integration.getTestMessage();
    }

    public MockApiResponse errorRequestEscape() {
        return integration.getTestErrorEscape();
    }

    public MockApiResponse errorRequestRead() {
        return integration.getTestErrorRead();
    }

    public MockApiResponse timeOutRequest() {
        return integration.getTestTimeout(UUID.randomUUID().toString());
    }
}
