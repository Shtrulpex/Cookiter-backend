package ru.samsungitschool.sibirtsev.cookiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CookiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookiterApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }
}
