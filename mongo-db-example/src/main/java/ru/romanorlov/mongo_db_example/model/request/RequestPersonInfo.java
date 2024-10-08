package ru.romanorlov.mongo_db_example.model.request;

public record RequestPersonInfo(String name,
                                String surname,
                                String gender,
                                String hobby) {
}
