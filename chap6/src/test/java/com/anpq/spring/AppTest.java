package com.anpq.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.anpq.spring.dao.SingerDao;

@SpringJUnitConfig(AppConfig.class)
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
@Sql({ "classpath:test_db/drop_schema.sql", "classpath:test_db/create_schema.sql" })
public class AppTest {

  @Autowired
  @Qualifier("singerDaoJdbcTemplateImpl")
  private SingerDao singerDao;

  @Test
  @Sql({"classpath:test_db/init_data.sql"})
  public void testProvider() {
    assertNotNull(singerDao);
  }
}
