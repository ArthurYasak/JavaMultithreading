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
    public MainScene(Stage stage, CellsField cellsField) {
        this(700, 500, stage, cellsField);
    }
    public MainScene(double width, double height, Stage stage, CellsField cellsField) {
        super(width, height, stage);
        this.cellsField = cellsField;
    }
    @Override
    public void fill(Stage stage) {
        VBox vBox = controlPanelFill();
        bacteriaFieldFill(vBox);
    }
    public VBox controlPanelFill() {
        VBox vBox = new VBox();
        vBox.setSpacing(1.5);
        Label empty = new Label("");
        vBox.getChildren().add(empty);

        HBox controlPanel = new HBox();
        controlPanel.setSpacing(10);

        StartStopButton startStop = new StartStopButton();
        startStop.clickHandle(this, vBox);
        Button clear = clearButtonSetting();
        Button randomFilling = randomFillingButtonSetting();

        controlPanel.getChildren().add(startStop);

        // controlPanel.getChildren().add(clear);
        // controlPanel.getChildren().add(randomFilling);

        vBox.getChildren().add(controlPanel);

        flowPane.getChildren().add(vBox);
        return vBox;
    }
    public void bacteriaFieldFill(VBox vBox) {
        for (int i = 0; i < vBox.getChildren().size() - 2; i++) {
            vBox.getChildren().remove(i);
        }
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
    public Button oldStartStopButtonSet() {
        Button startStop = new Button("Start");
        final boolean[] startStopStatement = {false};
        // Thread guiThread = new Thread(() -> {
        //     FieldCalculation fieldCalculation = new FieldCalculation();
        //     Platform.runLater(() -> states = fieldCalculation.calculate(states));
        //     Platform.runLater(() -> fieldUpdating());
        //     try {
        //         wait(2000);
        //     } catch (InterruptedException ie) {
        //         ie.printStackTrace();
        //     }
        // });

        // FieldCalculation fieldCalculation = new FieldCalculation();
        // Thread calculationThread = new Thread(fieldCalculation);

        startStop.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
        // new Thread(() -> {   not throws Exception but App freezes when use sleep and while
        startStop.setOnAction(actionEvent -> {
            // new Thread(() -> {   IllegalStateException: Not on FX application thread; currentThread = Thread-3
            Service<Void> service = new Service<Void>() {
                @Override
                protected Task<Void> createTask() {
                    return new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {

                            if (startStopStatement[0]) {

                                startStopStatement[0] = false;
                                Platform.runLater(() -> startStop.setText("Start"));
                                startStop.setStyle("-fx-text-fill: yellow; -fx-background-color: green");

                            } else {
                                startStopStatement[0] = true;
                                Platform.runLater(() -> startStop.setText("Stop"));
                                startStop.setStyle("-fx-text-fill: blue; -fx-background-color: red");

                                FieldCalculation fieldCalculation = new FieldCalculation();
                                // states = fieldCalculation.calculate(states);
                                // fieldUpdating();

                                // while (startStopStatement[0]) {
                                //     try {
                                //         Thread.sleep(2000);
                                //     } catch (InterruptedException ie) {
                                //         ie.printStackTrace();
                                //     }
                                //     FieldCalculation fieldCalculation = new FieldCalculation();
                                //     states = fieldCalculation.calculate(states);
                                //     fieldUpdating();
                                // }


                                // new SleepService(states).start();


                                // while (startStopStatement[0]) {
                                //     guiThread.start();
                                //     try {
                                //         wait(2000);
                                //     } catch (InterruptedException ie) {
                                //         ie.printStackTrace();
                                //     }
                                //     // while (startStopStatement[0]) {
                                //     //     try {
                                //     //         FieldCalculation.calculate();
                                //     //         FieldDrawing.draw();
                                //     //         Thread.sleep(2000);
                                //     //     } catch (InterruptedException ie) {
                                //     //         ie.printStackTrace();
                                //     //     }
                                //     // }
                                // }
                            }
                            System.out.println("startStopStatement[0]:\n" + startStopStatement[0]);

                            return null;
                        }
                    };
                }
            };
            service.start();
        });
        return startStop;
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
