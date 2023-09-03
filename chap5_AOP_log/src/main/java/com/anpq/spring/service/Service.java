package com.anpq.spring.service;

import com.anpq.spring.model.Adult;
import com.anpq.spring.model.Children;

public interface Service {
  String doJob(String input);
  Adult growUp(Children children);
}
