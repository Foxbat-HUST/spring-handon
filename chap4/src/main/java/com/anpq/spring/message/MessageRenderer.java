package com.anpq.spring.message;

public interface MessageRenderer {
  void setMessageProvider(MessageProvider provider);
  MessageProvider getMessageProvider();
  void render();
}
