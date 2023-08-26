package com.anpq.spring.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.env.StandardEnvironment;

public class ApplicationPropertiesConfiguration extends StandardEnvironment {
  @Override
  public Map<String, Object> getSystemEnvironment() {
    return new HashMap<>();
  }

  @Override
  public Map<String, Object> getSystemProperties() {
    return new HashMap<>();
  }
}
