package ru.romanorlov.mongo_db_example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.romanorlov.mongo_db_example.model.MockApiResponse;

public interface MessagesRepository extends MongoRepository<MockApiResponse, String> {

}
