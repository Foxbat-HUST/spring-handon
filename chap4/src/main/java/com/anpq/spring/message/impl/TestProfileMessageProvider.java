package com.anpq.spring.message.impl;

import org.springframework.beans.factory.annotation.Value;

import com.anpq.spring.message.MessageProvider;

public class TestProfileMessageProvider implements MessageProvider{
  private String message;
  public TestProfileMessageProvider(@Value("TestProfileMessageProvider") String message){
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }

}
