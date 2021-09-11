package com.boyang.landsense.common.service.impl;

import com.boyang.landsense.common.entity.Log;
import com.boyang.landsense.common.repo.LogRepo;
import com.boyang.landsense.common.service.LogServ;
import com.boyang.landsense.common.vo.LogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServImpl implements LogServ {
    @Autowired
    private LogRepo logRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveLog(Log log) {
        logRepo.save(log);
    }

    @Override
    public List<LogVO> getLogList() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.group("query_field")
                        .count().as("count")
                        .first("query_field").as("query_field"),
                Aggregation.sort(Sort.Direction.DESC, "count"));
        AggregationResults<LogVO> log = mongoTemplate.aggregate(aggregation, "log", LogVO.class);
        return log.getMappedResults();
    }
}
