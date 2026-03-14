package org.example.chapter01.task01;

public class MaxUtils {
    public static int max(int first, int second, int third) {
        int result = first;

        if (second > result) {
            result = second;
        }
        if (third > result) {
            result = third;
        }

        return result;
    }
}
