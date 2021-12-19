package com.denart.exceptions;

public class CalcException extends RuntimeException {
    private final String expression;

    public CalcException(String message, String expression) {
        super(message);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
