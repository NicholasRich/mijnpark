package com.boyang.landsense.count.controller;

import com.boyang.landsense.common.entity.Log;
import com.boyang.landsense.common.service.LandSenseServ;
import com.boyang.landsense.common.vo.CountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/landsense")
@CrossOrigin
public class SenseCountController {
    @Autowired
    private LandSenseServ landSenseServ;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/count/{field}")
    public List<CountVO> listIndicatorVo(@PathVariable("field") String field) {
        Log log = new Log();
        log.setQueryTime(new Date());
        log.setQueryField(field);
        kafkaTemplate.send("log", log);
        return landSenseServ.listSenseCount(field);
    }
}
