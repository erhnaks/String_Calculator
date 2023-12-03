package com.string_calculator.stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    @Test
    void shouldReturnZeroForEmtptyString() {
        int result = Calculator.add("");
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldReturnNumberForOneNumber() {
        int result = Calculator.add("7");
        Assertions.assertEquals(7, result);
    }

    @Test
    void shouldReturnTotalSumForTwoNumbers() {
        int result = Calculator.add("7,7");
        Assertions.assertEquals(14, result);
    }

    @Test
    void shouldReturnTotalSumOfNumbers() {
        int result = Calculator.add("7,7,7");
        Assertions.assertEquals(21, result);
    }

    @Test
    void shouldReturnTotalSumOfNumbersSplitByNewLine() {
        int result = Calculator.add("7,7\n7");
        Assertions.assertEquals(21, result);
    }

    @Test
    void shouldReturnTotalSumOfPosiviteNumber() {
        int result = Calculator.add("7,7\n7,0");
        Assertions.assertEquals(21, result);
    }


    @Test
    void shouldReturnSumOfNumbersIgnoringNumbersOverOneThousand() {
        int result = Calculator.add("7,7\n7,0,1001");
        Assertions.assertEquals(21, result);
    }

    @Test
    void shouldIgnoreSemiColonsAndReturnSumOfNumbers() {
        int result = Calculator.add("7,7\n7,0,1001;4");
        Assertions.assertEquals(25, result);
    }


    @Test
    void shouldThrowExceptionForNegativeNumbers() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.add("7,7\n-7,0"));
    }
}