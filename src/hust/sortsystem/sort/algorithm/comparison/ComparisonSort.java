package hust.sortsystem.sort.algorithm.comparison;

import hust.sortsystem.sort.algorithm.SortAlgorithm;
import hust.sortsystem.sort.data.Element;
import javafx.animation.TranslateTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

public abstract class ComparisonSort extends SortAlgorithm {
    protected IntegerProperty numberSwap = new SimpleIntegerProperty(0);

    public int getNumberSwap() {
        return numberSwap.get();
    }

    public IntegerProperty numberSwapProperty() {
        return numberSwap;
    }

    public void setNumberSwap(int numberSwap) {
        this.numberSwap.set(numberSwap);
    }

    public  int compareElement(Element element1, Element element2) {
        int numSwap = numberSwap.get();
        numSwap++;
        setNumberSwap(numSwap);

        synchronized(this) {
            while(getSuspended()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        element1.setCircleColorAqua();
        element2.setCircleColorAqua();

        try {
            Thread.sleep((long) timeDelay);
        } catch (InterruptedException e) {
            stopThread();
        }
        element1.setCircleColorRed();
        element2.setCircleColorRed();


        return element1.compareTo(element2);
    }

    public void swapElement(Element element1, Element element2) {
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
        int tg = element1.getValue();
        element1.setValue(element2.getValue());
        element2.setValue(tg);
        element1.setText(String.valueOf(element1.getValue()));
        element2.setText(String.valueOf(element2.getValue()));

        element1.getArrow().setVisible(true);
        element2.getArrow().setVisible(true);
        try {
            Thread.sleep((long) timeDelay);
        } catch (InterruptedException e) {
            stopThread();

        }


        element1.getArrow().setVisible(false);
        element2.getArrow().setVisible(false);
    }
}
