package Package;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
/**

* Quick sort sorts the array and 
* print average run time & average memory 
* space for different data set
*
* @author  chhavi Gupta
*/
public class QuickSort {
	   private static DecimalFormat decimalFormat = new DecimalFormat("#.###");
	    private static final long MEGABYTE = 1024L * 1024L;
	    private static final int MAX = 5;
	    private static final int CONVERTSEC = 1000;
    
     static void swap(double[] data, int a , int b){
        double temp=data[a];
        data[a]=data[b];
        data[b]=temp;

     }

     static void sort(double[] data , int min , int max    ){
        if(min<max){
        int part = partition(data,min,max);
         sort(data,min,part-1);
         sort(data,part+1,max);

            }
        }
  // Function to partition array on the value of pivot 
    static int partition( double[] data, int min ,int max ){
        double pivot =data[max];
        int j=min-1;
        for(int i= min;i<=max-1;i++){
            if(data[i]<pivot){
                j++;
                swap(data,j,i);
            }
        }
        swap(data,j+1,max);
        return(j+1);
    }
//Function to calculate Average & runtime for different Data type
    void SimulationForQuickSort(double[] data , Runtime runtime , String s,String Datasettype , int datasize){
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
            QuickSort.sort(arr,0,datasize-1);
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
    System.out.println("Average Time for " + s+ " "+ Datasettype +" " + "of datasize " + datasize+"-->"
            + decimalFormat.format(averageTime) + "s");
   System.out.println("Average Memory for" + s+ Datasettype +" " + "of datasize " +datasize+ "-->"+decimalFormat.format(averageMemory) + "MB");
}


    
    
}
