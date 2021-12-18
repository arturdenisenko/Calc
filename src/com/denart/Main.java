package com.denart;

import com.denart.utils.ExamplesParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello this calc program, write your example here. ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            input = br.readLine();
            ExamplesParser.parseExampleToCharArray(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        br.close();
    }
}
