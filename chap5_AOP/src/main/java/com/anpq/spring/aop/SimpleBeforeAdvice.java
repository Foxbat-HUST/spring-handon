package com.anpq.spring.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
  Logger logger = LoggerFactory.getLogger(SimpleBeforeAdvice.class);

  @Override
  public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
    logger.info("advice invoked...");
  }

}
