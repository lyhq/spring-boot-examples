package com.lyhq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyhq.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    Long deleteById(Long id);
}