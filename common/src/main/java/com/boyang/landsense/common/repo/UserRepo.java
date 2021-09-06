package com.boyang.landsense.common.repo;

import com.boyang.landsense.common.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    User findUserByUsername(String username);
}
