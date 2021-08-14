package hust.sortsystem.view.datascene;

import hust.sortsystem.sort.algorithm.SortAlgorithm;
import hust.sortsystem.sort.algorithm.comparison.ComparisonSort;
import hust.sortsystem.sort.data.Element;
import hust.sortsystem.view.Context;
import hust.sortsystem.view.datascene.data.Arrow;
import hust.sortsystem.view.inputscene.InputViewController;
import javafx.animation.TranslateTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DataViewController extends Thread implements Initializable {
    private Context context;

    @FXML
    AnchorPane anchorPane;

    @FXML
    Button runStep;
    @FXML
    Label sortName;
    @FXML
    Slider slider;
    @FXML
    Label numberSwapLB;
    @FXML
    Button exitBT;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        slider.valueProperty().addListener((observableValue, aBoolean, t1) -> {
            context.getSortAlgorithm().setTimeDelay((Double) t1);
            System.out.println(t1);
        });



    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void show() throws InterruptedException {
        List<Element> data = context.getData();
        for(Element element : data) {
            int position = data.indexOf(element);
            int positionX = 100 + position * 100;
            element.getStackPane().setLayoutX(positionX);
            element.setArrow(new Arrow(positionX + 20, 90, positionX + 20, 110));
            element.getArrow().setVisible(false);

            anchorPane.getChildren().add(element.getStackPane());
            anchorPane.getChildren().add(element.getArrow());
        }
        sortName.setText(context.getSortAlgorithm().getSortName());


    }
    @FXML
    void setNextStep(ActionEvent actionEvent) throws InterruptedException {
        SortAlgorithm sortAlgorithm = context.getSortAlgorithm();
        sortAlgorithm.resume();

        Thread.sleep(500);
        sortAlgorithm.suspend();
        if(sortAlgorithm instanceof ComparisonSort) {
            ComparisonSort comparisonSort = (ComparisonSort) sortAlgorithm;
            numberSwapLB.setText(String.valueOf(((ComparisonSort) sortAlgorithm).getNumberSwap()));
        }

        if(!sortAlgorithm.isAlive()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Warning");
            alert.setContentText("Algorithm is not running");

            alert.showAndWait();
        }



    }

    public void setRunStep(ActionEvent actionEvent) throws InterruptedException {
        SortAlgorithm sortAlgorithm = context.getSortAlgorithm();
        if(sortAlgorithm.isAlive()) {
            if (sortAlgorithm.getSuspended()) {
                sortAlgorithm.resume();
            } else {
                sortAlgorithm.suspend();
            }


        } else {
            sortAlgorithm.resume();
            context.executeAlgorithm();
        }

    }
    public void setExitBT(ActionEvent actionEvent) {
        if(context.getSortAlgorithm().isAlive()) {
            context.getSortAlgorithm().stopThread();
        }

        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("../inputscene/InputView.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        InputViewController dataViewController = (InputViewController) fxmlLoader.getController();
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 376));
        stage.show();
    }

}
