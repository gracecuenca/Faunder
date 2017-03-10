# Faunder
### _Grace Cuenca, Adris Jaoutakas and Haiyao Liu_

### QuickSort's Big-Oh runtime

#### BEST CASE
* The best case occurs when n is halved after every pass. Since the runtime of partitioning is O(n) and the array is halved after every pass, the best case is O(nlogn).
* This happens when the pivot always points to the median.

#### AVERAGE CASE
* On average, the pivot will be around the median of the array. The worst case would be splitting the array in a 3:1 ratio after every pass (not quite median but not quite worst case; in between). This means that there are about logn partitions to make, n times. The runtime would be O(nlogn).

#### WORST CASE
* The worst case occurs when the pivot is the minimum or maximum of the array.  After each pass, the array will be reduced by only one element. This means partition has to be run n - 1 times, leading to a runtime of O(n^2).

### QuickSort's Methodology
* QuickSort works by splitting an array into two partitions if the array.length > 1. Then, QuickSort is run on the two partitions of the array.
* Partition works by selecting a pivot, moving all elements less than or equal to the pivot value to the left of the pivote.

### Time Measurements and Analysis
<<<<<<< HEAD
* Because we grew tired of rewriting timer classes and because we sensed that there may be more timer projects to come, we decided to write a generic timer class that times any function. No hassle, no nonesense, just define the function in a superclass and give it a spin.
* The timer has an abstract "algorithm" method that takes in an "n" parameter and in subclasses you define this algorithm and what it means to run it for any "n". (in this case the algorithm is QuickSort.qsort)
* The timer also has an abstract "initData" method that takes in an "n". This is used to create different arrays of length "n" but in reality it can be used for anything.
* When asked, the timer runs the "initData" method, then runs a large number of iterations of "algorithm", measures the time it took to run all those and finds the average time in nanoseconds. This can be done for a range of "n"'s using the "getTimes" method, which returns an array with the times.
* See png file.

### Pivot Selection and Data Arrangement's Affect on Execution Time
* When the pivots are located at the extremes, the runtime becomes slower
* When the pivot is located at the median of the data set, the runtime becomes faster
* When the data arrangement is already sorted and either extreme is selected as the pivot, this is the worst case.
