package Package;

import java.io.*;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
/**

* selection sort sorts the array and 
* print average run time & average memory 
* space for different data set
*
* @author  chhavi Gupta
*/
public class SelectionSort {
	   private static DecimalFormat decimalFormat = new DecimalFormat("#.###");
	    private static final long MEGABYTE = 1024L * 1024L;
	    private static final int MAX = 7;
	    private static final int CONVERTSEC = 1000;

    static void sortData(double[] arr ,int datasize){
        
    
        for(int i=0;i<datasize-1;i++) {
            int index=i;
            Double min = arr[i];
            for(int j=i+1;j<datasize;j++){
                if(arr[j]< min){
                    //System.out.println(min);
                    min=arr[j];
                     index=j;
                }
            }
            arr[index]=arr[i];
        //assigning min value to ith position
            arr[i]=min;
           // fout.write(min.toString() + System.getProperty( "line.separator" ));

        }
        //fout.close();
    }
  // function to calculate run & Iteration   
    void SimulationForSelectionSort(double[] data , Runtime runtime , String s ,String Datasettype , int datasize){
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
            SelectionSort.sortData(arr , datasize);
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
    //printing average time & memory for different data type.
    System.out.println("Average Time for " + s+ " "+ Datasettype +" " + "of datasize " + datasize + "-->"
            + decimalFormat.format(averageTime) + "s");
   System.out.println("Average Memory for" + s+ Datasettype +" " + "of datasize " +datasize +"-->"+decimalFormat.format(averageMemory) + "MB");
}
}
