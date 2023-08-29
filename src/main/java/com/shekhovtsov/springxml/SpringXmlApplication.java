package com.shekhovtsov.springxml;


import com.shekhovtsov.springxml.Repository.QuestionRepositoryImpl;
import com.shekhovtsov.springxml.Service.QuestionServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionRepositoryImpl repository = context.getBean("repository", QuestionRepositoryImpl.class);
        QuestionServiceImpl printer = context.getBean("printer", QuestionServiceImpl.class);
        repository.loadCsv();
        printer.print();
        context.close();
    }

}
