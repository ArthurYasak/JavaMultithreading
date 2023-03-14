package com.example.bacteriacolony.gui;

import javafx.scene.control.Button;

public class ClearButton extends Button {
    ClearButton() {
        this.setText("Clear");
    }
    void clickHandle(CellsField cellsField) {
        this.setOnAction(actionEvent -> {

            int width = cellsField.getFieldWidth();
            int height = cellsField.getFieldHeight();
            int[][] emptyField = new int[height][width];
            cellsField.setCellsStates(emptyField);
            cellsField.updateGUI();

        });
    }
}
