package com.boyang.landsense.common.repo;

import com.boyang.landsense.common.entity.LandSense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LandSenseRepo extends MongoRepository<LandSense, String>, QuerydslPredicateExecutor<LandSense> {
}
