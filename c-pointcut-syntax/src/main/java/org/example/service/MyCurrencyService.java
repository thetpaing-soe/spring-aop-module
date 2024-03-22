package org.example.service;

import org.example.annotation.InTransaction;
import org.example.annotation.Secured;
import org.example.ds.CurrencyType;
import org.springframework.stereotype.Component;

@Component
@Secured
public class MyCurrencyService {

    public void loadCurrency(int num) {

    }

    public void loadCurrency(int num1, int num2) {

    }

    public void changeCurrencyName(CurrencyType type) {

    }

    @InTransaction
    public String changeCurrencyCountryName(CurrencyType type) {

        if (type.equals(CurrencyType.US)) {
            return "US";
        }
        else throw new IllegalArgumentException("Wrong Country Name");
    }
}
