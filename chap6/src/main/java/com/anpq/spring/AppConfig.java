package com.anpq.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfig {
  private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
  @Value("${jdbc.driverClassName}")
  private String driverClassName;

  @Value("${jdbc.url}")
  private String url;

  @Value("${jdbc.username}")
  private String userName;

  @Value("${jdbc.password}")
  private String password;

  @Bean(destroyMethod = "close")
  public DataSource dataSource() {
    try {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(this.driverClassName);
      dataSource.setUrl(this.url);
      dataSource.setUsername(this.userName);
      dataSource.setPassword(this.password);

      return dataSource;
    } catch (Exception e) {
      logger.error("unable to create datasource", e);
      return null;
    }
  }

  @Bean
  public JdbcTemplate jdbcTemplate( DataSource dataSource){
    return new JdbcTemplate(dataSource);
  }
}
