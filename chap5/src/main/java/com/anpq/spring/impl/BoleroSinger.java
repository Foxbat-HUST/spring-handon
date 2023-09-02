package com.anpq.spring.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anpq.spring.common.Singer;

public class BoleroSinger implements Singer {
  Logger logger = LoggerFactory.getLogger(BoleroSinger.class);

  @Override
  public void sing() {
    logger.info("bolero singer sing...");
  }

  @Override
  public void sing(String song) {
    logger.info("bolero singer sing a song...");
  }

  @Override
  public void dance() {
     logger.info("bolero singer dance");
  }

}
