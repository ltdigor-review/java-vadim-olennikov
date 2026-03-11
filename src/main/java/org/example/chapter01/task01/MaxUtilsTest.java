package org.example.chapter01.task01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MaxUtilsTest {
    @ParameterizedTest
    @CsvSource({
        "0, 1, 2, 2",
        "5, 3, 1, 5",
        "-1, -5, -3, -1",
        "7, 7, 7, 7",
        "10, 20, 15, 20",
        "0, 0, 0, 0",
        "-10, 5, 0, 5",
        "2147483647, 0, -1, 2147483647",
        "-2147483648, -100, -50, -50"
    })
    void factorialTest(int first, int second, int third, int expected) {
        int actual = MaxUtils.max(first, second, third);
        assertEquals(expected, actual);
    }
}
