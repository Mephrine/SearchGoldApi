package kr.co.youngyoung.goldnara.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "kr.co.youngyoung.goldnara")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}