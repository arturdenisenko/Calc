package com.denart.exceptions;

public class BadFormatException extends CalcException{
    public BadFormatException(String message, String expression) {
        super(message, expression);
    }
}
