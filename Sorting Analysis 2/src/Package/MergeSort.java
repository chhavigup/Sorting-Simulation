package Package;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
/**

* Merge sort sorts the array and 
* print average run time & average memory 
* space for different data set
*
* @author  chhavi Gupta
*/
public class MergeSort {
	   private static DecimalFormat decimalFormat = new DecimalFormat("#.###");
	    private static final long MEGABYTE = 1024L * 1024L;
	    private static final int MAX = 7;
	    private static final int CONVERTSEC = 1000;
    static void sort(double[] arr, int left, int right)
    {
        if (left < right) {
            // Find the middle point
            int mid= left+ (right - left) / 2;
 
            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid+ 1, right);
 
            // Merge them
            merge(arr, left, mid, right);
        }
    } 

       static  void merge(double data[], int left, int mid, int right)
    {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;
 
      
        Double Left[] = new Double[n1];
        Double Right[] = new Double[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            Left[i] = data[left+ i];
        for (int j = 0; j < n2; ++j)
            Right[j] = data[mid + 1 + j];
 
 
        //Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                data[k] = Left[i];
                i++;
            }
            else {
                data[k] = Right[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of Left[] if any */
        while (i < n1) {
            data[k] = Left[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of Right[] if any */
        while (j < n2) {
            data[k] = Right[j];
            j++;
            k++;
        }
    }
        void SimulationForMergeSort(double[] data , Runtime runtime , String s,String Datasettype , int datasize){
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
                MergeSort.sort(arr,0 , datasize-1);
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
        //printing value for average runtime & Memory for different data type
        System.out.println("Average Time for " + s+ " "+ Datasettype +" " + "of datasize " + datasize +"-->"
                + decimalFormat.format(averageTime) + "s");
       System.out.println("Average Memory for" + s+ Datasettype +" " + "of datasize "+ datasize + "-->"+decimalFormat.format(averageMemory) + "MB");
    }
 
}
