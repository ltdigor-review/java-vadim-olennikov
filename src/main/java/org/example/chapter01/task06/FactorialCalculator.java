package org.example.chapter01.task06;

import java.math.BigInteger;

public class FactorialCalculator {
    private FactorialCalculator() {
        throw new UnsupportedOperationException("Cannot instantiate utility class.");
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
