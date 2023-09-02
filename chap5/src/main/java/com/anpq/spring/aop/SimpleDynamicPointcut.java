package com.anpq.spring.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.anpq.spring.impl.BoleroSinger;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
  Logger logger = LoggerFactory.getLogger(SimpleDynamicPointcut.class);

  public ClassFilter getClassFilter(){
    return cls -> (cls == BoleroSinger.class);
  }

  public boolean matches(Method method, Class<?> targetClass){
    logger.info("static check for {}", method.getName());
    return false;
  }

  @Override
  public boolean matches(Method method, Class<?> targetClass, Object... args) {
    logger.info("dynamic check for {}", method.getName());
    return args.length != 0;
  }

}
