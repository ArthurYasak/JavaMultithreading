package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.calculations.FieldCalculation;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScene extends MyScene {
    CellsField cellsField;
    public MainScene(CellsField cellsField) {
        this(700, 500, cellsField);
    }
    public MainScene(double width, double height, CellsField cellsField) {
        super(width, height);
        this.cellsField = cellsField;
    }
    @Override
    void fill(Stage stage) {
        VBox vBox = controlPanelFill();
        bacteriaFieldFill(vBox);
    }
    private VBox controlPanelFill() {
        VBox vBox = new VBox();
        vBox.setSpacing(1.5);
        Label empty = new Label("");
        vBox.getChildren().add(empty);

        HBox controlPanel = new HBox();
        controlPanel.setSpacing(10);

        StartStopButton startStop = new StartStopButton();
        startStop.clickHandle(this);

        controlPanel.getChildren().add(startStop);

        vBox.getChildren().add(controlPanel);

        flowPane.getChildren().add(vBox);
        return vBox;
    }
    private void bacteriaFieldFill(VBox vBox) {
        Button[][] cells = cellsField.getCells();
        HBox[] hBoxes = new HBox[cells.length];
        for (int i = 0; i < cells.length; i++) {
            hBoxes[i] = new HBox();
            hBoxes[i].setSpacing(1);
            for (int j = 0; j < cells[0].length; j++) {
                hBoxes[i].getChildren().add(cells[i][j]);
            }
            vBox.getChildren().add(i, hBoxes[i]);
        }
    }

    /**
     * now is not uses
     */
    private class SleepService extends Service<int[][]> {
        private static final int SLEEP_TIME = 2000;
        private SleepService(int[][] statements) {

            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {
                    FieldCalculation fieldCalculation = new FieldCalculation();
                    // states = fieldCalculation.calculate(states);
                }
            });
        }
        @Override
        protected Task createTask() {
            return new Task() {
                @Override
                protected String call() throws InterruptedException {
                    Thread.sleep(SLEEP_TIME);

                    return "nextStates";
                }
            };
        }
    }

}
