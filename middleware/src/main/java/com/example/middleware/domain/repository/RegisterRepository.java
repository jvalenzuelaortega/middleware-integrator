package com.example.middleware.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.middleware.domain.entity.RegisterEntity;

@Repository	
public interface RegisterRepository extends JpaRepository<RegisterEntity, Long> {

}
