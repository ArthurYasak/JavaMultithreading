package com.example.bacteriacolony;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class MoleculaApplication extends Application {
    VBox vBox;
    HBox hBox;
    Button[][] cells;
    int[][] states;
    int width;
    int heigh;
    FlowPane startFlowPane;
    FlowPane mainFlowPane;
    boolean startStopStatement;
    @Override
    public void start(Stage stage) {

        stage.setTitle("My first App!");

        startFlowPane = new FlowPane(10, 10);
        startFlowPane.setAlignment(Pos.CENTER);

        mainFlowPane = new FlowPane(10, 10);
        mainFlowPane.setAlignment(Pos.CENTER);

        Scene startScene = new Scene(startFlowPane, 700, 500);
        stage.setScene(startScene);

        stage.show();

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
        Button enter = new Button("Enter");
        enter.setOnAction(actionEvent -> {
            String textWidth = widthField.getText();
            width = Integer.parseInt(textWidth);
            String textHeigh = heighField.getText();
            heigh = Integer.parseInt(textHeigh);
            cells = new Button[heigh][width];
            states = new int[heigh][width];
            Scene mainScene = new Scene(mainFlowPane, 700, 500);
            stage.setScene(mainScene);
            fieldFilling();
        });
        hBox.getChildren().add(enter);
        vBox.getChildren().add(hBox);
        startFlowPane.getChildren().add(vBox);

    }

    public void fieldFilling() {
        vBox = new VBox();
        vBox.setSpacing(1.5);
        for (int i = 0; i < cells.length; i++) {
            hBox = new HBox();
            hBox.setSpacing(1);
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Button("  ");
                final int finI = i;
                final int finJ = j;
                cells[i][j].setOnAction(actionEvent -> {
                    System.out.println(finI);
                    System.out.println(finJ);

                    if (states[finI][finJ] == 0) {
                        states[finI][finJ] = 1;

                        cells[finI][finJ].setStyle("-fx-background-color: red");
                    } else {
                        states[finI][finJ] = 0;
                        cells[finI][finJ].setStyle("-fx-border-width: 1 1 1 1");
                    }
                });
                hBox.getChildren().add(cells[i][j]);
                // rootNode.getChildren().add(cell);
            }
            vBox.getChildren().add(hBox);
        }
        Label empty = new Label("");
        vBox.getChildren().add(empty);
        HBox control = new HBox();
        control.setSpacing(10);

        Button startStop = startStopButtonSetting();
        Button clear = clearButtonSetting();
        Button randomFilling = randomFillingButtonSetting();

        control.getChildren().add(startStop);
        control.getChildren().add(clear);
        control.getChildren().add(randomFilling);

        vBox.getChildren().add(control);
        mainFlowPane.getChildren().add(vBox);
    }
    public Button startStopButtonSetting() {
        Button startStop = new Button("Start");

        startStop.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
        startStopStatement = false;
        startStop.setOnAction(actionEvent -> {
            if (startStopStatement) {
                startStop.setText("Start");
                startStop.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
                startStopStatement = false;
            } else {
                startStop.setText("Stop");
                startStop.setStyle("-fx-text-fill: blue; -fx-background-color: red");
                startStopStatement = true;
            }
            // startStopStatement = startStopStatement? false : true;
            System.out.println(startStopStatement);
        });
        return startStop;
    }
    public Button clearButtonSetting() {
        Button clear = new Button("Clear");
        clear.setOnAction(actionEvent -> {

        });
        return clear;
    }
    public Button randomFillingButtonSetting() {
        Button randomFilling = new Button("Random filling");
        randomFilling.setOnAction(actionEvent -> {

        });
        return randomFilling;
    }

    @Override
    public void init() {
        System.out.println("In init method");
    }
    @Override
    public void stop() {
        System.out.println("In stop method");
    }

    public static void main(String[] args) {
        launch();
    }


}
