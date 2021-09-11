package com.boyang.landsense.log.controller;

import com.boyang.landsense.common.service.LogServ;
import com.boyang.landsense.common.vo.LogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/landsense")
public class LogController {
    @Autowired
    private LogServ logServ;
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/log")
    public List<LogVO> logVOList() {
        return logServ.getLogList();
    }
}
