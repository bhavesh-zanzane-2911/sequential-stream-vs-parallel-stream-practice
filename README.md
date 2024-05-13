# Stream Behaviour Understanding

This project explores different behaviors of Java Streams, focusing on parallel and sequential processing. It includes methods to process elements in parallel, sequentially, and combinations of both, along with tests to verify the behavior.

## Introduction

Java Streams provide a powerful way to process collections of elements in a declarative and functional style. Understanding how streams behave, especially in terms of parallelism and order of execution, is crucial for writing efficient and correct code.

This project aims to illustrate various stream processing scenarios and their outcomes, helping developers gain a deeper understanding of Java Streams and make informed decisions when designing and implementing stream-based solutions.

## Classes

### `StreamBehaviourUnderstanding`

This class provides methods to process elements in different ways using Java Streams.

#### Methods

- `processParallelyForGivenCapacityAndReturnList`: Processes elements in parallel for a given capacity and returns a list of filtered numbers.
- `processSequentiallyForGivenCapacityAndReturnList`: Processes elements sequentially for a given capacity and returns a list of filtered numbers.
- `processParallelyFirstThenSequntialForGivenCapacityAndReturnList`: Processes elements in parallel first and then sequentially for a given capacity and returns a list of filtered numbers.
- `processSequentiallyFirstThenParallelForGivenCapacityAndReturnList`: Processes elements sequentially first and then in parallel for a given capacity and returns a list of filtered numbers.

### `StreamBehaviourUnderstandingTest`

This class contains test cases to verify the behavior of the methods in the `StreamBehaviourUnderstanding` class.

#### Test Cases

- `processParallelForGivenCapacityAndReturnListWithForEachTerminalOperation`: Tests the behavior of processing elements in parallel with a `forEach` terminal operation.
- `processParallelForGivenCapacityAndReturnListWithForEachOrderedTerminalOperation`: Tests the behavior of processing elements in parallel with a `forEachOrdered` terminal operation.
- `processParallelForGivenCapacityAndReturnListWithForEachTerminalOperationWithLessNumbers`: Tests the behavior of processing elements in parallel with fewer numbers.
- `processSequentiallyForGivenCapacityAndReturnList`: Tests the behavior of processing elements sequentially.
- `processParallelFirstThenSequentialForGivenCapacityAndReturnListWithForEachTerminalOperation`: Tests the behavior of processing elements in parallel first and then sequentially with a `forEach` terminal operation.
- `processParallelFirstThenSequentialForGivenCapacityAndReturnListWithForEachOrderedTerminalOperation`: Tests the behavior of processing elements in parallel first and then sequentially with a `forEachOrdered` terminal operation.
- `processSequentiallyFirstThenParallelForGivenCapacityWithForEachOrderedAndReturnList`: Tests the behavior of processing elements sequentially first and then in parallel with a `forEachOrdered` terminal operation.
- `processSequentiallyFirstThenParallelForGivenCapacityWithForEachAndReturnList`: Tests the behavior of processing elements sequentially first and then in parallel with a `forEach` terminal operation.

## Usage

To use the methods in the `StreamBehaviourUnderstanding` class, simply call the desired method with the appropriate parameters.

For example:

```java
List<Integer> result = StreamBehaviourUnderstanding.processParallelyForGivenCapacityAndReturnList(100, 10, true);

