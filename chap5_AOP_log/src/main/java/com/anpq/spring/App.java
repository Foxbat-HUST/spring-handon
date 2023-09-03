package com.anpq.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anpq.spring.service.Service;


public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Service service = ctx.getBean(Service.class);
        service.doJob("ahihihihi");
        ctx.close();
    }
}
