package hust.sortsystem.sort.algorithm.comparison;

import java.util.ArrayList;
import java.util.List;

import hust.sortsystem.sort.algorithm.SortAlgorithm;
import hust.sortsystem.sort.data.Element;

public class MergeSort extends ComparisonSort{
	
	void merge(int left, int mid, int right) {
		int n1 = mid-left+1;
		int n2 = right -mid;
		
		Element L[] = new Element[n1];
		Element R[]	= new Element[n2];
		List<Element> copy = new ArrayList<Element>();
		
		for (int i=0; i<n1;i++)
			L[i] = getData().get(left+i);
		for (int j=0; j<n2;j++)
			R[j] = getData().get(mid+1+j);
		for(int i = 0; i < getData().size(); i++) {
			copy.add(new Element(0));
		}
		
		int i=0, j=0;
		int k=left;
		while(i<n1 && j<n2) {
			if(compareElement(R[j], L[i])>=0) {
				copy.get(k).setValue(L[i].getValue());
//				getData().set(k, L[i]);
				i++;
			}else {
				copy.get(k).setValue(R[j].getValue());

//				getData().set(k, R[j]);
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			copy.get(k).setValue(L[i].getValue());

//			getData().set(k, L[i]);
			i++;
			k++;
		}
		
		while(j<n2) {
			copy.get(k).setValue(R[j].getValue());

//			getData().set(k, R[j]);
			j++;
			k++;
		}
		System.out.println(copy.toString());
		updatePositionData(copy, left, right);
	}

	public void updatePositionData(List<Element> arrayCopy, int left, int right) {
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
		for(int i = left; i <= right; i++) {
			if(getData().get(i).getValue() != arrayCopy.get(i).getValue()
					&& arrayCopy.get(i).getValue() != 0) {
//                getData().get(i).setCircleColorAqua();
//				getData().get(i).getArrow().setVisible(true);
			}
			getData().get(i).setValue(arrayCopy.get(i).getValue());
			getData().get(i).setText(String.valueOf(getData().get(i).getValue()));

		}

		try {
			Thread.sleep((long) timeDelay);
		} catch (InterruptedException e) {
			stopThread();

		}

//		for(int i = 0; i < getData().size(); i++) {
//			getData().get(i).getArrow().setVisible(false);
//		}
	}

	void sort(int left, int right) {
		if(left<right) {
			int mid = left+(right-left)/2;
			sort(left,mid);
			sort(mid+1,right);
			merge(left,mid,right);
		}
	}
    @Override
    public void runAlgorithm() {
    	int n = getData().size();
    	sort(0,n-1);
    	System.out.println(getData().toString());
    }
}
