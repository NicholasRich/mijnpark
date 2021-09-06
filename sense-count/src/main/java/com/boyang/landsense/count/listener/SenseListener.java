//package com.boyang.mujipark.sense.listener;
//
//import com.boyang.mujipark.common.service.LandSenseServ;
//import com.boyang.mujipark.common.vo.IndicatorVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class SenseListener {
//    @Autowired
//    private KafkaTemplate<String, List<IndicatorVo>> kafkaTemplate;
//    @Autowired
//    private LandSenseServ landSenseServ;
//
//
//    @KafkaListener(topics = "avg-indicator")
//    public void sensePosition(String indicator) {
//        System.out.println(indicator);
//        kafkaTemplate.send("avg-indicator-result", landSenseServ.listSiteIndicator(indicator));
//    }
//}
