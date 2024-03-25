package org.example.service;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public void changeExchangeRate(double rate) {
        doSomething();
    }

    @Override
    public void doSomething() {

    }

    public void doSomethingExtra() {

    }
}
