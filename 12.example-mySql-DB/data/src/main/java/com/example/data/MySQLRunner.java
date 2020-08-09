package com.example.data;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MySQLRunner implements ApplicationRunner {

  @Autowired
  DataSource dataSource;
  
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    try(Connection connection = dataSource.getConnection()) {
      String url = connection.getMetaData().getURL();
      String userName = connection.getMetaData().getUserName();

      System.out.println(url);
      System.out.println(userName);

      String sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
      java.sql.Statement statement = connection.createStatement();
      statement.executeUpdate(sql);
    }

    jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'kiwoon')");
  }

}