package com.anpq.spring.message.impl;

import org.springframework.beans.factory.annotation.Value;

import com.anpq.spring.message.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider{
  private String message;
  public ConfigurableMessageProvider(@Value("Configurable message") String message){
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }

}
