package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.calculations.FieldCalculation;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class StartStopButton extends Button {
    private boolean startStopState;
    public StartStopButton() {
        this.setText("Start");
        this.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
    }
    CellsField clickHandle(MainScene mainScene) {
        FieldCalculation fieldCalculation = new FieldCalculation();
        CellsField cellsField = mainScene.getCellsField();
        System.out.println(mainScene.getCellsField());
        System.out.println(cellsField);
        this.setOnAction(actionEvent -> {
            if (! startStopState) {
                startStopState = true;
                this.setText("Stop");
                this.setStyle("-fx-text-fill: blue; -fx-background-color: red");

                cellsField.updateCellsStates(); // update states when start/stop button pushed
                int[][] nextStates = fieldCalculation.calculate(cellsField.getCellsStates()); // calculate next states with model
                cellsField.setCellsStates(nextStates); //update states to next states
                System.out.println(Arrays.deepToString(cellsField.getCellsStates()));
                cellsField.updateGUI(); // update GUI of cellsField

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
}
