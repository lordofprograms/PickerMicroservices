package com.pickers.microservices.save.controller;

import com.pickers.microservices.save.model.LogModel;
import com.pickers.microservices.save.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogController {

    @AutoWired
    LogRepository repository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Iterable<LogModel> getAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String save(@RequestBody LogModel logModel) {
        repository.save(logModel);
        return logModel.getId();
    }

    @RequestMapping(method=RequestMethod.PUT, value = "/{id}")
    public LogModel update(@PathVariable String id, @RequestBody LogModel logModel) {
        LogModel log = repository.findOne(logModel);
        if(logModel.getLatitude() != null) {
            log.setLatitude(logModel.getLatitude());
        }
        if (logModel.getLongitude() != null) {
            log.setLatitude(logModel.getLongitude());
        }
        if (logModel.getHeight() != null) {
            log.setHeight(logModel.getHeight());
        }
        return log;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public String delete(@PathVariable String id) {
        LogModel logModel = repository.findOne(id);
        repository.delete(logModel);

        return "product deleted";
    }

}
