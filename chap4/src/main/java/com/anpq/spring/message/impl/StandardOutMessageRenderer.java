package com.anpq.spring.message.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anpq.spring.message.MessageProvider;
import com.anpq.spring.message.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {
  private static Logger logger = LoggerFactory.getLogger(StandardOutMessageRenderer.class);
  private MessageProvider provider;

  @Override
  public void setMessageProvider(MessageProvider provider) {
    this.provider = provider;
  }

  @Override
  public MessageProvider getMessageProvider() {
    return this.provider;
  }

  @Override
  public void render() {
    logger.info(provider.getMessage());
  }

}
