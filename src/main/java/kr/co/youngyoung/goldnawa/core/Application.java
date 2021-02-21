package kr.co.youngyoung.goldnawa.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "kr.co.youngyoung.goldnawa")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}