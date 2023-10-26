package com.example.core.impls.operation;

import com.example.core.abstracts.AbstractOperation;
import com.example.core.interfaces.Source;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

//TODO у всіх класах створити конструктори без поля id
public class IncomeOperation extends AbstractOperation {

    private Source fromSource;
    private Source toSource;
    private BigDecimal amount;
    private Currency currency;

    public IncomeOperation(long id, Calendar dateTime, String addInfo, Source fromSource, Source toSource, BigDecimal amount, Currency currency) {
        super(id, dateTime, addInfo);
        this.fromSource = fromSource;
        this.toSource = toSource;
        this.amount = amount;
        this.currency = currency;
    }

    public IncomeOperation(long id, Source fromSource, Source toSource, BigDecimal amount, Currency currency) {
        super(id);
        this.fromSource = fromSource;
        this.toSource = toSource;
        this.amount = amount;
        this.currency = currency;
    }

    public IncomeOperation(Source fromSource, Source toSource, BigDecimal amount, Currency currency) {
        this.fromSource = fromSource;
        this.toSource = toSource;
        this.amount = amount;
        this.currency = currency;
    }

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
