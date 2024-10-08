package ru.romanorlov.mongo_db_example.service;

import ru.romanorlov.mongo_db_example.model.request.RequestPersonInfo;

public interface ApplicationService {
    void create(RequestPersonInfo requestPersonInfo);
}
