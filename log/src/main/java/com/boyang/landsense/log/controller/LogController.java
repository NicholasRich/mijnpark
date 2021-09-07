package com.boyang.landsense.log.controller;

import cn.hutool.core.collection.CollUtil;
import com.boyang.landsense.common.vo.AvgVO;
import com.boyang.landsense.common.vo.CountVO;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class LogController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaProperties kafkaProperties;

    @GetMapping("/landsense/position")
    public List<CountVO> all() {
        kafkaTemplate.send("position", "position");
        KafkaConsumer<String, List<CountVO>> consumer = new KafkaConsumer<>(kafkaProperties.buildConsumerProperties());
        consumer.subscribe(CollUtil.newArrayList("position-result"));
        for (int i = 0; i < 15; i++) {
            ConsumerRecords<String, List<CountVO>> poll = consumer.poll(100);
            if (poll.iterator().hasNext()) {
                consumer.close();
                return poll.iterator().next().value();
            }
        }
        consumer.close();
        return null;
    }

    @GetMapping("/landsense/avg/{indicator}")
    public List<AvgVO> avgindicator(@PathVariable("indicator") String indicator) {
        kafkaTemplate.send("avg-indicator", indicator);
        KafkaConsumer<String, List<AvgVO>> consumer = new KafkaConsumer<>(kafkaProperties.buildConsumerProperties());
        consumer.subscribe(CollUtil.newArrayList("avg-indicator-result"));
        for (int i = 0; i < 15; i++) {
            ConsumerRecords<String, List<AvgVO>> poll = consumer.poll(100);
            if (poll.iterator().hasNext()) {
                consumer.commitSync();
                consumer.close();
                return poll.iterator().next().value();
            }
        }
        consumer.close();
        return null;
    }

}
