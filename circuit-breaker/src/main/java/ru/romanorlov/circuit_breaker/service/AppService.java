package ru.romanorlov.circuit_breaker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romanorlov.circuit_breaker.integration.MockApiIntegration;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppService {

    private final MockApiIntegration integration;

    public String normalRequest() {
        return integration.getTestMessage().message();
    }

    public String errorRequest() {
        return integration.getTestError().message();
    }

    public String timeOutRequest() {
        return integration.getTestTimeout(UUID.randomUUID().toString()).message();
    }
}
