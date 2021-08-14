package hust.sortsystem.sort.algorithm.comparison;

import hust.sortsystem.sort.data.Element;

public class QuickSort extends ComparisonSort {

    int partition(int low, int high) {
        Element pivot = getData().get(high);    // pivot
        int left = low;
        int right = high - 1;
        while(true){
            Element element1 = getData().get(left);
            Element element2 = getData().get(right);
            while(left <= right && compareElement(element1, pivot) < 0) {
                left++;
                element1 = getData().get(left);

            }
            while(right >= left && compareElement(element2, pivot) > 0) {
                right--;
                if(right < 0) break;
                element2 = getData().get(right);

            }
            if (left >= right) break;
            element1 = getData().get(left);
            element2 = getData().get(right);
            swapElement(element1, element2);
            System.out.println(getData().toString());
            left++;
            right--;
        }
        Element element1 = getData().get(left);

        swapElement(element1, pivot);
        System.out.println(getData().toString());
        return left;
    }

    void quickSort(int low, int high) {
        if (low < high)
        {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
    @Override
    public void runAlgorithm() {
        int n = getData().size();
        quickSort(0, n - 1);
        System.out.println(getData().toString());


    }


}
