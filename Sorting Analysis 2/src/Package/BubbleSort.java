package Package;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;

/**

* Bubble sort sorts the array and 
* print average run time & average memory 
* space for different data set
*
* @author  chhavi Gupta
*/
 class BubbleSort{
	   private static DecimalFormat decimalFormat = new DecimalFormat("#.###");
	    private static final long MEGABYTE = 1024L * 1024L;
	    private static final int MAX = 5;
	    private static final int CONVERTSEC = 1000;
//Function to swap two elements
    static void swap(double[] data , int i, int j){
        double temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }

    static void sort(double[] data, int datasize){
        for(int i=0;i<datasize-1;i++){
            for(int j=i+1;j<data.length;j++){
                if(data[i]>data[j]){
                    swap(data,i,j);
                }

            }
        }
    }
   //Function to calculate run time & memory for different Data type
    void SimulationForBubbleSort(double[] data , Runtime runtime , String s,String Datasettype,int datasize){
        double[] arr = data.clone();
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
            BubbleSort.sort(arr,datasize);
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
    //Printing average time & memory for all DataSet
    System.out.println("Average Time for " + s+ " "+ Datasettype +" " + "of datasize " + datasize +" " 
             + decimalFormat.format(averageTime) + "s");
    System.out.println("Average Memory for" + s+ Datasettype +" " + "of datasize " + datasize +" -->" +decimalFormat.format(averageMemory) + "MB");
}

 }
