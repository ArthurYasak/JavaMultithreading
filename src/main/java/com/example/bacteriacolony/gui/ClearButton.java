package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.model.CellsFieldModel;
import javafx.scene.control.Button;

public class ClearButton extends Button {
    ClearButton(CellsFieldView cellsFieldView, CellsFieldModel cellsFieldModel) {
        this.setText("Clear");
        this.setOnAction(actionEvent -> {

            int width = cellsFieldModel.getFieldWidth();
            int height = cellsFieldModel.getFieldHeight();
            int[][] emptyField = new int[height][width];
            cellsFieldModel.setCellsStates(emptyField);
            cellsFieldView.updateGUI(emptyField);

        });
    }
}
