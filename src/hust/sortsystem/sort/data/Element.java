package hust.sortsystem.sort.data;

import hust.sortsystem.view.datascene.data.ElementView;

public class Element extends ElementView implements Comparable<Element>{
    private Integer value;



    public Element(int value) {
        super(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Element o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
