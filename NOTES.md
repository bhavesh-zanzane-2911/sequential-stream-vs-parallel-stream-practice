# Stream Behaviour Understanding Notes

The below notes gives theoretical understanding of how sequential and parallel stream works

## Sequential Stream
- It uses single thread to process the execution 
- Its uses only main thread to process it
- By deafult we should use this, if we are really concern with performance then only we should start think about parallel stream


## Parallel Stream
- It uses multiple threads to process the execution
- No of threads its uses is Max no available cores system has
- ```int availableProcessors = Runtime.getRuntime().availableProcessors();```
- Uses ForkJoinPool framework to manages threads efficiently
- If it has 4 availableProcessors then probably including main thread + 3 ForkJoinPool threads as below
- [ForkJoinPool.commonPool-worker-1, ForkJoinPool.commonPool-worker-2, main, ForkJoinPool.commonPool-worker-3]
- It involves 3 phases : Splitting , Execution and Combining
- As splitting phase is costly its most suitable for those data structures like Array, ArrayList
- Worst choice when we use it for LinkedList.