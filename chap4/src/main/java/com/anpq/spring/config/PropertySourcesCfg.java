package com.anpq.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.anpq.spring.message.MessageProvider;
import com.anpq.spring.message.MessageRenderer;
import com.anpq.spring.message.impl.ConfigurableMessageProvider;
import com.anpq.spring.message.impl.StandardOutMessageRenderer;
import com.anpq.spring.message.impl.TestProfileMessageProvider;

@Configuration
@PropertySource(value = "classpath:message.properties")
public class PropertySourcesCfg {
  @Autowired
  private Environment env;

  @Bean
  @Profile("prod")
  public MessageProvider messageProvider(){
    return new ConfigurableMessageProvider(env.getProperty( "message"));
  }

  @Bean
  @Profile("test")
  public MessageProvider profileMessageProvider(){
    return new TestProfileMessageProvider("test profile");
  }

  @Bean
  public MessageRenderer messageRenderer(MessageProvider provider){
    MessageRenderer renderer = new StandardOutMessageRenderer();
    renderer.setMessageProvider(provider);
    return renderer;
  }
}
