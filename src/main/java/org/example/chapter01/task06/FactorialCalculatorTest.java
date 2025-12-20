package org.example.chapter01.task06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FactorialCalculatorTest {

    /**
     * JUnit автоматически преобразует строку в объект при выполнении определенных условий.<br>
     * Подробнее:
     * <a href="https://docs.junit.org/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-implicit">
     * Implicit Argument Conversion in Parameterized Tests
     * </a>.
     */
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
    void factorialTest(int n, BigInteger expected) {
        BigInteger actual = FactorialCalculator.factorial(n);
        assertEquals(expected, actual);
    }
}
