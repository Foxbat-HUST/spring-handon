package com.anpq.spring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.anpq.spring.dao.SingerDao;
import com.anpq.spring.entity.Singer;

@Component
@Qualifier("singerDaoImpl")
public class SingerDaoImpl implements SingerDao {
  private static Logger logger = LoggerFactory.getLogger(SingerDaoImpl.class);

  @Autowired
  private DataSource dataSource;

  @Override
  public String findNameById(Long id) {
    try(Connection connection = this.dataSource.getConnection()){
    final String sql = "select first_name, last_name from SINGER where id = ? ;";
     PreparedStatement stm = connection.prepareStatement(sql);
     stm.setLong(1, id);
     ResultSet results =  stm.executeQuery();
     while(results.next()){
      return String.format("%s %s", results.getString("first_name"),
      results.getString("last_name"));
     }
    }catch(SQLException e){
      logger.error("unable to get name", e);
    }
     return "";
  }

  @Override
  public List<Singer> findAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }
}
