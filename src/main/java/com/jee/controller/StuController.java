package com.jee.controller;

import com.jee.entity.Stu;
import com.jee.repository.StuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stu")
public class StuController {
  @Autowired
  StuRepository repository;

  /**
   * 显示所有学生
   * @return
   */
  @RequestMapping("/list")
  @ResponseBody//把结果转换为json格式
  public List<Stu> list(){
    return repository.findAll();
  }

  @RequestMapping("/{id}")
  @ResponseBody
  public Stu findById(@PathVariable long id){
    return repository.findById(id).orElseThrow();
  }

  /**
   * 分页
   * @return
   */
  @RequestMapping("/page")
  public String page(@PageableDefault(size = 2,page = 0)Pageable pageable, Model model){
    Page<Stu> res = repository.findAll(pageable);
    model.addAttribute("stus",res);
    return "/stu_list";
  }

}
