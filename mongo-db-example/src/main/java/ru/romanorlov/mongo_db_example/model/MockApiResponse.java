package ru.romanorlov.mongo_db_example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("messages")
public class MockApiResponse {
    @Id
    private String id;
    private String message;
}
