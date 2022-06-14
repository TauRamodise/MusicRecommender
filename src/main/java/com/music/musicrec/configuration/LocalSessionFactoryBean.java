package com.music.musicrec.configuration;

import org.springframework.context.annotation.Bean;

public class LocalSessionFactoryBean {
    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {

        return new LocalSessionFactoryBean();
    }
}

