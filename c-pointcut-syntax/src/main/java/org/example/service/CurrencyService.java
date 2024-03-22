package org.example.service;

import org.springframework.stereotype.Component;

@Component
public interface CurrencyService {
    void changeExchangeRate(double rate);
}
