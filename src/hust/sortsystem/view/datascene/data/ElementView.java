package hust.sortsystem.view.datascene.data;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ElementView {
    Circle circle;
    private Text text;
    StackPane stackPane = new StackPane();
    private Arrow arrow;

    public ElementView(int value) {
        text = new Text(String.valueOf(value));
        text.setFont(Font.font(25));
        circle = new Circle();
        circle.setRadius(30);
        circle.setFill(Color.RED);

        stackPane.getChildren().addAll(circle, text);
        stackPane.setPrefSize(60, 60);
        stackPane.setLayoutY(130);

    }

    public Arrow getArrow() {
        return arrow;
    }

    public void setArrow(Arrow arrow) {
        this.arrow = arrow;
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public void setCircleColorAqua() {
        this.circle.setFill(Color.AQUAMARINE);
    }

    public void setCircleColorRed() {
        this.circle.setFill(Color.RED);
    }

    public StackPane getStackPane() {
        return stackPane;
    }


    @Override
    public String toString() {
        return "FactorView{" +
                "position=" +
                '}';
    }
}
