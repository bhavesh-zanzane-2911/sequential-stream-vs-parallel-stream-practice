package org.bhavesh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public final class StreamBehaviourUnderstanding {

    private static final String THREADS_USED = "Threads Used {}";

    private StreamBehaviourUnderstanding() {
        //Added a private constructor to hide implicit one
    }

    private static final Logger LOG = LoggerFactory.getLogger(StreamBehaviourUnderstanding.class);

    public static List<Integer> processParallelyForGivenCapacityAndReturnList(int capacity, int sleepTimeInMilliSeconds, boolean isUseForEachOrdered) {
        List<Integer> listOfNumbers = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity);
        long startTime = System.currentTimeMillis();
        List<Integer> numbersAfterFiltering = new ArrayList<>();
        Set<String> threadNamesUsedToProcess = new HashSet<>();
        Stream<Integer> integerStream = listOfNumbers.parallelStream().filter(i ->
        {
            StreamBahaviourUnderstandingUtils.sleep(sleepTimeInMilliSeconds);
            //LOG.info("Thread Name: {} Number: {}", Thread.currentThread().getName(), i);
            return i < capacity;
        });
        if (isUseForEachOrdered) {
            integerStream.forEachOrdered(numberAfterFiltering -> {
                threadNamesUsedToProcess.add(Thread.currentThread().getName());
                numbersAfterFiltering.add(numberAfterFiltering);
            });
        } else {
            integerStream.forEach(numberAfterFiltering -> {
                threadNamesUsedToProcess.add(Thread.currentThread().getName());
                numbersAfterFiltering.add(numberAfterFiltering);
            });
        }

        long endTime = System.currentTimeMillis();
        LOG.info("{}", numbersAfterFiltering);
        LOG.info(THREADS_USED, threadNamesUsedToProcess);
        LOG.info("Time taken by Parallel Stream {}", endTime - startTime);
        return numbersAfterFiltering;
    }

    public static List<Integer> processSequentiallyForGivenCapacityAndReturnList(int capacity, int sleepTimeInMilliSeconds) {
        List<Integer> listOfNumbers = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity);
        long startTime = System.currentTimeMillis();
        List<Integer> numbersAfterFiltering = new ArrayList<>();
        Set<String> threadNamesUsedToProcess = new HashSet<>();
        listOfNumbers.stream().filter(i ->
        {
            StreamBahaviourUnderstandingUtils.sleep(sleepTimeInMilliSeconds);
            //LOG.info("Thread Name: {} Number: {}", Thread.currentThread().getName(), i);
            return i < capacity;
        }).forEach(numberAfterFiltering -> {
            threadNamesUsedToProcess.add(Thread.currentThread().getName());
            numbersAfterFiltering.add(numberAfterFiltering);
        });
        long endTime = System.currentTimeMillis();
        LOG.info("{}", numbersAfterFiltering);
        LOG.info(THREADS_USED, threadNamesUsedToProcess);
        LOG.info("Time taken by Sequential Stream {}", endTime - startTime);
        return numbersAfterFiltering;
    }


    public static List<Integer> processParallelyFirstThenSequntialForGivenCapacityAndReturnList(int capacity, int sleepTimeInMilliSeconds, boolean isUseForEachOrdered) {
        List<Integer> listOfNumbers = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity);
        long startTime = System.currentTimeMillis();
        List<Integer> numbersAfterFiltering = new ArrayList<>();
        Set<String> threadNamesUsedToProcess = new HashSet<>();
        Stream<Integer> integerStream = listOfNumbers.parallelStream().sequential().filter(i ->
        {
            StreamBahaviourUnderstandingUtils.sleep(sleepTimeInMilliSeconds);
            //LOG.info("Thread Name: {} Number: {}", Thread.currentThread().getName(), i);
            return i < capacity;
        });
        if (isUseForEachOrdered) {
            integerStream.forEachOrdered(numberAfterFiltering -> {
                threadNamesUsedToProcess.add(Thread.currentThread().getName());
                numbersAfterFiltering.add(numberAfterFiltering);
            });
        } else {
            integerStream.forEach(numberAfterFiltering -> {
                threadNamesUsedToProcess.add(Thread.currentThread().getName());
                numbersAfterFiltering.add(numberAfterFiltering);
            });
        }

        long endTime = System.currentTimeMillis();
        LOG.info("{}", numbersAfterFiltering);
        LOG.info(THREADS_USED, threadNamesUsedToProcess);
        LOG.info("Time taken by Parallel First and Then Sequential Stream {}", endTime - startTime);
        return numbersAfterFiltering;
    }

    public static List<Integer> processSequentiallyFirstThenParallelForGivenCapacityAndReturnList(int capacity, int sleepTimeInMilliSeconds, boolean isUseForEachOrdered) {
        List<Integer> listOfNumbers = StreamBahaviourUnderstandingUtils.getListOfNumbersWithGivenCapacity(capacity);
        long startTime = System.currentTimeMillis();
        List<Integer> numbersAfterFiltering = new ArrayList<>();
        Set<String> threadNamesUsedToProcess = new HashSet<>();
        Stream<Integer> integerStream = listOfNumbers.stream().parallel().filter(i ->
        {
            StreamBahaviourUnderstandingUtils.sleep(sleepTimeInMilliSeconds);
            //LOG.info("Thread Name: {} Number: {}", Thread.currentThread().getName(), i);
            return i < capacity;
        });
        if (isUseForEachOrdered) {
            integerStream.forEachOrdered(numberAfterFiltering -> {
                threadNamesUsedToProcess.add(Thread.currentThread().getName());
                numbersAfterFiltering.add(numberAfterFiltering);
            });
        } else {
            integerStream.forEach(numberAfterFiltering -> {
                threadNamesUsedToProcess.add(Thread.currentThread().getName());
                numbersAfterFiltering.add(numberAfterFiltering);
            });
        }
        long endTime = System.currentTimeMillis();
        LOG.info("{}", numbersAfterFiltering);
        LOG.info(THREADS_USED, threadNamesUsedToProcess);
        LOG.info("Time taken by Sequential First And Then Parallel Stream {}", endTime - startTime);
        return numbersAfterFiltering;
    }
}