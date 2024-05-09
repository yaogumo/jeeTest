package com.jee.controller;


import com.jee.entity.User;
import com.jee.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Controller
@Slf4j
public class LoginController {

  @Autowired
  UserService service;

  @RequestMapping("/login_page")//匹配所有请求
  public String login_page() {//返回值为String，指向文件路径
    return "login";//自动去寻找login页面
  }

  @PostMapping("/login")//接收登录参数
  public String login(String username, String password, Model model) {//类似map，把值放到model里，用model传到页面
    log.debug("{},{}", username, password);
    //判断数据库中是否存在该账户
    boolean isSuc = service.checkLogin(username, password);
    if (isSuc) {
      model.addAttribute("username", username);
      model.addAttribute("password", password);
      return "/login_suc";
    } else {
      return "/login";

    }
  }

  /**
   * 传递对象
   *
   * @param user
   * @return
   */
  @RequestMapping("/login_page_obj")
  public String login_page_object(User user) {
    return "login_page_obj";
  }

  @PostMapping("login_obj")//把值传给页面
  public String login_obj(User user, Model model) {//model会自动增加值
    boolean isSuc = service.checkLogin(user.getUsername(), user.getPassword());//判断账户是否一致
    if (isSuc) {
      return "login_obj_suc";
    } else {
      return "login_page_obj";
    }
  }

  @PostMapping("/login_json")
  @ResponseBody//返回值转换为json格式
  public Map loginJson(@RequestBody User user) {//接收json格式的传入值
    //查询数据库，返回给前端json格式数据
    boolean isSuc = service.checkLogin(user.getUsername(), user.getPassword());
    if (isSuc) {
      return Map.of("err_code", 0, "msg", "suc");
    } else {
      return Map.of("err_code", 1, "msg", "用户名或密码错误");
    }
  }

  @RequestMapping("/complex_input")
  public String complex_input(){
    return "complex";
  }


  @RequestMapping("/complex")//接收complex页面的发送的请求
  @ResponseBody
  public String complex(int[] data, @RequestParam ArrayList list,
                        @RequestParam Locale locale, LocalDate date){//@RequestParam表示是从网页里面传来的参数,指明是表单传来的的地区
    log.debug("int[] {}",Arrays.toString(data));
    log.debug("list {}",list);
    log.debug("locale {}",locale);
    log.debug("date {}",date);
    return "suc";

  }


}













