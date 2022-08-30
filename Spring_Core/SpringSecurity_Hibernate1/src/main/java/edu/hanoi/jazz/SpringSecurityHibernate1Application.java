package edu.hanoi.jazz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config.xml")
public class SpringSecurityHibernate1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityHibernate1Application.class, args);
    }

}
