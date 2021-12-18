package com.denart.utils;

import java.util.regex.Pattern;

public class ExpressionChecker {

    public static boolean isRomanRightExpression(String str) {
        String pattern = "^(X|IX|IV|V?I{0,3})[-/+*](X|IX|IV|V?I{0,3})$";
        Pattern r = Pattern.compile(pattern);
        return r.matcher(str).matches();
    }

    public static boolean isArabicRightExpression(String str) {
        String pattern = "^([1-9]|10)[-/+*]([1-9]|10)";
        Pattern r = Pattern.compile(pattern);
        return r.matcher(str).matches();
    }
}
