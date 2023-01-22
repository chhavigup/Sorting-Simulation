package Package;
import java.util.Random;
/**

* Generating Uniformly  distributed data 
* and calling different sorting Algorithm 
* for different data size
*
* @author  chhavi Gupta
*/
public class SyntheticDataSet1 {
    InsertionSort is = new InsertionSort();
    BubbleSort bs =new BubbleSort();
    MergeSort ms= new MergeSort();
    QuickSort qs =new QuickSort();
    SelectionSort ss = new SelectionSort();
    
  //Function to Generate Data  
	 private static void getSyntheticDataSet(double[] arr)
{
		 Random r =new Random();
          for (int i = 0; i < arr.length; i++)
{
              double val = 10000.00 + (220000.00 - 10000.00) * r.nextDouble();

            arr[i] = val;
}


}
	 
//function calling different sorting techniques	
	 
	  void genertatingDataSet(Runtime runtime){
		  double[] arr = new double[200000];
		  getSyntheticDataSet(arr);  
		  int[] datasize = {20000,50000, 75000,100000,120000,150000,200000};
			for(int i : datasize)
			{
		    is.SimulationForInsertionSort(arr , runtime ,"Insertion Sort","SyntheticDataASet1",i);
		    bs.SimulationForBubbleSort(arr , runtime ,"Buble Sort","SyntheticDataASet1",i);
		    ms.SimulationForMergeSort(arr , runtime ,"Merge Sort","SyntheticDataASet1",i);
		    qs.SimulationForQuickSort(arr , runtime ,"Quick Sort","SyntheticDataASet1",i);
		     ss.SimulationForSelectionSort(arr , runtime ,"Selection Sort","SyntheticDataASet1",i);
			}
		    DegreeOfSortedness ds=new DegreeOfSortedness();
		    ds.degreeOfSortedness(arr,runtime);

	    
	}
}
