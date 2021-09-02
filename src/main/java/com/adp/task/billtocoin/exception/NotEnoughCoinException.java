package com.adp.task.billtocoin.exception;

public class NotEnoughCoinException extends RuntimeException{

    public NotEnoughCoinException(String message) {
        super(message);
    }
}
