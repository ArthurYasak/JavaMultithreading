package com.example.bacteriacolony;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainScene {
    static FlowPane mainFlowPane;
    static Scene createScene(int width, int height) {
        mainFlowPane = new FlowPane(10, 10);
        mainFlowPane.setAlignment(Pos.CENTER);
        Scene mainScene = new Scene(mainFlowPane, 700, 500);
        fieldFilling(width, height);
        return mainScene;
    }

    public static void fieldFilling(int width, int height) {
        VBox vBox = new VBox();
        vBox.setSpacing(1.5);
        Button[][] cells = new Button[height][width];
        int[][] states = new int[height][width];
        for (int i = 0; i < cells.length; i++) {
            HBox hBox = new HBox();
            hBox.setSpacing(1);
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Button("  ");
                final int finI = i;
                final int finJ = j;
                cells[i][j].setOnAction(actionEvent -> {
                    System.out.print(finI + " : "+ finJ + "  state: ");

                    if (states[finI][finJ] == 0) {
                        states[finI][finJ] = 1;

                        cells[finI][finJ].setStyle("-fx-background-color: red");
                    } else {
                        states[finI][finJ] = 0;
                        cells[finI][finJ].setStyle("-fx-border-width: 1 1 1 1");
                    }
                    System.out.println(states[finI][finJ]);
                });
                hBox.getChildren().add(cells[i][j]);
            }
            vBox.getChildren().add(hBox);
        }
        Label empty = new Label("");
        vBox.getChildren().add(empty);
        HBox controlPanel = new HBox();
        controlPanel.setSpacing(10);

        Button startStop = startStopButtonSetting();
        Button clear = clearButtonSetting();
        Button randomFilling = randomFillingButtonSetting();

        controlPanel.getChildren().add(startStop);
        controlPanel.getChildren().add(clear);
        controlPanel.getChildren().add(randomFilling);

        vBox.getChildren().add(controlPanel);
        mainFlowPane.getChildren().add(vBox);
    }

    public static Button startStopButtonSetting() {
        Button startStop = new Button("Start");

        startStop.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
        final boolean[] startStopStatement = {false};
        startStop.setOnAction(actionEvent -> {
            if (startStopStatement[0]) {
                startStop.setText("Start");
                startStop.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
                startStopStatement[0] = false;
            } else {
                startStop.setText("Stop");
                startStop.setStyle("-fx-text-fill: blue; -fx-background-color: red");
                startStopStatement[0] = true;
            }
            // startStopStatement = startStopStatement? false : true;
            System.out.println(startStopStatement[0]);
        });
        return startStop;
    }
    public static Button clearButtonSetting() {
        Button clear = new Button("Clear");
        clear.setOnAction(actionEvent -> {

        });
        return clear;
    }
    public static Button randomFillingButtonSetting() {
        Button randomFilling = new Button("Random filling");
        randomFilling.setOnAction(actionEvent -> {

        });
        return randomFilling;
    }
}
