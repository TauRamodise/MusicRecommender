package com.music.musicrec;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class dbConnection {
  
  @Bean
  @ConfigurationProperties("app.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
}
