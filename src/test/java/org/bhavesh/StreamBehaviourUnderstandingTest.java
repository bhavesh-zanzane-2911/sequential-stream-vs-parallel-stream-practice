package org.bhavesh;

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
    void processParallelForGivenCapacityAndReturnListWithForEachTerminalOperationWithLessNumbers() {
        //given
        //With 4 available cores and 4 tasks it's not mandatory to have 4 threads to process that task
        //Max thread count is 4 from fork-join-pool including main thread as well
        int capacity=4;
        int sleepTimeInMilliSeconds=10;
        List<Integer> listOfIntegersBeforeProcess = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity-1);
        //when
        List<Integer> listOfIntegersAfterProcess = StreamBehaviourUnderstanding.processParallelyForGivenCapacityAndReturnList(capacity, sleepTimeInMilliSeconds, false);
        //then
        //The order of numbers should not be same
        Assertions.assertNotEquals(listOfIntegersBeforeProcess, listOfIntegersAfterProcess);

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

    @Test
    void processParallelFirstThenSequentialForGivenCapacityAndReturnListWithForEachTerminalOperation() {
        //given
        int capacity=100;
        int sleepTimeInMilliSeconds=10;
        List<Integer> listOfIntegersBeforeProcess = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity-1);
        //when
        List<Integer> listOfIntegersAfterProcess = StreamBehaviourUnderstanding.processParallelyFirstThenSequntialForGivenCapacityAndReturnList(capacity, sleepTimeInMilliSeconds, false);
        //then
        //The order of numbers should be same as operation before terminal operation gets priority to execute
        //In this case only main thread would be used to process
        Assertions.assertEquals(listOfIntegersBeforeProcess, listOfIntegersAfterProcess);

    }

    @Test
    void processParallelFirstThenSequentialForGivenCapacityAndReturnListWithForEachOrderedTerminalOperation() {
        //given
        int capacity=100;
        int sleepTimeInMilliSeconds=10;
        List<Integer> listOfIntegersBeforeProcess = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity-1);
        //when
        List<Integer> listOfIntegersAfterProcess = StreamBehaviourUnderstanding.processParallelyFirstThenSequntialForGivenCapacityAndReturnList(capacity, sleepTimeInMilliSeconds, true);
        //then
        //The order of numbers should be same as operation before terminal operation gets priority to execute
        //In this case only main thread would be used to process
        Assertions.assertEquals(listOfIntegersBeforeProcess, listOfIntegersAfterProcess);

    }

    @Test
    void processSequentiallyFirstThenParallelForGivenCapacityWithForEachOrderedAndReturnList() {
        //given
        int capacity=100;
        int sleepTimeInMilliSeconds=10;
        List<Integer> listOfIntegersBeforeProcess = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity-1);
        //when
        List<Integer> listOfIntegersAfterProcess = StreamBehaviourUnderstanding.processSequentiallyFirstThenParallelForGivenCapacityAndReturnList(capacity, sleepTimeInMilliSeconds, true);
        //then
        //The order of numbers should be same as operation before terminal operation gets priority to execute as its parallel with ordered
        //In this case multiples threads are used to process
        Assertions.assertEquals(listOfIntegersBeforeProcess, listOfIntegersAfterProcess);

    }

    @Test
    void processSequentiallyFirstThenParallelForGivenCapacityWithForEachAndReturnList() {
        //given
        int capacity=100;
        int sleepTimeInMilliSeconds=10;
        List<Integer> listOfIntegersBeforeProcess = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity-1);
        //when
        List<Integer> listOfIntegersAfterProcess = StreamBehaviourUnderstanding.processSequentiallyFirstThenParallelForGivenCapacityAndReturnList(capacity, sleepTimeInMilliSeconds, false);
        //then
        //The order of numbers should not be same as operation before terminal operation gets priority to execute as its parallel
        //In this case multiples threads are used to process
        Assertions.assertNotEquals(listOfIntegersBeforeProcess, listOfIntegersAfterProcess);

    }
}