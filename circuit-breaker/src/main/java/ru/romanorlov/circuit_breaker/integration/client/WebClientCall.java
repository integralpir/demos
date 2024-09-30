package ru.romanorlov.circuit_breaker.integration.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;
import ru.romanorlov.circuit_breaker.exception.BadGatewayException;
import ru.romanorlov.circuit_breaker.exception.UnhandledException;
import ru.romanorlov.circuit_breaker.model.MockApiResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebClientCall {
    private final WebClient webClient;

    public Mono<MockApiResponse> callWebClient(String request) {
        return webClient
                .method(HttpMethod.GET)
                .uri("http://localhost:8090/mock_api/" + request, UriBuilder::build)
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> response
                                .bodyToMono(MockApiResponse.class)
                                .map(body -> {
                                    if ("READ".equals(body.status())) {
                                        throw new BadGatewayException(body.status(), body.message());
                                    } else {
                                        throw new UnhandledException(body.status(), body.message());
                                    }
                                })
                )
                .bodyToMono(MockApiResponse.class);
    }

    private Mono<? extends Throwable> handleError(ClientResponse clientResponse) {
        log.error("====---");

        MockApiResponse errorResponse = clientResponse
                .bodyToMono(MockApiResponse.class)
                .block();

        if (errorResponse != null && errorResponse.status() != null && errorResponse.status().equals("READ")) {
            return Mono.error(new BadGatewayException(errorResponse.status(), errorResponse.message()));
        }

        return Mono.error(Exception::new);
    }
}
