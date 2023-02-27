package com.example.bacteriacolony.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartScene {
    public Scene createScene(Stage stage) {
        FlowPane startFlowPane = new FlowPane(10, 10);
        startFlowPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(startFlowPane, 700, 500);

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
            int width = Integer.parseInt(textWidth);
            String textHeigh = heighField.getText();
            int height = Integer.parseInt(textHeigh);
            MainScene mainScene = new MainScene();
            Scene secondScene = mainScene.createScene(width, height);
            stage.setScene(secondScene);
        });

        hBox.getChildren().add(enter);
        vBox.getChildren().add(hBox);
        startFlowPane.getChildren().add(vBox);

        return scene;
    }
}
