package com.voicerecorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@SpringBootConfiguration
public class App {

    @Autowired
    public JdbcTemplate template;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}




