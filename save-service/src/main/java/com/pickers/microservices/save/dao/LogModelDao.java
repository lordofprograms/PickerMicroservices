package com.pickers.microservices.save.dao;

import com.pickers.microservices.save.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogModelDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(LogModel logModel) {
        mongoOperations.save(logModel);
    }

    public LogModel get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), LogModel.class);
    }

    public List<LogModel> getAll() {
        return mongoOperations.findAll(LogModel.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), LogModel.class);
    }

}
