package com.jee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/i18n")
public class I18NController {

  @Autowired
  MessageSource messageSource;
  @RequestMapping("/demo")
  public String demo(Model model){
    String res = messageSource.getMessage("wel.msg", null, null);
    System.out.println(res);
    model.addAttribute("username","zhangsan");
    model.addAttribute("password","123456");
    return "i18n_res";

  }

}
