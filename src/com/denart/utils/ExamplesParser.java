package com.denart.utils;

import com.denart.exceptions.CalcException;
import com.denart.model.Arabic;
import com.denart.model.Operator;
import com.denart.model.Roman;
import com.denart.model.Symbol;

import java.util.ArrayList;
import java.util.List;

public class ExamplesParser {
    static List<Symbol> symbolList = new ArrayList<>();

    public static String parseExample(String example) {
        example = WDeleter.deleteAllW(example);
        convertToSymbolsList(example);
        return CalculateUtil.calculate(symbolList);
    }

    private static void convertToSymbolsList(String example) {
        if (ExpressionChecker.isArabicRightExpression(example)) {
            char[] chars = example.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    sb.append(chars[i]);
                    if (i == chars.length - 1) {
                        symbolList.add(new Arabic(String.valueOf(sb)));
                        sb.setLength(0);
                    }
                } else if (!Character.isDigit(chars[i])) {
                    symbolList.add(new Arabic(String.valueOf(sb)));
                    sb.setLength(0);
                    symbolList.add(new Operator(String.valueOf(chars[i])));
                }
            }

        } else if (ExpressionChecker.isRomanRightExpression(example)) {
            char[] chars = example.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetter(chars[i])) {
                    sb.append(chars[i]);
                    if (i == chars.length - 1) {
                        symbolList.add(new Roman(String.valueOf(sb)));
                        sb.setLength(0);
                    }
                } else if (!Character.isLetter(chars[i])) {
                    symbolList.add(new Roman(String.valueOf(sb)));
                    sb.setLength(0);
                    symbolList.add(new Operator(String.valueOf(chars[i])));
                }
            }
            convertSymbolsListToArabic();
        } else {
            throw new CalcException("Bad expression format", example);
        }

    }

    private static void convertSymbolsListToArabic() {
        for (Symbol symbol : symbolList) {
            if (symbol instanceof Roman) {
                symbol.setValue(String.valueOf(RomanToArabicConverter.romanToArabic(symbol.getValue())));
            }
        }
    }

}
