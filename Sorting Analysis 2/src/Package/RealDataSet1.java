package Package;
import java.io.*;
import java.util.ArrayList;


/*this class is responsible for DataSet1*/
public class RealDataSet1 {
  InsertionSort is = new InsertionSort();
  BubbleSort bs = new BubbleSort();
  MergeSort ms = new MergeSort();
  QuickSort qs = new QuickSort();
  SelectionSort ss = new SelectionSort();
  DegreeOfSortedness ds = new DegreeOfSortedness();

  void genertatingDataSet(Runtime runtime) {
    ArrayList < Double > list = new ArrayList < > ();

    try (BufferedReader myReader = new BufferedReader(new FileReader("DataSet/RealDataSet1.txt"))) {

      for (String val;
        (val = myReader.readLine()) != null;) {
        list.add(Double.parseDouble(val));
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    double[] arr = list.stream().mapToDouble(d -> d).toArray();
    
    //define datasize for x-axis
    int[] datasize = {
      20000,
      50000,
      75000,
      100000,
      120000,
      150000,
      200000
    };
    
    //Iteration for Each DataSize
      for (int i: datasize) {

      is.SimulationForInsertionSort(arr, runtime, "Insertion Sort", "RealDataSet1", i);
      bs.SimulationForBubbleSort(arr, runtime, "Buble Sort", "RealDataSet1", i);
      ms.SimulationForMergeSort(arr, runtime, "Merge Sort", "RealDataSet1", i);
      qs.SimulationForQuickSort(arr, runtime, "Quick Sort", "RealDataSet1", i);
      ss.SimulationForSelectionSort(arr, runtime, "Selection Sort", "RealDataSet1", i);
    }
        ds.degreeOfSortedness(arr, runtime);

  }
}