package com.example.core.exceptions;

public class AmountException extends Exception{
    public AmountException() {
    }

    public AmountException(String message) {
        super(message);
    }

    public AmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountException(Throwable cause) {
        super(cause);
    }

    public AmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
