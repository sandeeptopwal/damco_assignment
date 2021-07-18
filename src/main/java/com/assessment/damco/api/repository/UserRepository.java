package com.assessment.damco.api.repository;

import com.assessment.damco.api.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
}
