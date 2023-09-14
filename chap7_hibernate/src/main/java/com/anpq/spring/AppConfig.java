package com.anpq.spring;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.anpq.spring.entity.AbstractEntity;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
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
      HikariConfig config = new HikariConfig();
      config.setDriverClassName(this.driverClassName);
      config.setUsername(this.userName);
      config.setPassword(this.password);
      config.setJdbcUrl(this.url);
      HikariDataSource dataSource = new HikariDataSource(config);
      dataSource.setMaximumPoolSize(25);
      return dataSource;
    } catch (Exception e) {
      logger.error("unable to create datasource", e);
      return null;
    }
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
    try {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dataSource);

      // set entities base package
      Class<AbstractEntity> abstractEntity = AbstractEntity.class;
      sessionFactory.setPackagesToScan(abstractEntity.getPackageName());

      // load and config hibernate properties
      Resource resource = new ClassPathResource("./hibernate.properties");
      Properties hibernateProps = PropertiesLoaderUtils.loadProperties(resource);
      sessionFactory.setHibernateProperties(hibernateProps);

      return sessionFactory;
    } catch (IOException e) {
      logger.error("unable to load hibernate.properties", e);
      return null;
    }
  }

  @Bean
  public PlatformTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory){
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory.getObject());
    return transactionManager;
  }
}
