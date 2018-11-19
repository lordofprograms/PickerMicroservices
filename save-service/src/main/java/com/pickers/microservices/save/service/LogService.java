package com.pickers.microservices.save.service;

import com.pickers.microservices.save.dao.LogModelDao;
import com.pickers.microservices.save.dao.SequenceDao;
import com.pickers.microservices.save.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private LogModelDao logDao;

    public void add(LogModel logModel) {
        logModel.setId(sequenceDao.getNextSequenceId(LogModel.COLLECTION_NAME));
        logDao.save(logModel);
    }

    public void update(LogModel logModel) {
        logDao.save(logModel);
    }

    public LogModel get(Long id) {
        return logDao.get(id);
    }

    public List<LogModel> getAll() {
        return logDao.getAll();
    }

    public void remove(Long id) {
        logDao.remove(id);
    }

}
