package com.coding.demo0517;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.coding.demo0517.mapper")
@SpringBootApplication
public class Demo0517Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo0517Application.class, args);
    }

}
