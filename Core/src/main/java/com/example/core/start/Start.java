package com.example.core.start;

import com.example.core.exceptions.AmountException;
import com.example.core.exceptions.CurrencyException;
import com.example.core.impls.DefaultStorage;

import java.math.BigDecimal;
import java.util.Currency;

public class Start {
    public static void main(String[] args)  {

        System.out.print("ok");

        try {
            DefaultStorage storage = new DefaultStorage();

            Currency currencyUSD = Currency.getInstance("USD");
            storage.addCurrency(currencyUSD);

            storage.addAmount(new BigDecimal(200),currencyUSD);

            storage.expenseAmount(new BigDecimal(250),currencyUSD);
            System.out.print("Storege" +storage.getAvailableCurrency());

        } catch (AmountException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        } catch (CurrencyException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }


    }
}