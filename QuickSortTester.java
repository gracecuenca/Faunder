//Team Faunder: Grace Cuenca, Adris Jaoutakas, Haiyao Liu
//APCS2 pd1
//LAB01 -- What Does the Data Say?
//2017-03-09

/*=======================
  class QuickSortTester
  ======================*/

// QuickSortTester: Works for any algorithm and gets its time.
//        Abstract, since the tested algorithm must be defined
public abstract class QuickSortTester {

    // Optional data definition (NOT counted in calculated time)
    protected abstract void initData(int n); 

    // Defiene the algorithm to time here
    protected abstract void algorithm(int n);

    // Average time to run algorithm for n=n
    public long averageNanoTime(int runs, int n) {
        initData(n);

        long startTime = System.nanoTime();
        for(int i = 0; i < runs; i++) {
           algorithm(n);
        }
        long delta = System.nanoTime() - startTime;
        return delta / runs;
    }

    // Gets a list of the average nanotimes for n = (startN to endN)
    public long[] getTimes(int startN, int endN, int runs) {
        long[] result = new long[endN - startN + 1];
        for(int i = startN; i <= endN; i++) {
            result[i - startN] = (long) averageNanoTime(runs, i);
        }
        return result;
    }

    // Prints a given timeArr list with a start offset
    public static void printTimes(int start, long[] timeArr) {
        for(int i = 0; i < timeArr.length; i++) {
            System.out.println( (start + i) + " : " + timeArr[i] );
        }
    }

    public static void main(String[] args) {
        QuickSortTester time = new TimeQsort(); // defines which Algorithm to use
        long[] times = time.getTimes(1, 100, 200);
        printTimes(1, times);
    }
}

// Timer implementation for Qsort
class TimeQsort extends QuickSortTester {

    private static int[] arr;

    @Override
    protected void initData(int n) {
        arr = QuickSort.buildArray(n, 20);
    }

    @Override
    protected void algorithm(int n) {
        QuickSort.qsort(arr);
    }
}
