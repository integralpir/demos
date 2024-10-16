package ru.romanorlov.mock_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.romanorlov.mock_api.model.MockApiRequest;

@RestController
@RequestMapping(value = "${app.name}")
public class MockApiController {

    @GetMapping(value = "testMessage")
    public ResponseEntity<MockApiRequest> getTestMessage() {
        return new ResponseEntity<>(new MockApiRequest("READ", "TEST MESSAGE"), HttpStatus.OK);
    }

    @GetMapping(value = "testErrorRead")
    public ResponseEntity<MockApiRequest> getErrorRead() {
        return new ResponseEntity<>(new MockApiRequest("READ", "ERROR READ"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "testErrorEscape")
    public ResponseEntity<MockApiRequest> getErrorEscape() {
        return new ResponseEntity<>(new MockApiRequest("ESCAPE", "ERROR ESCAPE"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "testTimeout")
    public ResponseEntity<MockApiRequest> getTimeout() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(new MockApiRequest("ESCAPE", "TIMEOUT"), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
