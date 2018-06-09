package com.zh.ssm.controller;

import com.zh.ssm.mapper.Student_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController
{
    @Autowired
    Student_DAO studentDao;
    @RequestMapping("/s")
    public Object s(){
       return studentDao.selectAll();
    }
}
