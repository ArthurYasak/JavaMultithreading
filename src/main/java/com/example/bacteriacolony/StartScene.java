package com.example.bacteriacolony;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartScene{
    static FlowPane startFlowPane;
    static VBox vBox;
    static HBox hBox;
    static int width;
    static int heigh;
    static Button enter;
    public static Scene createScene(Stage stage) {
        startFlowPane = new FlowPane(10, 10);
        startFlowPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(startFlowPane, 700, 500);

        vBox = new VBox();
        hBox = new HBox();
        hBox.setSpacing(40);
        Label message = new Label("Enter the field parameters");
        vBox.getChildren().add(message);
        TextField widthField = new TextField();
        widthField.setPromptText("width");
        hBox.getChildren().add(widthField);
        TextField heighField = new TextField();
        heighField.setPromptText("heigh");
        hBox.getChildren().add(heighField);
        enter = new Button("Enter");

        StartScene.enter.setOnAction(actionEvent -> {
            String textWidth = widthField.getText();
            width = Integer.parseInt(textWidth);
            String textHeigh = heighField.getText();
            heigh = Integer.parseInt(textHeigh);
            Scene mainScene = MainScene.createScene(width, heigh);
            stage.setScene(mainScene);
        });

        hBox.getChildren().add(enter);
        vBox.getChildren().add(hBox);
        startFlowPane.getChildren().add(vBox);

        return scene;
    }
}
