package org.example;

import org.example.ds.CurrencyType;
import org.example.service.AlgoCurrencyService;
import org.example.service.CurrencyService;
import org.example.service.MyCurrencyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        AlgoCurrencyService algoCurrencyService = context.getBean(AlgoCurrencyService.class);
        CurrencyService currencyService = context.getBean(CurrencyService.class);
        MyCurrencyService myCurrencyService = context.getBean(MyCurrencyService.class);

        currencyService.changeExchangeRate(1000);
        currencyService.doSomething();
        algoCurrencyService.changeRateTo(3000, CurrencyType.US);

        myCurrencyService.loadCurrency(600);
        myCurrencyService.loadCurrency(200, 500);
        myCurrencyService.changeCurrencyName(CurrencyType.US);

        try {
            myCurrencyService.changeCurrencyCountryName(CurrencyType.EURO);
        } catch (Exception e) {
            System.out.println("exception has been caught.");
        }

        myCurrencyService.changeCurrencyCountryName(CurrencyType.US);
    }
}