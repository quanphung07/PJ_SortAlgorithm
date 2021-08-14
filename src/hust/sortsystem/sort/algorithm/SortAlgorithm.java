package hust.sortsystem.sort.algorithm;

import hust.sortsystem.sort.data.Element;

import java.util.ArrayList;
import java.util.List;

public abstract class SortAlgorithm extends ThreadExtend{
    private List<Element> data = new ArrayList<Element>();

    private String sortName;


    public abstract void runAlgorithm();

    public void setData(List<Element> data) {
        this.data = data;
    }

    public List<Element> getData() {
        return data;
    }

    @Override
    public void run() {
         runAlgorithm();
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}
