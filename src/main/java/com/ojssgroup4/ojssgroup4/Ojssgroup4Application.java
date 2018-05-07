package com.ojssgroup4.ojssgroup4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Ojssgroup4Application {

    @RequestMapping("/")
    @ResponseBody

    public String test() {
        return "Spring is bullshit!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Ojssgroup4Application.class, args);
    }
}
