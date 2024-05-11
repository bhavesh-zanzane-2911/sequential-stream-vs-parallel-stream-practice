package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class StreamBehaviourUnderstanding {

    private static final Logger LOG = LoggerFactory.getLogger(StreamBehaviourUnderstanding.class);

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        LOG.info("availableProcessors : {} ", availableProcessors);
        processParallelyForGivenCapacityAndReturnList(100,10);
        processSequentiallyForGivenCapacityAndReturnList(100, 10);
    }

    public static List<Integer> processParallelyForGivenCapacityAndReturnList(int capacity, int sleepTimeInMilliSeconds) {
        List<Integer> listOfNumbers = getListOfNumbersWithGivenCapacity(capacity);
        long startTime = System.currentTimeMillis();
        List<Integer> numbersAfterFiltering = listOfNumbers.parallelStream().filter(i ->
        {
            sleep(sleepTimeInMilliSeconds);
            LOG.info("Thread Name: {} Number: {}", Thread.currentThread().getName(), i);
            return i < capacity;
        }).toList();
        long endTime = System.currentTimeMillis();
        LOG.info("Time taken by Parallel Stream {}",endTime-startTime);
        LOG.info("{}", numbersAfterFiltering);
        return numbersAfterFiltering;

    }



    public static List<Integer> processSequentiallyForGivenCapacityAndReturnList(int capacity, int sleepTimeInMilliSeconds) {
        List<Integer> listOfNumbers = getListOfNumbersWithGivenCapacity(capacity);
        long startTime = System.currentTimeMillis();
        List<Integer> numbersAfterFiltering = listOfNumbers.stream().filter(i ->
        {
            sleep(sleepTimeInMilliSeconds);
            LOG.info("Thread Name: {} Number: {}", Thread.currentThread().getName(), i);
            return i < capacity;
        }).toList();
        long endTime = System.currentTimeMillis();
        LOG.info("Time taken by Sequential Stream {}",endTime-startTime);
        LOG.info("{}", numbersAfterFiltering);
        return numbersAfterFiltering;

    }

    private static void sleep(int milliSeconds) {
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