package com.achooapi.achoo_api_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.achooapi.achoo_api_java"})
@EnableScheduling
@EnableAsync
@EnableJpaAuditing // Generated CreatedDate & LastModifiedDate
public class AchooApiJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchooApiJavaApplication.class, args);
    }

}
