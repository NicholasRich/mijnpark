package com.boyang.landsense.common.repo;

import com.boyang.landsense.common.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends MongoRepository<Log, String>/*, QuerydslPredicateExecutor<Log>*/ {
}
