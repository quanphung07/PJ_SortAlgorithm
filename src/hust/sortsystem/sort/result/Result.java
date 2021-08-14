package hust.sortsystem.sort.result;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<Step> result = new ArrayList<Step>();

    public List<Step> getResult() {
        return result;
    }

    public void addStep(Step step) {
        result.add(step);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        for (Step step : result) {
            stringBuffer.append(step.toString());
            stringBuffer.append("\t");
        }

        return String.valueOf(stringBuffer);
    }
}
