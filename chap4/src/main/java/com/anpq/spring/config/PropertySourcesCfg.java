package com.anpq.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.anpq.spring.message.MessageProvider;
import com.anpq.spring.message.MessageRenderer;
import com.anpq.spring.message.impl.ConfigurableMessageProvider;
import com.anpq.spring.message.impl.StandardOutMessageRenderer;

@Configuration
@PropertySource(value = "classpath:message.properties")
public class PropertySourcesCfg {
  @Autowired
  private Environment env;

  @Bean
  public MessageProvider messageProvider(){
    return new ConfigurableMessageProvider(env.getProperty( "message"));
  }

  @Bean
  public MessageRenderer messageRenderer(){
    MessageRenderer renderer = new StandardOutMessageRenderer();
    renderer.setMessageProvider(messageProvider());
    return renderer;
  }
}
