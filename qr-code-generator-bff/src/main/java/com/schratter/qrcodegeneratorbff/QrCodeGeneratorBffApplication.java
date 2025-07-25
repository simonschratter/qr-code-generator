package com.schratter.qrcodegeneratorbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.schratter.qrcodegeneratorservice", "com.schratter.qrcodegeneratorbff"})
public class QrCodeGeneratorBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrCodeGeneratorBffApplication.class, args);
    }

}