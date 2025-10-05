package org.bhavesh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public final class StreamBehaviourUnderstandingUtils {

    private static final Logger LOG = LoggerFactory.getLogger(StreamBehaviourUnderstandingUtils.class);

    private StreamBehaviourUnderstandingUtils() {
        //Added a private constructor to avoid explicit object creation
    }

    public static void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException interruptedException) {
            LOG.error("Exception occurred during sleeping a thread:", interruptedException);
            throw new RuntimeException(interruptedException);
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
