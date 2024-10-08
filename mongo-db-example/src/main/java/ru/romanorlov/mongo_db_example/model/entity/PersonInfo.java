package ru.romanorlov.mongo_db_example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("form")
public class PersonInfo {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private AdditionalInfo additionalInfo;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdditionalInfo {
        private String hobby;
        private String gender;
    }
}
