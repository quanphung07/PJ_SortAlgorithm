package hust.sortsystem.sort.result;

public class Step {
    private int position1;
    private int position2;

    public Step() {

    }

    public Step(int factor1, int factor2) {
        this.position1 = factor1;
        this.position2 = factor2;
    }

    public int getPosition1() {
        return position1;
    }

    public void setPosition1(int position1) {
        this.position1 = position1;
    }

    public int getPosition2() {
        return position2;
    }

    public void setPosition2(int position2) {
        this.position2 = position2;
    }

    @Override
    public String toString() {
        return "Step{" +
                "position1=" + position1 +
                ", position2=" + position2 +
                '}';
    }
}
