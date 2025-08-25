package org.example.chapter01.task06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "10, 3628800",
            "20, 2432902008176640000",
            "25, 15511210043330985984000000"
    })
    void factorialTest(int n, String expectedStr) {
        BigInteger expected = new BigInteger(expectedStr);

        BigInteger actual = FactorialCalculator.factorial(n);

        assertEquals(expected, actual);
    }
}
