package com.zh.ssm;

import com.zh.ssm.config.AppConfig;
import com.zh.ssm.mapper.Student_DAO;
import com.zh.ssm.service.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class Main {
//    @Autowired
//   static Student_DAO studentDao;
    public static void main(String[] args) {
      //  ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("student.xml");
//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//        Student_DAO studentDao=context.getBean(Student_DAO.class);
//        studentDao.selectAll();
        ApplicationContext context=new FileSystemXmlApplicationContext("config.xml");
        Timer timer= (Timer) context.getBean("logProxy");
        timer.doAuditing("1");
    }
}
