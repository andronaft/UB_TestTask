package com.zuk.repository;

import com.zuk.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByFirstName(String firstName);
    List<User> findByLastName(String lastName);

}