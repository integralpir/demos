package ru.romanorlov.mongo_db_example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.romanorlov.mongo_db_example.model.entity.PersonInfo;
import ru.romanorlov.mongo_db_example.model.request.RequestPersonInfo;
import ru.romanorlov.mongo_db_example.repository.PersonInfoRepository;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final PersonInfoRepository repository;

    @Override
    public void create(RequestPersonInfo requestPersonInfo) {
        repository.save(new PersonInfo(
                UUID.randomUUID().toString(),
                requestPersonInfo.name(),
                requestPersonInfo.surname(),
                new PersonInfo.AdditionalInfo(
                        requestPersonInfo.hobby(),
                        requestPersonInfo.gender())
        ));
    }
}
