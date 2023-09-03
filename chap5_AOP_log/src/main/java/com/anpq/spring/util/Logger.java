package com.anpq.spring.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
  private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Logger.class);


  @Pointcut("execution(@com.anpq.spring.util.Log * *.*(..))")
  public void methodLevelLog(){
  }


  @Pointcut("within(@com.anpq.spring.util.Log *)")
  public void classLevelLog(){

  }

  @Around("classLevelLog() or methodLevelLog()")
  public Object doLog(ProceedingJoinPoint jPoint) throws Throwable{
    //TODO: implement log here
    Object returnObject = jPoint.proceed();

    // TODO implement log here
    return returnObject;
  }

}
