package Package;

import java.util.Arrays;

public class DegreeOfSortedness {


//Function to get Inversion Count 
    public static long getInversionCount(long arrayLength,
        int degreeOfSortedness) {
        long maxPossibleInversions = arrayLength * (arrayLength - 1) / 2;
        double degreeOfUnsortedness = (100 - degreeOfSortedness);
        long value = Math.round(degreeOfUnsortedness * maxPossibleInversions) / 100;

        return value;
    }

//Function to call all sorting techniques for different degree of sortedness
    public void degreeOfSortedness(double[] dataSet, Runtime runtime) {
        InsertionSort is = new InsertionSort();
        BubbleSort bs = new BubbleSort();
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
        SelectionSort ss = new SelectionSort();

//array for degree  of sortedness to b e considered
        int[] degreeOfSortedness = {
            0,
            10,
            20,
            80,
            100
        };
        for (int i: degreeOfSortedness) {
          
            System.out.println("For degree " + i + ": ");
            
            long inversionCount = DegreeOfSortedness.getInversionCount(dataSet.length,
                i);
            double[] arr = DegreeOfSortedness.generateDegreeOfSortednessArray(dataSet, inversionCount);

            is.SimulationForInsertionSort(arr, runtime, "Insertion Sort", "degreeOfSortedness", arr.length);
            bs.SimulationForBubbleSort(arr, runtime, "Buble Sort", "degreeOfSortedness", arr.length);
            ms.SimulationForMergeSort(arr, runtime, "Merge Sort", "degreeOfSortedness", arr.length);
            qs.SimulationForQuickSort(arr, runtime, "Quick Sort", "degreeOfSortedness", arr.length);
            ss.SimulationForSelectionSort(arr, runtime, "Selection Sort", "degreeOfSortedness", arr.length);

        }

    }

    /**
     * inversionCount will calculate inversion count
     *
     * @param array values of array
     * @return inversion count
     */

    public static long inversionCount(double[] array) {
        long inversionCount = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    inversionCount = inversionCount + 1;
                }
            }
        }

        return inversionCount;
    }

    /**
     * generateDegreeOfSortednessArray will generate a array of define  degree
    
     *
     */
    public static double[] generateDegreeOfSortednessArray(double[] arr,
        long inversionCount) {
        int n = arr.length;
        double[] arr1 = Arrays.copyOf(arr, n);
        Arrays.sort(arr1);
        int m = (int) Math.floor((1 + Math.sqrt(1 + 8 * inversionCount)) / 2);
        for (int i = 0; i < m / 2; i++) {
            double temp = arr1[i];
            arr1[i] = arr1[m - 1 - i];
            arr1[m - 1 - i] = temp;
        }

        inversionCount -= inversionCount(arr1);
        if (inversionCount > 0) {
            boolean flag = true;
            for (int i = 0; i < n - m; i++) {
                for (int j = m; j < n - 1 - i; j++) {
                    if (arr1[j + 1] != arr1[j]) {
                        double temp = arr1[j];
                        arr1[j] = arr1[j + 1];
                        arr1[j + 1] = temp;
                        inversionCount--;
                        if (inversionCount == 0) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (!flag) {
                    break;
                }
            }
        }

        if (inversionCount > 0) {
            boolean flag = true;
            for (int i = 0; i < n - m; i++) {
                for (int j = m + i; j > 0; j--) {
                    if (arr1[j - 1] != arr1[j]) {
                        double temp = arr1[j];
                        arr1[j] = arr1[j - 1];
                        arr1[j - 1] = temp;
                        inversionCount--;
                        if (inversionCount == 0) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (!flag) {
                    break;
                }
            }
        }
        return arr1;
    }
}