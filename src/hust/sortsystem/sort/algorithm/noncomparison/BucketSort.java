package hust.sortsystem.sort.algorithm.noncomparison;

import hust.sortsystem.sort.data.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort extends NonComparisonSort{
    public void bucketSort(int n)
    {
        if (n <= 0)
            return;

        List<ArrayList<Element>> buckets=new ArrayList<ArrayList<Element>>();
        for(int i=0;i<5;i++)
        {
            buckets.add(new ArrayList<Element>(0));
        }
        List<Element> output=new ArrayList<Element>();
        for(int i=0;i<n;i++)
        {
            output.add(new Element(0));
        }

        // 2) Put array elements in different buckets
        int max=getMax(n);
        Element elt_val;
        ArrayList<Element> buck_elt;
        for (int i = 0; i < n; i++) {

            elt_val= new Element(getData().get(i).getValue());
            int index=(int)Math.floor((elt_val.getValue()*5/(max+1)));
            buck_elt=buckets.get(index);
            buck_elt.add(elt_val);


        }
        // sap xep moi bucket , moi lan sap xep in ra 1 lan
        for (int i = 0; i < 5; i++) {

            buck_elt = buckets.get(i);
            Collections.sort(buck_elt);
            for (int index1 = 0, j = 0; j < 5; j++) {

                if (buckets.get(j).size() > 0) {
                    for (int k = 0; k < buckets.get(j).size(); k++) {
                        output.set(index1, buckets.get(j).get(k));
                        index1++;
                    }
                }
                updatePositionData(output);
                System.out.println(getData().toString());
            }

        }






    }
    //
    @Override
    public void runAlgorithm() {
        int n=getData().size();
        bucketSort(n);
    }
}