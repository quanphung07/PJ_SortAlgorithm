package hust.sortsystem.view.inputscene;

import hust.sortsystem.util.CheckNumeric;
import hust.sortsystem.view.Context;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import hust.sortsystem.view.datascene.DataViewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InputViewController implements Initializable {
    Context conText = new Context();

    @FXML
    TextField numberFactorTF;
    @FXML
    CheckBox randomCB;
    @FXML
    Button startBT;
    @FXML
    ImageView imageView;
    @FXML
    TextField elementValueTF;
    @FXML
    Button addElementBT;
    @FXML
    ComboBox comboBox;
    @FXML
    Label countLB;
    @FXML
    Label warningLB;
    @FXML
    ObservableList<String> list = FXCollections.observableArrayList("BubbleSort", "QuickSort", "MergeSort", "HeapSort", "BucketSort", "RadixSort");

    int count = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(list);
        comboBox.setValue(list.get(0));
        numberFactorTF.textProperty().addListener((observableValue, s, t1) -> {
            if(!CheckNumeric.isNumeric(t1)) {
                startBT.setDisable(true);
                warningLB.setText("");
                return;
            }

            if(Integer.parseInt(t1) < 1 || Integer.parseInt(t1) > 9) {
                startBT.setDisable(true);
                warningLB.setText("Digit 1 - 9");
                return;
            }
            warningLB.setText("");

            startBT.setDisable(false);

        });

        elementValueTF.textProperty().addListener((observableValue, s, t1) -> {
            if(!CheckNumeric.isNumeric(t1)) {
                addElementBT.setDisable(true);
                return;
            }

            if(Integer.parseInt(t1) < 0 || Integer.parseInt(t1) > 100) {
                addElementBT.setDisable(true);
                return;
            }

            addElementBT.setDisable(false);

        });

        randomCB.selectedProperty().addListener((observableValue, aBoolean, t1) -> {
            if(t1) {
               elementValueTF.setVisible(false);
               addElementBT.setVisible(false);
               countLB.setVisible(false);
            }

            if(aBoolean) {
                elementValueTF.setVisible(true);
                addElementBT.setVisible(true);
                countLB.setVisible(true);
            }
        });

    }

    public void setAddElementBT(ActionEvent actionEvent) {
        int value = Integer.parseInt(elementValueTF.getText());
        conText.setElement(value);
        elementValueTF.setText("");
        count++;
        if(count == 9) {
            addElementBT.setDisable(true);
        }
        countLB.setText(String.valueOf(count));

    }

    public void setStartButton(ActionEvent actionEvent) throws IOException, InterruptedException {
        int numberFactor = Integer.valueOf(numberFactorTF.getText());
        conText.setDataRandom(numberFactor);
//        if(randomCB.isSelected()) {
//            int numberFactor = Integer.valueOf(numberFactorTF.getText());
//            conText.setDataRandom(numberFactor);
//        } else {
//            return;
//        }
//Thuat toan sap xep



        conText.setSortAlgorithm((String) comboBox.getValue());


        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("../datascene/DataView.fxml"));
        Parent root = fxmlLoader.load();
        DataViewController dataViewController = (DataViewController) fxmlLoader.getController();

//        dataViewController.setData(data);
//        dataViewController.setSortAlgorithm(conText.getSortAlgorithm());
        dataViewController.setContext(conText);
        dataViewController.show();

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(new Scene(root, 1000, 500));
        stage.show();

    }


}
