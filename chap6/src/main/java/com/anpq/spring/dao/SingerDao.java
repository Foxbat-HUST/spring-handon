package com.anpq.spring.dao;

import java.util.List;

import com.anpq.spring.entity.Singer;

public interface SingerDao {
  String findNameById(Long id);
  List<Singer> findAll();
}
