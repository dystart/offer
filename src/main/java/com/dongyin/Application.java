package com.dongyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author dystart
 * @create 2022-04-06 20:27
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Configuration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
