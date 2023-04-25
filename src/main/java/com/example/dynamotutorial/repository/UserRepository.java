package com.example.dynamotutorial.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import com.example.dynamotutorial.model.User;

@EnableScan
public interface UserRepository extends CrudRepository<User, String>{

}
