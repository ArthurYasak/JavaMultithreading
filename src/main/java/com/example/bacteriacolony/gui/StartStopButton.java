package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.calculations.FieldCalculation;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class StartStopButton extends Button {
    private boolean startStopState;
    private MainScene mainScene;
    public StartStopButton() {
        this.mainScene = mainScene;
        this.setText("Start");
        this.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
    }
    public CellsField clickHandle(MainScene mainScene, VBox vBox) {
        FieldCalculation fieldCalculation = new FieldCalculation();
        CellsField cellsField = mainScene.cellsField;
        this.setOnAction(actionEvent -> {
            if (! startStopState) {
                startStopState = true;
                this.setText("Stop");
                this.setStyle("-fx-text-fill: blue; -fx-background-color: red");
                cellsField.updateCalculationStates(); // update states when start/stop button pushed
                int[][] nextStates = fieldCalculation.calculate(cellsField.getCellsStates()); // calculate next states with model
                cellsField.setCellsStates(nextStates); //update states to next states
                cellsField.updateGUI(); // update GUI of cellsField
                mainScene.bacteriaFieldFill(vBox);
                System.out.println(startStopState);
            } else {
                startStopState = false;
                this.setText("Start");
                this.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
                System.out.println(startStopState);
            }
        });
    return cellsField;
    }

    public boolean isStartStopState() {
        return startStopState;
    }

    public void setStartStopState(boolean startStopState) {
        this.startStopState = startStopState;
    }
}
