package com.boyang.landsense.common.service.impl;

import com.boyang.landsense.common.entity.Log;
import com.boyang.landsense.common.repo.LogRepo;
import com.boyang.landsense.common.service.LogServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServImpl implements LogServ {
    @Autowired
    private LogRepo logRepo;

    @Override
    public void saveLog(Log log) {
        logRepo.save(log);
    }
}
