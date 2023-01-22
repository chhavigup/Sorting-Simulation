package Package;

import java.util.Random;
/**

* Generating data from random function
* and calling different sorting Algorithm 
* for different data size
*
* @author  chhavi Gupta
*/

public class SyntheticDataASet2 {
	 InsertionSort is = new InsertionSort();
	    BubbleSort bs =new BubbleSort();
	    MergeSort ms= new MergeSort();
	    QuickSort qs =new QuickSort();
	    SelectionSort ss = new SelectionSort();
	    
	//function to generating Gaussian value    
		 private static void getSyntheticDataSet(double[] arr)
	{
			 Random r =new Random();
			 int average = 500;
		        int standardDeviation = 100;

		        // Considering int for normal distribution
		        for (int i = 0; i < arr.length; i++)
		        {
		            double val =  Math.round(r.nextGaussian() * standardDeviation
		                                                            + average);
		            arr[i] = val;
		        }



	}
		 
		 
		  void genertatingDataSet(Runtime runtime){
			  double[] arr = new double[200000];
			  getSyntheticDataSet(arr); 
			  int[] datasize = {20000,50000, 75000,100000,120000,150000,200000};
		//Iterating for each data size on x-axis
			for(int i : datasize)
			{
		    is.SimulationForInsertionSort(arr , runtime ,"Insertion Sort","SyntheticDataASet2",i);
		    bs.SimulationForBubbleSort(arr , runtime ,"Buble Sort","SyntheticDataASet2",i);
		    ms.SimulationForMergeSort(arr , runtime ,"Merge Sort","SyntheticDataASet2",i);
		    qs.SimulationForQuickSort(arr , runtime ,"Quick Sort","SyntheticDataASet2",i);
		    ss.SimulationForSelectionSort(arr , runtime ,"Selection Sort","SyntheticDataASet2",i);
			}

		    DegreeOfSortedness ds=new DegreeOfSortedness();
		    ds.degreeOfSortedness(arr,runtime);
		    
		}
    
}
