package com.muhammet.repository;

import com.muhammet.repository.entity.UserProfile;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserProfileRepository extends MongoRepository<UserProfile,String> {
}
