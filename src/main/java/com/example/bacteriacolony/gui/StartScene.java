package com.example.bacteriacolony.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartScene extends MyScene {
    public StartScene(Stage stage) {
        super();
    }
    public StartScene(double width, double height, Stage stage) {
        super(width, height);
        fill(stage);
    }
    @Override
    void fill(Stage stage) {

        VBox vBox = new VBox();
        HBox widthBox = new HBox();
        HBox heightBox = new HBox();
        HBox generationsBox = new HBox();

        widthBox.setSpacing(70);
        heightBox.setSpacing(66);
        generationsBox.setSpacing(40);

        Label labelWidth = new Label("Field width");
        widthBox.getChildren().add(labelWidth);
        Label labelHeight = new Label("Field height");
        heightBox.getChildren().add(labelHeight);
        Label labelGenerations = new Label("Max generations");
        generationsBox.getChildren().add(labelGenerations);

        TextField widthField = new TextField();
        widthField.setPromptText("width");
        widthBox.getChildren().add(widthField);
        TextField heightField = new TextField();
        heightField.setPromptText("height");
        heightBox.getChildren().add(heightField);
        TextField generationsField = new TextField();
        generationsField.setPromptText("generations");
        generationsBox.getChildren().add(generationsField);

        Button enter = new Button("Enter");
        enter.setOnAction(actionEvent -> {
            EnterHandler enterHandler = new EnterHandler();
            enterHandler.handle(widthField, heightField, generationsField, stage);
        });

        vBox.setSpacing(20);
        vBox.getChildren().add(widthBox);
        vBox.getChildren().add(heightBox);
        vBox.getChildren().add(generationsBox);
        vBox.getChildren().add(enter);
        flowPane.getChildren().add(vBox);
    }
}
