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
        HBox hBox = new HBox();
        hBox.setSpacing(40);
        Label message = new Label("Enter the field parameters");
        vBox.getChildren().add(message);
        TextField widthField = new TextField();
        widthField.setPromptText("width");
        hBox.getChildren().add(widthField);
        TextField heightField = new TextField();
        heightField.setPromptText("heigh");
        hBox.getChildren().add(heightField);
        Button enter = new Button("Enter");
        enter.setOnAction(actionEvent -> {
            EnterHandler enterHandler = new EnterHandler();
            enterHandler.handle(widthField, heightField, stage);
        });

        hBox.getChildren().add(enter);
        vBox.getChildren().add(hBox);
        flowPane.getChildren().add(vBox);
    }
}
