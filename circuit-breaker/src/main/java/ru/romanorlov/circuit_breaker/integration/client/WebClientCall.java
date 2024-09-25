package ru.romanorlov.circuit_breaker.integration.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;
import ru.romanorlov.circuit_breaker.model.MockApiResponse;

@Component
@RequiredArgsConstructor
public class WebClientCall {
    private final WebClient webClient;

    public Mono<MockApiResponse> callWebClient(String request) {
        return webClient
                .method(HttpMethod.GET)
                .uri("http://localhost:8090/mock_api/" + request, UriBuilder::build)
                .retrieve()
                .bodyToMono(MockApiResponse.class);
    }
}
