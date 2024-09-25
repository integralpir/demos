package ru.romanorlov.circuit_breaker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.romanorlov.circuit_breaker.model.MockApiResponse;
import ru.romanorlov.circuit_breaker.service.AppService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${app.name}")
public class CBAppController {

    private final AppService service;

    @GetMapping(value = "testMessage")
    public ResponseEntity<MockApiResponse> getTestMessage() {
        return new ResponseEntity<>(new MockApiResponse(service.normalRequest()), HttpStatus.OK);
    }

    @GetMapping(value = "testError")
    public ResponseEntity<MockApiResponse> getTestError() {
        return new ResponseEntity<>(new MockApiResponse(service.errorRequest()), HttpStatus.OK);
    }

    @GetMapping(value = "testTimeout")
    public ResponseEntity<MockApiResponse> getTestTimeout() {
        return new ResponseEntity<>(new MockApiResponse(service.timeOutRequest()), HttpStatus.OK);
    }
}
