package com.boyang.landsense.log.listener;

import com.boyang.landsense.common.entity.Log;
import com.boyang.landsense.common.service.LogServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LogListener {
    @Autowired
    private LogServ logServ;

    @KafkaListener(topics = {"log"})
    public void logListener(Log log) {
        Log log1 = log;
//        BeanUtil.fillBeanWithMap(record.value(), log, true);
        logServ.saveLog(log1);
    }
}
