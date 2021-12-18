package com.denart.utils;

import com.denart.model.Roman;
import com.denart.model.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateUtil {
    public static abstract class Arithmetic {
        public abstract int apply(int x, int y);
    }

    private static class Add extends Arithmetic {
        public int apply(int x, int y) {
            return x + y;
        }
    }

    private static class Subtract extends Arithmetic {
        public int apply(int x, int y) {
            return x - y;
        }
    }

    private static class Multiply extends Arithmetic {
        public int apply(int x, int y) {
            return x * y;
        }
    }

    private static class Divide extends Arithmetic {
        public int apply(int x, int y) {
            return x / y;
        }
    }

    public static void calculate(List<Symbol> symbolList) {

        Map<String, Arithmetic> operators = new HashMap<>();
        operators.put("+", new Add());
        operators.put("-", new Subtract());
        operators.put("*", new Multiply());
        operators.put("/", new Divide());
        String answer = String.valueOf(operators.get(symbolList.get(1).getValue()).apply(Integer.parseInt(symbolList.get(0).getValue()), Integer.parseInt(symbolList.get(2).getValue())));
        if (symbolList.get(0) instanceof Roman) {
            System.out.println(RomanToArabicConverter.arabicToRoman(Integer.parseInt(answer)));
        } else {
            System.out.println(answer);
        }
    }
}
