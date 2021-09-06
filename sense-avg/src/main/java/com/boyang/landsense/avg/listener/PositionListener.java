//package com.boyang.mujipark.position.listener;
//
//import cn.hutool.core.util.IdUtil;
//import com.boyang.mujipark.common.service.LandSenseServ;
//import com.boyang.mujipark.common.vo.PositionVo;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class PositionListener {
//    @Autowired
//    private KafkaTemplate<String, List<PositionVo>> kafkaTemplate;
//    @Autowired
//    private LandSenseServ landSenseServ;
//
//    @KafkaListener(topics = "position")
//    public void positionListener(ConsumerRecord<String, String> record) {
//        kafkaTemplate.send("position-result", IdUtil.fastSimpleUUID(), landSenseServ.listSitePosition());
//    }
//}
