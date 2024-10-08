package ru.romanorlov.mongo_db_example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.romanorlov.mongo_db_example.model.request.RequestPersonInfo;
import ru.romanorlov.mongo_db_example.service.ApplicationService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${app.name}/v1")
public class ApplicationController {

    private final ApplicationService service;

    @PostMapping(name = "/save")
    public ResponseEntity<String> save(@RequestBody RequestPersonInfo body) {
        service.create(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
