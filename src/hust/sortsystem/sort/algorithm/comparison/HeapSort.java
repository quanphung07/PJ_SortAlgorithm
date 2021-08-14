package hust.sortsystem.sort.algorithm.comparison;

import hust.sortsystem.sort.data.Element;

public class HeapSort extends ComparisonSort{
    // Java program for implementation of Heap Sort

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    Element elt_l;
    Element elt_r;
    Element elt_lg1;
    Element elt_lg2;
    Element elt_lg3;
    Element elt_first;
    public void heapify(int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root

        if (l < n)
        {
            elt_l = getData().get(l);
            elt_lg1 = getData().get(largest);
            if(compareElement(elt_l, elt_lg1)>0)
            {largest = l;}
        }


        // If right child is larger than largest so far

        if (r < n )
        {
            elt_r = getData().get(r);
            elt_lg2 = getData().get(largest);
            if(compareElement(elt_r, elt_lg2)>0)
            {
                largest = r;
            }

        }



        // If largest is not root

        if (largest != i) {

            elt_first=getData().get(i);
            elt_lg3 = getData().get(largest);
            swapElement(elt_first,elt_lg3);
            System.out.println(getData().toString());
            // Recursively heapify the affected sub-tree
            heapify(n, largest);
        }
    }

    @Override
    public void runAlgorithm() {
//        TODO:
        int n = getData().size();
        boolean haveSwap=false;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);

        // One by one extract an element from heap
        Element elt0;
        Element elt1;
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            elt0=getData().get(0);
            elt1=getData().get(i);
            swapElement(elt0,elt1);

            // call max heapify on the reduced heap
            heapify(i,0);
        }

    }
}
