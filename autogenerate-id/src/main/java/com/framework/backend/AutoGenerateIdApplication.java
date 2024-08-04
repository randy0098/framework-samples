package com.framework.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("**.mapper")
public class AutoGenerateIdApplication {
  public static void main(String[] args) {
    SpringApplication.run(AutoGenerateIdApplication.class, args);
  }
}
