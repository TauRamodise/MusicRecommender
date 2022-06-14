package com.music.musicrec.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .url("jdbc:sqlserver://clouddb.c554t2pimfma.af-south-1.rds.amazonaws.com;databaseName=Artists_DB;encrypt=true;trustServerCertificate=true;")
                .username("admin")
                .password("gjc3CD5eHq9Z8cs")
                .build();
    }
}
