package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class StreamBehaviourUnderstandingTest {

    private static final Logger LOG = LoggerFactory.getLogger(StreamBehaviourUnderstandingTest.class);

    @Test
    void processParallelForGivenCapacityAndReturnListWithForEachTerminalOperation() {
        //given
        int capacity=100;
        int sleepTimeInMilliSeconds=10;
        List<Integer> listOfIntegersBeforeProcess = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity-1);
        //when
        List<Integer> listOfIntegersAfterProcess = StreamBehaviourUnderstanding.processParallelyForGivenCapacityAndReturnList(capacity, sleepTimeInMilliSeconds, false);
        //then
        //The order of numbers should not be same
        Assertions.assertNotEquals(listOfIntegersBeforeProcess, listOfIntegersAfterProcess);

    }

    @Test
    void processParallelForGivenCapacityAndReturnListWithForEachOrderedTerminalOperation() {
        //given
        int capacity=100;
        int sleepTimeInMilliSeconds=10;
        List<Integer> listOfIntegersBeforeProcess = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity-1);
        //when
        List<Integer> listOfIntegersAfterProcess = StreamBehaviourUnderstanding.processParallelyForGivenCapacityAndReturnList(capacity, sleepTimeInMilliSeconds, true);
        //then
        //The order of numbers should be same
        Assertions.assertEquals(listOfIntegersBeforeProcess, listOfIntegersAfterProcess);

    }

    @Test
    void processSequentiallyForGivenCapacityAndReturnList() {
        //given
        int capacity=100;
        int sleepTimeInMilliSeconds=10;
        List<Integer> listOfIntegersBeforeProcess = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity-1);
        //when
        List<Integer> listOfIntegersAfterProcess = StreamBehaviourUnderstanding.processSequentiallyForGivenCapacityAndReturnList(capacity, sleepTimeInMilliSeconds);
        //then
        Assertions.assertEquals(listOfIntegersBeforeProcess, listOfIntegersAfterProcess);

    }
}