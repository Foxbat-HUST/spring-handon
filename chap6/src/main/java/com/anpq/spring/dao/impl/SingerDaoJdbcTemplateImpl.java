package com.anpq.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.anpq.spring.dao.SingerDao;
import com.anpq.spring.entity.Singer;

@Component
@Qualifier("singerDaoJdbcTemplateImpl")
public class SingerDaoJdbcTemplateImpl implements SingerDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public String findNameById(Long id) {
    final String sql = "select CONCAT(first_name , ' ' , last_name) from SINGER where id = ?";
    return jdbcTemplate.queryForObject(sql, String.class, id);
  }

  @Override
  public List<Singer> findAll() {
    final String sql = "select * from SINGER";
    RowMapper<Singer> mapper = (rs, rowNum) -> new Singer(
      rs.getLong("id"),
      rs.getString("first_name"),
      rs.getString("last_name"),
      rs.getDate("birth_date").toLocalDate());

    return jdbcTemplate.query(sql, mapper);
  }

}
