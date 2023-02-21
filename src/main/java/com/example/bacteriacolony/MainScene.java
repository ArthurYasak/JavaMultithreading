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
    static Button[][] mainCells;
    static  int[][] mainStates;
    static VBox vBox;
    static HBox[] hBoxes;
    static Scene createScene(Button[][] cells, int[][] states) {
        mainFlowPane = new FlowPane(10, 10);
        mainFlowPane.setAlignment(Pos.CENTER);
        mainCells = cells;
        mainStates = states;
        Scene mainScene = new Scene(mainFlowPane, 700, 500);
        controlPanelFilling();
        fieldFilling();

        return mainScene;
    }

    public static void controlPanelFilling() {
        vBox = new VBox();
        vBox.setSpacing(1.5);
        Label space = new Label("");
        vBox.getChildren().add(space);
        HBox controlPanel = new HBox();
        controlPanel.setSpacing(10);

        Button startStop = startStopButtonSetting();
        Button clear = clearButtonSetting();
        Button randomFilling = randomFillingButtonSetting();

        controlPanel.getChildren().add(startStop);
        // controlPanel.getChildren().add(clear);
        // controlPanel.getChildren().add(randomFilling);

        vBox.getChildren().add(controlPanel);
        mainFlowPane.getChildren().add(vBox);
    }
    public static void fieldFilling() {
        hBoxes = new HBox[mainCells.length];

        for (int i = 0; i < mainCells.length; i++) {
            hBoxes[i] = new HBox();
            hBoxes[i].setSpacing(1);
            for (int j = 0; j < mainCells[0].length; j++) {
                mainCells[i][j] = new Button("  ");
                if (mainStates[i][j] == 1) {
                    mainCells[i][j].setStyle("-fx-background-color: red");
                } else {
                    mainCells[i][j].setStyle("-fx-border-width: 1 1 1 1");
                }
                final int finI = i;
                final int finJ = j;
                mainCells[i][j].setOnAction(actionEvent -> {
                    System.out.print(finI + " : "+ finJ + "  state: ");

                    if (mainStates[finI][finJ] == 0) {
                        mainStates[finI][finJ] = 1;

                        mainCells[finI][finJ].setStyle("-fx-background-color: red");
                    } else {
                        mainStates[finI][finJ] = 0;
                        mainCells[finI][finJ].setStyle("-fx-border-width: 1 1 1 1");
                    }
                    System.out.println(mainStates[finI][finJ]);
                });

                hBoxes[i].getChildren().add(mainCells[i][j]);

            }
            vBox.getChildren().add(hBoxes[i]);
        }
    }
    public static void fieldUpdating() {
        for (int i = 0; i < mainCells.length; i++) {
            for (int j = 0; j < mainCells[0].length; j++) {
                hBoxes[i].getChildren().remove(mainCells[i][j]);
            }
            vBox.getChildren().remove(hBoxes[i]);
        }
        fieldFilling();
    }

    public static Button startStopButtonSetting() {
        Button startStop = new Button("Start");
        final boolean[] startStopStatement = {false};

        // FieldCalculation fieldCalculation = new FieldCalculation();
        // Thread calculationThread = new Thread(fieldCalculation);

        startStop.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
        // new Thread(() -> {
        startStop.setOnAction(actionEvent -> {
            if (startStopStatement[0]) {

                startStopStatement[0] = false;
                startStop.setText("Start");
                startStop.setStyle("-fx-text-fill: yellow; -fx-background-color: green");

            } else {

                startStopStatement[0] = true;
                startStop.setText("Stop");
                startStop.setStyle("-fx-text-fill: blue; -fx-background-color: red");

                FieldCalculation.calculate();
                FieldDrawing.draw();

                // while (startStopStatement[0]) {
                //     try {
                //         FieldCalculation.calculate();
                //         FieldDrawing.draw();
                //         Thread.sleep(2000);
                //     } catch (InterruptedException ie) {
                //         ie.printStackTrace();
                //     }
                // }

            }
            System.out.println("startStopStatement[0]:\n" + startStopStatement[0]);
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
