package Package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**

* Reading data from file
* and calling different sorting Algorithm 
* for different data size
*
* @author  chhavi Gupta
*/

public class RealDataSet2 {
    InsertionSort is = new InsertionSort();
    BubbleSort bs =new BubbleSort();
    MergeSort ms= new MergeSort();
    QuickSort qs =new QuickSort();
    SelectionSort ss = new SelectionSort();
    DegreeOfSortedness ds=new DegreeOfSortedness();
    
//Reading data from local file 
     void genertatingDataSet(Runtime runtime){
        ArrayList<Double> list = new ArrayList<>();
       
        try(BufferedReader myReader= new BufferedReader(new FileReader("DataSet/RealDataSet2.txt")))
        {
        
      
        for ( String val ;(val = myReader.readLine())!= null;) {
           list.add(Double.parseDouble(val));
       }
    }
    catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
        int[] datasize = {20000,50000, 75000,100000,120000,150000,200000};;
        double[] arr = list.stream().mapToDouble(d -> d).toArray(); 
        
        //Iteration for Each DataSize
        for(int i:datasize)
        { is.SimulationForInsertionSort(arr , runtime ,"Insertion Sort","RealDataSet2", i);
           bs.SimulationForBubbleSort(arr , runtime ,"Buble Sort","RealDataSet2",i);
          ms.SimulationForMergeSort(arr , runtime ,"Merge Sort","RealDataSet2",i);
           qs.SimulationForQuickSort(arr , runtime ,"Quick Sort","RealDataSet2",i);
           ss.SimulationForSelectionSort(arr , runtime ,"Selection Sort","RealDataSet2",i);
        }
       
        ds.degreeOfSortedness(arr,runtime);
}
}
