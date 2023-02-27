package com.example.bacteriacolony.GUI;

import com.example.bacteriacolony.calculations.FieldCalculation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainScene {
    private FlowPane mainFlowPane;
    private Button[][] cells;
    private int[][] states;
    private VBox vBox;
    private HBox[] hBoxes;
    Scene createScene(int width, int height) {
        cells = new Button[height][width];
        states = new int[height][width];
        mainFlowPane = new FlowPane(10, 10);
        mainFlowPane.setAlignment(Pos.CENTER);
        Scene mainScene = new Scene(mainFlowPane, 700, 500);

        controlPanelFilling();
        fieldFilling();

        return mainScene;
    }

    public void controlPanelFilling() {
        vBox = new VBox();
        vBox.setSpacing(1.5);
        Label empty = new Label("");
        vBox.getChildren().add(empty);
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

    public void fieldFilling() {
        hBoxes = new HBox[cells.length];
        for (int i = 0; i < cells.length; i++) {
            hBoxes[i] = new HBox();
            hBoxes[i].setSpacing(1);

            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Button("  ");
                if (states[i][j] == 1) {
                    cells[i][j].setStyle("-fx-background-color: red");
                } else {
                    cells[i][j].setStyle("-fx-border-width: 1 1 1 1");
                }
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

                hBoxes[i].getChildren().add(cells[i][j]);
            }
            vBox.getChildren().add(0, hBoxes[i]);
        }
    }

    public void fieldUpdating() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                hBoxes[i].getChildren().remove(cells[i][j]);
            }
            vBox.getChildren().remove(hBoxes[i]);
        }
        fieldFilling();
    }

    public Button startStopButtonSetting() {
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
                FieldCalculation fieldCalculation = new FieldCalculation();
                states = fieldCalculation.calculate(states);
                fieldUpdating();

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
}
