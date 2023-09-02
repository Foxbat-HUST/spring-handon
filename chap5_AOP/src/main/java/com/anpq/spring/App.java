package com.anpq.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anpq.spring.common.Singer;
import com.anpq.spring.config.AopConfig;

public class App {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        Singer boleroSinge = ctx.getBean("singer", Singer.class);
        logger.info("call sing method");
        boleroSinge.sing();
        logger.info("call sing a song method");
        boleroSinge.sing("ahihi");
        logger.info("call dance method");
        boleroSinge.dance();
        ctx.close();
    }
}
