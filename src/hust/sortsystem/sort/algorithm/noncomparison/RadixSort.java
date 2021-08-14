package hust.sortsystem.sort.algorithm.noncomparison;

import hust.sortsystem.sort.data.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RadixSort extends NonComparisonSort {

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public void countSort(int n, int exp)
    {
//        int output[] = new int[n]; // output array
        List<Element> output=new ArrayList<Element>();
        for(int i=0;i<n;i++)
        {
            output.add(new Element(0));
        }
        Element elt;
        int i;
        int count[]=new  int[10];
        for(i=0;i<10;i++)
        {count[i]=0 ;}
//
//        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            elt= getData().get(i);
            count[(elt.getValue() / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            elt= new Element(getData().get(i).getValue());
            output.set(count[(elt.getValue() / exp) % 10] - 1,elt);
            count[(elt.getValue() / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        updatePositionData(output);
        System.out.println(getData().toString());
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    @Override
    public void runAlgorithm() {
//        //    TODO:

        int n=getData().size();

        int max = getMax(n);
//
//        // Do counting sort for every digit. Note that
//        // instead of passing digit number, exp is passed.
//        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(n,exp);
    }
}