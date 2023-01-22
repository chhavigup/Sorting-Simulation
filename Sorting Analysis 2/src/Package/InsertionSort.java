package Package;

import java.time.Instant;
import java.time.Duration;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/**

* Insertion sort sorts the array and 
* print average run time & average memory 
* space for different data set
*
* @author  chhavi Gupta
*/

public class InsertionSort {
    private static DecimalFormat decimalFormat = new DecimalFormat("#.###");
    private static final long MEGABYTE = 1024L * 1024L;
    private static final int MAX = 7;
    private static final int CONVERTSEC = 1000;
// Function to Sort ArrayList using Insertion Sort
   static void sortData(double[] arr ,int datasize){
       for(int i=1;i<datasize;i++){
            double val = arr[i];
            int j =i-1;
            while(j>=0 && arr[j]>val ) {
            //Comparing data of index i with its predecessor indexes
                   arr[j+1]=arr[j];
                    j--;
            }
            arr[j+1]=val;
        }
    }
//Function to find Average Time & Memory for Insertion Sort
    void SimulationForInsertionSort(double[] data , Runtime runtime , String s, String Datasettype ,int datasize ){
    	double arr[] = data.clone();
        double time;
        double averageTime;
        double averageMemory;
        double totalTime = 0;	
        double spaceComplexity = 0;
        long usedMemoryBefore;
        long usedMemoryAfter;
        Instant startTime;
        Instant finishTime;
    //Iterating for 5 times 
        for (int i = 0; i < 5; i++)
        {
            runtime.gc();
            usedMemoryBefore=runtime.totalMemory() - runtime.freeMemory();
            startTime = Instant.now();
            InsertionSort.sortData(arr,datasize);
            finishTime = Instant.now();
            usedMemoryAfter =
                    runtime.totalMemory() - runtime.freeMemory();
            time = Duration.between(startTime, finishTime).toMillis();
            totalTime += time;
            spaceComplexity += usedMemoryAfter - usedMemoryBefore;

    }
    averageMemory = (double)spaceComplexity/(MAX * MEGABYTE);
    averageTime = totalTime/(MAX * CONVERTSEC);
    decimalFormat.setRoundingMode(RoundingMode.UP);
    //printing value for Average time & memory for different data types
    System.out.println("Average Time for " + s+ " "+ Datasettype +" " + "of datasize  " + datasize + " -> "
            + decimalFormat.format(averageTime) + "s");
   System.out.println("Average Memory for" + s+ Datasettype +" " + "of datasize " +datasize + " --> " +decimalFormat.format(averageMemory) + "MB");
   
}
}
    


