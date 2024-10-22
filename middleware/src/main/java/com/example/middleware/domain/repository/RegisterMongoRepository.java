package com.example.middleware.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.middleware.domain.entity.RegisterDocument;

@Repository
public interface RegisterMongoRepository extends ReactiveMongoRepository<RegisterDocument, String>{

}
