package com.denart;

import com.denart.utils.ExamplesParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (true) {
            input = br.readLine();
            if (input.length() < 2) {
                System.out.println("Неверная команда.");
            } else if (input.length() > 2) {
                System.out.println(ExamplesParser.parseExample(input));
            } else if ("exit".equals(input)) {
                return;
            }
        }

    }
    ///br.close();
}
