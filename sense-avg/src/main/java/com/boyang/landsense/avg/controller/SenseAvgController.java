package com.boyang.landsense.avg.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.boyang.landsense.common.entity.Log;
import com.boyang.landsense.common.service.LandSenseServ;
import com.boyang.landsense.common.vo.AvgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@CrossOrigin
@RequestMapping("/landsense")
public class SenseAvgController {
    @Autowired
    private LandSenseServ landSenseServ;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/avg/{field}")
    public List<AvgVO> listSitePosition(@PathVariable("field") String field) {
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
        return landSenseServ.listSenseAvg(field);
    }
}
