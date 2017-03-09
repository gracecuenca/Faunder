/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 *
 * 1. Summary of QuickSort algorithm:
 * 
 *  QSort(arr): 
 *     Pivot the array (I named the method "arrange")
 *     split into two groups:
 *          One group starts at the start of the parent array and ends on 
 *              the pivot final index
 *          The other starts on the pivot final index and ends at the end 
 *              of the parent array
 *      And continue recursively
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
 *
 *   It doesn't seem to make a difference because it ends up 
 *     not being dependent on position anyways
 *   But it seems like it should be if the pivot always ends up on one extreme
 *   To which case the runtime would be O(n^2) in rare cases (because it must
 *       run the recursive function "n" times)
 *
 * 2b. Best pivot choice / array state and associated runtime:
 *
 *   The pivot ends up in the middle
 *   then it's O(nlogn)
 *
 * 3. Approach to handling duplicate values in array:
 *
 *    There is none, it just works
 *    But seriously, it doesn't matter whether a duplicate element ends up
 *        on either side of itself. It's fiiine
 *
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }

    public static int arrange( int arr[], int a, int b, int c)
    {
	int v = arr[c];

	swap( c, b, arr);
	int s = a;

	for( int i = a; i < b; i++ ) {
	    if ( arr[i] <= v) {
		swap( i, s, arr );
		s++;}
	}
	swap(s,b,arr);

	return s;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) 
    { 
        qsortHelp(d, 0, d.length); 
    }

    private static void qsortHelp( int[] d, int start, int end ) {
        // if we've reached the smallest element, return.
        if (end - start <= 1) return;

        int middle = (start + end) / 2;

        int split = arrange(d, start, end - 1, middle);
        
        // sort on both sides
        qsortHelp(d, start, split);
        qsortHelp(d, split, end);
 
    }

    //main method for testing
    public static void main( String[] args ) 
    {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);


	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);

    }//end main

}//end class QuickSort
