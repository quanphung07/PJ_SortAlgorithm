package hust.sortsystem.sort.algorithm.noncomparison;

import hust.sortsystem.sort.algorithm.SortAlgorithm;
import hust.sortsystem.sort.data.Element;

import java.util.List;
public abstract class NonComparisonSort extends SortAlgorithm {
    public int getMax(int n)
    {
        List<Element> data=getData();
        int max = data.get(0).getValue();
        Element elt_cmp;
        for (int i = 1; i < n; i++) {
            elt_cmp = data.get(i);
            if (elt_cmp.getValue() > max) {
                max = data.get(i).getValue();
            }

        }
        return max;
    }

    public void updatePositionData(List<Element> arrayCopy) {
        synchronized(this) {
            while(getSuspended()) {
                try {
                    wait();
                } catch (InterruptedException e) {
//                    stopThread();
                    e.printStackTrace();
                }
            }
        }
        for(int i = 0; i < getData().size(); i++) {
            if(getData().get(i).getValue() != arrayCopy.get(i).getValue()
            && arrayCopy.get(i).getValue() != 0) {
//                getData().get(i).setCircleColorAqua();
                getData().get(i).getArrow().setVisible(true);
            }
            getData().get(i).setValue(arrayCopy.get(i).getValue());
            getData().get(i).setText(String.valueOf(getData().get(i).getValue()));

        }

        try {
            Thread.sleep((long) timeDelay);
        } catch (InterruptedException e) {
            stopThread();

        }

        for(int i = 0; i < getData().size(); i++) {
            getData().get(i).getArrow().setVisible(false);
        }
    }
}
