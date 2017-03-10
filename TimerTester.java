//Team Faunder: Grace Cuenca, Adris Jaoutakas, Haiyao Liu
//APCS2 pd1
//LAB01 -- What Does the Data Say?
//2017-03-09

/*=======================
  class TimerTester
  ======================*/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

// TimerTester: Works for any algorithm and gets its time.
//        Abstract, since the tested algorithm must be defined
public abstract class TimerTester {

    private static final String OUTPUT_CSV_FILENAME = "times.csv";


    // Data definition (NOT counted in calculated time)
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
 
    // Writes a list of runtimes up in a csv (with a start offset)
    private static void writeRuntimeCSV(long[] runtimes, int offset) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < runtimes.length; i++) {
            result.append(i + offset).append(",").append(runtimes[i]).append("\n");
        }
        String content = result.toString();
        writeTextFile(content, OUTPUT_CSV_FILENAME);        
    }

    // Writes text to text file
    private static void writeTextFile(String content, String fname) {
        BufferedWriter writer = null;
        try {
            File result = new File(fname);

            writer = new BufferedWriter(new FileWriter(result));
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Write to file \"" + fname + "\" failed!");
            e.printStackTrace();
        // Close regardless
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                System.err.println("Welp we're screwed");
                e.printStackTrace();
            }
        }
    }

    // MAIN TEST METHOD (for other projects THIS changes)
    public static void main(String[] args) {
        TimerTester time = new TimeQsort(); // defines which Algorithm to use
        long[] times = time.getTimes(1, 100, 200);
        printTimes(1, times);
    }
}

// TimerTester implementation for Qsort
class TimeQsort extends TimerTester { 

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
