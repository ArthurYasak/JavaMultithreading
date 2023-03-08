package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.calculations.FieldCalculation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class StartScene extends MyScene {
    public StartScene(Stage stage) {
        super(stage);
    }
    public StartScene(double width, double height, Stage stage) {
        super(width, height, stage);
        fill(stage);
    }
    @Override
    public void fill(Stage stage) {
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        hBox.setSpacing(40);
        Label message = new Label("Enter the field parameters");
        vBox.getChildren().add(message);
        TextField widthField = new TextField();
        widthField.setPromptText("width");
        hBox.getChildren().add(widthField);
        TextField heighField = new TextField();
        heighField.setPromptText("heigh");
        hBox.getChildren().add(heighField);
        Button enter = new Button("Enter");
        enter.setOnAction(actionEvent -> {
            String textWidth = widthField.getText();
            int fieldWidth = Integer.parseInt(textWidth);
            String textHeigh = heighField.getText();
            int fieldHeight = Integer.parseInt(textHeigh);
            flowPane.getChildren().clear();
            CellsField cellsField = new CellsField(fieldWidth, fieldHeight);
            MainScene mainScene = new MainScene(stage, cellsField);
            mainScene.fill(stage);
            stage.setScene(mainScene);
        });

        hBox.getChildren().add(enter);
        vBox.getChildren().add(hBox);
        flowPane.getChildren().add(vBox);
    }
}
