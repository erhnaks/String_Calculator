package com.string_calculator.stringcalculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static int add(String string) {
        if (!string.isEmpty()) {
            List<Integer> numbers = Arrays.stream(string.split(",|\n"))
                    .map(Integer::parseInt).filter(n -> n < 1000).toList();

            if (numbers.stream().anyMatch(n -> n < 0)) {
                throw new IllegalArgumentException("Negatives not allowed: " + numbers);
            }

            return numbers.stream()
                    .reduce(Integer::sum)
                    .orElseThrow();
        }
        return 0;
    }
}