package com.anpq.spring.config;

import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import com.anpq.spring.aop.SimpleBeforeAdvice;
import com.anpq.spring.common.Singer;
import com.anpq.spring.impl.BoleroSinger;

public class AopConfig implements BeanFactoryAware{
  Logger logger = LoggerFactory.getLogger(AopConfig.class);
  private BeanFactory beanFactory;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }

  @Bean
  @Qualifier("singer")
  public Singer singer(){
    logger.info("create singer bean...");
    return new BoleroSinger();
  }

  @Bean
  public Advice advice(){
    return new SimpleBeforeAdvice();
  }

  // this version of proxySingle() use ProxyFactoryBean
  @Bean
  @Qualifier("proxySinger")
  public Singer proxySinger(@Qualifier("singer") Singer singer){
    ProxyFactoryBean proxyFactory = new ProxyFactoryBean();
    proxyFactory.setTarget(singer);
    proxyFactory.setBeanFactory(beanFactory);
    proxyFactory.setInterceptorNames("advice");

    return (Singer)proxyFactory.getObject();
  }

  // this version of proxySinge() use ProxyFactory
  // @Bean
  // @Qualifier("proxySinger")
  // public Singer proxySinger(@Qualifier("singer") Singer singer, Advice advice ){
  //   ProxyFactory proxyFactory = new ProxyFactory();
  //   proxyFactory.setTarget(singer);
  //   proxyFactory.addAdvice(advice);

  //   return (Singer)proxyFactory.getProxy();
  // }

}
