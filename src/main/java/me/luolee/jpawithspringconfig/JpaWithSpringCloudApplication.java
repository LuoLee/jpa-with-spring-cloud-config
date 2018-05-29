package me.luolee.jpawithspringconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JpaWithSpringCloudApplication {

    private static final Logger logger = LoggerFactory.getLogger(JpaWithSpringCloudApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaWithSpringCloudApplication.class, args);
    }

}
