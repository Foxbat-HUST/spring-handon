package com.anpq.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anpq.spring.config.PropertySourcesCfg;
import com.anpq.spring.message.MessageRenderer;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertySourcesCfg.class);
        MessageRenderer render = context.getBean("messageRenderer", MessageRenderer.class);
        render.render();
        context.close();
    }
}
