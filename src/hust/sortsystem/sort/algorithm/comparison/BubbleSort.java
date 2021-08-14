package hust.sortsystem.sort.algorithm.comparison;

import hust.sortsystem.sort.data.Element;

public class BubbleSort extends ComparisonSort {

    public BubbleSort() {

    }

    @Override
    public void runAlgorithm() {
        int i, j;
        int n = getData().size();
        boolean haveSwap = false;
        for (i = 0; i < n-1; i++){
            // i phần tử cuối cùng đã được sắp xếp
            haveSwap = false;
            for (j = 0; j < n-i-1; j++){
                Element element1 = getData().get(j);
                Element element2 = getData().get(j + 1);
                if (compareElement(element1, element2) > 0){
                    swapElement(element1, element2);
                    System.out.println(getData().toString());
                    haveSwap = true; // Kiểm tra lần lặp này có swap không
                }
            }
            // Nếu không có swap nào được thực hiện => mảng đã sắp xếp. Không cần lặp thêm
            if(haveSwap == false){
                break;
            }
        }

    }



}
