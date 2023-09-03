package com.anpq.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.anpq.spring.model.Adult;
import com.anpq.spring.model.Children;
import com.anpq.spring.service.Service;
import com.anpq.spring.util.IgnoreLog;
import com.anpq.spring.util.Log;

@Component
@Log
public class ServiceImplement implements Service{
  private static Logger logger = LoggerFactory.getLogger(ServiceImplement.class);

  @Override
  public String doJob(@IgnoreLog String input) {
    logger.info("do job: {}", input);
    return String.format("do job: %s", input);
  }

  @Override
  public Adult growUp(Children children) {
    return new Adult(children.getName(), children.getAge() + 18);
  }

}
