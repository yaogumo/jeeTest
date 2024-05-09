package com.jee.service;

import com.jee.entity.User;
import com.jee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  UserRepository repository;


  public boolean checkLogin(String username,String password){
    String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));//md5加密后的密码与数据库中密码比对
    Optional<User> res= repository.findByUsernameAndPassword(username,md5Pass);
    return res.isPresent();//判断是否出现

  }

}
