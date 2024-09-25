package ru.romanorlov.circuit_breaker.integration;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.romanorlov.circuit_breaker.integration.client.WebClientCall;
import ru.romanorlov.circuit_breaker.model.MockApiResponse;

import java.util.Arrays;

@Slf4j
@Component
@RequiredArgsConstructor
public class MockApiIntegration {
    private final WebClientCall webClientCall;

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallback")
    public MockApiResponse getTestMessage() {
        log.info("call integration normal");
        return webClientCall
                .callWebClient("testMessage")
                .block();
    }

    @Retry(name = "myRetry", fallbackMethod = "fallbackRetry")
    //@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallback")
    public MockApiResponse getTestError() {
        log.info("call integration error");
        return webClientCall
                .callWebClient("testError")
                .block();
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackTimeout")
    public MockApiResponse getTestTimeout(String uuid) {
        log.info("call integration timeout: {}", uuid);
        return webClientCall
                .callWebClient("testTimeout")
                .block();
    }

    private MockApiResponse fallbackRetry(Exception ex) {
        log.error("fallback retry, {}", ex.getMessage());

        return new MockApiResponse("ERROR MESSAGE RETRY");
    }

    private MockApiResponse fallbackTimeout(String uuid, Exception ex) {
        log.error("fallback timeout: {}, {}",  uuid, ex.getMessage());

        return new MockApiResponse("ERROR MESSAGE RETRY");
    }

    private MockApiResponse fallback(Exception ex) {
        log.error("fallback method, {}", ex.getMessage());

        return new MockApiResponse("ERROR MESSAGE");
    }
}
