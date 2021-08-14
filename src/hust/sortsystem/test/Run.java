package hust.sortsystem.test;

import hust.sortsystem.sort.algorithm.SortAlgorithm;
import hust.sortsystem.sort.algorithm.comparison.BubbleSort;
import hust.sortsystem.sort.algorithm.comparison.MergeSort;
import hust.sortsystem.sort.algorithm.comparison.QuickSort;
import hust.sortsystem.sort.algorithm.noncomparison.BucketSort;
import hust.sortsystem.sort.algorithm.noncomparison.RadixSort;
import hust.sortsystem.sort.data.Element;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        Element factor1 = new Element(139);
        Element factor2 = new Element(75);
        Element factor3 = new Element(595);
        Element factor4 = new Element(816);
        Element factor5 = new Element(365);
        Element factor6 = new Element(907);
        Element factor7 = new Element(642);
        Element factor8 = new Element(805);
        Element factor9 = new Element(243);
        List<Element> data = new ArrayList<>();
        data.add(factor1);
        data.add(factor2);
        data.add(factor3);
        data.add(factor4);
        data.add(factor5);
        data.add(factor6);
        data.add(factor7);
        data.add(factor8);
        data.add(factor9);

//        Thay gia tri dau vao la cac thuat toan de test
        SortAlgorithm sortAlgorithm = new MergeSort();
        sortAlgorithm.setData(data);
        sortAlgorithm.runAlgorithm();
        System.out.println(data.toString());


//        SortAlgorithm quickSort = new QuickSort();
//        quickSort.algorithm(data);




    }
}
