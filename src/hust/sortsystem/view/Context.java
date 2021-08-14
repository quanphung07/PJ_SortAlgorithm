package hust.sortsystem.view;

import hust.sortsystem.sort.algorithm.SortAlgorithm;
import hust.sortsystem.sort.algorithm.comparison.BubbleSort;
import hust.sortsystem.sort.algorithm.comparison.HeapSort;
import hust.sortsystem.sort.algorithm.comparison.MergeSort;
import hust.sortsystem.sort.algorithm.comparison.QuickSort;
import hust.sortsystem.sort.algorithm.noncomparison.BucketSort;
import hust.sortsystem.sort.algorithm.noncomparison.RadixSort;
import hust.sortsystem.sort.data.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Context {
    private List<Element> data = new ArrayList<>();
    private SortAlgorithm sortAlgorithm;

    public List<Element> getData() {
        return data;
    }

    public void setData(List<Element> data) {
        this.data = data;
    }

    public SortAlgorithm getSortAlgorithm() {
        return sortAlgorithm;
    }

    public void setSortAlgorithm(String sortAlgorithmName) {
        switch (sortAlgorithmName) {
            case "BubbleSort": {
                this.sortAlgorithm = new BubbleSort();
                break;
            }
            case "QuickSort": {
                this.sortAlgorithm = new QuickSort();
                break;
            }

            case "HeapSort": {
                this.sortAlgorithm = new HeapSort();
                break;
            }

            case "BucketSort": {
                this.sortAlgorithm = new BucketSort();
                break;
            }

            case "RadixSort": {
                this.sortAlgorithm = new RadixSort();
                break;
            }

            case "MergeSort": {
                this.sortAlgorithm = new MergeSort();
                break;
            }
        }
        this.sortAlgorithm.setSortName(sortAlgorithmName);
    }

    public void setDataRandom(int maxCount) {
        for(int i = 0; i < maxCount; i++) {
            Random rand = new Random();
            int value = rand.nextInt(999);
            Element element = new Element(value);
            if(i == data.size()) {
                data.add(element);
            }
        }
    }

    public void executeAlgorithm() {
        sortAlgorithm.setData(data);
        sortAlgorithm.start();
    }

    public void setElement(int value) {
        Element element = new Element(value);
        data.add(element);
    }



}
