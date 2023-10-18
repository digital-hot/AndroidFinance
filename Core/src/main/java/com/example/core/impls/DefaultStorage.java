package com.example.core.impls;

import com.example.core.exceptions.AmountException;
import com.example.core.exceptions.CurrencyException;
import com.example.core.interfaces.Storage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultStorage implements Storage {

    private String name;

    //Створюэмо (ініцилізуємо) пусті колекції, одна валюту повина бути.
    private Map<Currency, BigDecimal> currencyAmounts = new HashMap<>();
    private List<Currency> currencyList = new ArrayList<>();

    public DefaultStorage(){}

    public DefaultStorage(String name){
        this.name = name;
    }

    public DefaultStorage(List<Currency> currencyList, Map<Currency, BigDecimal> currencyAmounts, String name) {
        this.currencyList = currencyList;
        this.currencyAmounts = currencyAmounts;
        this.name = name;
    }

    public DefaultStorage(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }

    public DefaultStorage(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public List<Currency> getAvailableCurrency() {
        return currencyList;
    }
    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public Map<Currency, BigDecimal> getCurrencyAmounts() {
        return currencyAmounts;
    }

    public void setCurrencyAmounts(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Отримання залишків по валюті
    @Override
    public BigDecimal getAmount(Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);
        return currencyAmounts.get(currency);
    }

    //Оновлення залишків
    @Override
    public void chengeAmount(BigDecimal amount, Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);
        currencyAmounts.put(currency, amount);
    }

    //Додавання грошей у сховище
    @Override
    public void addAmount(BigDecimal amount, Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);
        BigDecimal oldAmount = currencyAmounts.get(currency);
        currencyAmounts.put(currency,oldAmount.add(amount));
    }

    //Віднімання грошей у сховище
    @Override
    public void expenseAmount(BigDecimal amount, Currency currency) throws AmountException, CurrencyException {
        checkCurrencyExist(currency);
        BigDecimal oldAmount = currencyAmounts.get(currency);
        BigDecimal newValue = oldAmount.subtract(amount);
        checkAmount(newValue); // щоб не було відємних залишків
        currencyAmounts.put(currency, newValue);
    }

    //Перевірка залишків. Сума не по вина будти меньше нуля
    private void checkAmount(BigDecimal amount) throws AmountException {
        if (amount.compareTo(BigDecimal.ZERO) < 0){
            throw new AmountException("Amount can't be < 0");
        }

    }

    //Додати валюту
    @Override
    public void addCurrency(Currency currency) throws CurrencyException {
        if (currencyAmounts.containsKey(currency)){
            throw new CurrencyException("Currency already exist");// пока просто сообщение на англ, без локализации
        }
        currencyList.add(currency);
        currencyAmounts.put(currency, BigDecimal.ZERO);
    }

    //Видалити валюту
    @Override
    public void deleteCurrency(Currency currency) throws CurrencyException {

        checkCurrencyExist(currency);

        // Якщо э залишки по валюті, не видаляемо.
        if (!currencyAmounts.get(currency).equals(BigDecimal.ZERO)){
            throw new CurrencyException("Can't delete currency with amount");
        }
        currencyList.remove(currency);
        currencyAmounts.remove(currency);
    }

    //Перерахувати валюту
    @Override
    public BigDecimal getApproxAmount(Currency currency) {
        // TODO реалізувати перерахунок по валюті
        throw new UnsupportedOperationException("Not inplemend");
    }

    //Отримати всю валюту у сховищі
    @Override
    public Currency getCurrency(String code) throws CurrencyException {
        //Використовуємо бібліотеку Apache Commons Collections
        //Обходимо циклом обєм не великий

        for (Currency currency : currencyList) {
            if (currency.getCurrencyCode().equals(code)) {
                return currency;
            }
        }
        throw new CurrencyException("Currency (code="+code+") not exist in storage");
    }
    private void checkCurrencyExist(Currency currency) throws CurrencyException {
        if (!currencyAmounts.containsKey(currency)){
            throw new CurrencyException("Currency "+currency+" not exist");
        }
    }


}
