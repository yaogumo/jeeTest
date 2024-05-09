package com.jee.repository;

import com.jee.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/*@SpringBootTest
class UserRepositoryTest {
  @Autowired
  UserRepository userRepository;
  @Test
  void save(){
    User user = new User("zhang","123456");
    String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));//md5加密
    user.setPassword(md5Pass);
    userRepository.save(user);

  }

}*/