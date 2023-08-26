package com.anpq.spring.message.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
  @Value("${user.home}")
  private String appHome;

  public void printf(){
    System.out.println(this.appHome);
  }
}
