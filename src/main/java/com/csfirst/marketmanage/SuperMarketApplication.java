package com.csfirst.marketmanage;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@ServletComponentScan
public class SuperMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperMarketApplication.class, args);
        Logger.getAnonymousLogger().log(Level.INFO,"项目启动成功~~~~");
    }

}
