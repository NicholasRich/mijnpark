package com.boyang.landsense.common.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.boyang.landsense.common.dto.CountDTO;
import com.boyang.landsense.common.service.LandSenseServ;
import com.boyang.landsense.common.vo.AvgVO;
import com.boyang.landsense.common.vo.CountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LandSenseServImpl implements LandSenseServ {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<CountVO> listSenseCount(String field) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("site_id", field)
                        .first("long_site").as("long_site")
                        .first("lat_site").as("lat_site")
                        .count().as("count"),
                Aggregation.match(Criteria.where("_id." + field).ne(null)),
                Aggregation.project("long_site", "lat_site", "count")
                        .and("_id.site_id").as("site_id")
                        .and("_id." + field).as("status"),
                Aggregation.sort(Sort.Direction.DESC, "site_id", "status"));
        List<CountDTO> countDTOList = mongoTemplate.aggregate(aggregation, "landSense", CountDTO.class).getMappedResults();
        List<CountVO> list = new ArrayList<>();
        for (int i = 0; i < countDTOList.size(); ) {
            CountDTO curr = countDTOList.get(i);
            CountVO countVO = new CountVO();
            BeanUtil.copyProperties(countDTOList.get(i), countVO);
            if (i < countDTOList.size() - 1 && curr.getSiteId().equals(countDTOList.get(i + 1).getSiteId())) {
                countVO.setTrueCount(curr.getCount());
                countVO.setFalseCount(countDTOList.get(i + 1).getCount());
                i += 2;
            } else {
                if (curr.getStatus()) {
                    countVO.setTrueCount(curr.getCount());
                } else {
                    countVO.setFalseCount(curr.getCount());
                }
                i += 1;
            }
            list.add(countVO);
        }
        return list;
    }

    @Override
    public List<AvgVO> listSenseAvg(String field) {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.group("site_id")
                .first("long_site").as("long_site")
                .first("lat_site").as("lat_site")
                .avg(field).as("avg"));
        List<AvgVO> landSenses = mongoTemplate.aggregate(aggregation, "landSense", AvgVO.class).getMappedResults();
        return landSenses;
    }

}
