package org.example.service;

import org.example.AppConfig;
import org.example.ds.CurrencyType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        AlgoCurrencyService algoCurrencyService = context.getBean(AlgoCurrencyService.class);
        algoCurrencyService.changeRateTo(100, CurrencyType.US);
        algoCurrencyService.algo();
        algoCurrencyService.test();
    }
}
