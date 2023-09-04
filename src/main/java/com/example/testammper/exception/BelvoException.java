package com.example.testammper.exception;

public class BelvoException extends RuntimeException{
    public BelvoException(String message){
        super((String.format("Exception: %s", message)));
    }
}
