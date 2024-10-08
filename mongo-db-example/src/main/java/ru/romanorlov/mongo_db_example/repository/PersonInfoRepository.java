package ru.romanorlov.mongo_db_example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.romanorlov.mongo_db_example.model.entity.PersonInfo;

import java.util.Optional;

public interface PersonInfoRepository extends MongoRepository<PersonInfo, String> {
    @Query("{name:'?0'}")
    Optional<PersonInfo> findById(String id);
}
