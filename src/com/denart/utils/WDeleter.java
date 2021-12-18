package com.denart.utils;

public class WDeleter {
    public static String deleteAllW(String str){
        return str.replaceAll("\\s","");
    }
}
