package org.example;

import java.util.ArrayList;
import java.util.List;

public final class StreamBahaviourUnderstandingUtils {

    public static void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Integer> getListOfNumbersWithGivenCapacity(int capacity) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= capacity; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
