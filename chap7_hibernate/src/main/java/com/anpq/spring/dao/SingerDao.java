package com.anpq.spring.dao;

import java.util.List;

import com.anpq.spring.entity.Singer;
public interface SingerDao {
  public static String FIND_BY_ID = "singer.findById";
  List<Singer> findAll();
  List<Singer> findAllWithAlbum();
  Singer findById(Long id);
  Singer save(Singer singer);
  void delete(Singer singer);
}
