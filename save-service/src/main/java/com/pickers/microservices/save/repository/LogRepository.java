package com.pickers.microservices.save.repository;

import org.springframework.data.repository.CrudRepository;
import com.pickers.microservices.save.model.LogModel;

public class LogRepository extends CrudRepository<LogModel, String> {

    @Override
    LogModel findOne(String id);

    @Override
    void delete(LogModel deleted);

}
