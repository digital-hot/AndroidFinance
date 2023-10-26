package com.example.core.impls.operation;

import com.example.core.abstracts.AbstractOperation;
import com.example.core.interfaces.Source;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

public class ConvertOperation extends AbstractOperation {

    public ConvertOperation(long id, Calendar dateTime, String addInfo, Source fromSource, Source toSource, BigDecimal fromAmount, BigDecimal toAmount, Currency fromCurrency, Currency toCurrency) {
        super(id, dateTime, addInfo);
        this.fromSource = fromSource;
        this.toSource = toSource;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public ConvertOperation(long id, Source fromSource, Source toSource, BigDecimal fromAmount, BigDecimal toAmount, Currency fromCurrency, Currency toCurrency) {
        super(id);
        this.fromSource = fromSource;
        this.toSource = toSource;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public ConvertOperation(Source fromSource, Source toSource, BigDecimal fromAmount, BigDecimal toAmount, Currency fromCurrency, Currency toCurrency) {
        this.fromSource = fromSource;
        this.toSource = toSource;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    private Source fromSource;
    private Source toSource;
    private BigDecimal fromAmount;
    private BigDecimal toAmount;
    private Currency fromCurrency;
    private Currency toCurrency;

    public Source getFromSource() {
        return fromSource;
    }

    public void setFromSource(Source fromSource) {
        this.fromSource = fromSource;
    }

    public Source getToSource() {
        return toSource;
    }

    public void setToSource(Source toSource) {
        this.toSource = toSource;
    }

    public BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    public BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }
}
