package com.run.dw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liqinghua
 */
@SpringBootApplication
// @RestController
public class DwApplication {
    private static final Logger logger = LoggerFactory.getLogger(DwApplication.class);

    public static void main(String[] args) {
        logger.info("This is a check message!");
        logger.warn("goo!");
        logger.error("this is a error message");

        SpringApplication.run(DwApplication.class, args);
    }
    // @RequestMapping(value = "/")
    public String hello() {
        return "Hello World from Tomcat";
    }

}
