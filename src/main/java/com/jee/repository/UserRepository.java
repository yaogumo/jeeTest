package com.jee.repository;

import com.jee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {//Spring Data JPA会根据方法名自动生成对应的查询语句

  Optional<User> findByUsernameAndPassword(String username,String password);
}