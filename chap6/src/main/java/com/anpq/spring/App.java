package com.anpq.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anpq.spring.dao.SingerDao;
import com.anpq.spring.entity.Singer;

public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingerDao dao = ctx.getBean("singerDaoImpl", SingerDao.class);
        String name = dao.findNameById(1L);
        logger.info("name : {}", name);
        dao = ctx.getBean("singerDaoJdbcTemplateImpl", SingerDao.class);
        name = dao.findNameById(1L);
        logger.info("name : {}", name);
        List<Singer> singers = dao.findAll();
        logger.info("singers list: {}", singers);
        ctx.close();
    }
}
