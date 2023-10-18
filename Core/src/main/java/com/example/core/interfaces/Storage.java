package com.example.core.interfaces;

import com.example.core.exceptions.AmountException;
import com.example.core.exceptions.CurrencyException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;

//TODO Змінити тип даних BigDecimal на готовий клас по роботі з грошима

public interface Storage {
    String getName(); //Реалізувати властивість name

    //Отримання залишків (баланса)
    Map<Currency, BigDecimal> getCurrencyAmounts(); //Залишки у валютах
    BigDecimal getAmount(Currency currency) throws CurrencyException; //Злишок у валюті
    BigDecimal getApproxAmount(Currency currency); //Залишок у перерахунку до валюти

    //Зміна балансу
    void chengeAmount(BigDecimal amount, Currency currency) throws CurrencyException; //Змінити залишок у валюті
    void addAmount(BigDecimal amount, Currency currency) throws CurrencyException; // Додати суму у валюті
    void expenseAmount(BigDecimal amount, Currency currency) throws AmountException, CurrencyException; //Відняти суму у валюті


    //Работа з валютою
    void addCurrency(Currency currency) throws CurrencyException; //Додати нову валюту у сховище
    void deleteCurrency(Currency currency) throws CurrencyException; //Видалити валюту з сховища
    Currency getCurrency(String cod) throws CurrencyException; //
    List <Currency> getAvailableCurrency(); //Отримати всі валюти з сховища

}
