package com.boyang.landsense.count.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.boyang.landsense.common.entity.Log;
import com.boyang.landsense.common.service.LandSenseServ;
import com.boyang.landsense.common.vo.CountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

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
        ThreadUtil.execAsync(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Log log = new Log();
                log.setQueryTime(new Date());
                log.setQueryField(field);
                kafkaTemplate.send("log", log);
                return null;
            }
        });
        return landSenseServ.listSenseCount(field);
    }
}
