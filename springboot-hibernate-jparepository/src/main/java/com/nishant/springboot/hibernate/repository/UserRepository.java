package com.nishant.springboot.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.springboot.hibernate.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
