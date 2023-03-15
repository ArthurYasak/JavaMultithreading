package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.model.CellsFieldModel;
import com.example.bacteriacolony.model.Generator;
import javafx.scene.control.Button;

public class GeneratorButton extends Button {

    GeneratorButton(CellsFieldView cellsFieldView, CellsFieldModel cellsFieldModel) {
        this.setText("Generate");
        this.setOnAction((actionEvent) -> {
            Generator generator = new Generator();

            int fieldWidth = cellsFieldModel.getFieldWidth();
            int fieldHeight = cellsFieldModel.getFieldHeight();
            int[][] generatedStates = generator.generate(fieldWidth, fieldHeight);
            cellsFieldModel.setCellsStates(generatedStates);
            int[][] nextStates = cellsFieldModel.getCellsStates();
            cellsFieldView.updateGUI(nextStates);
        });
    }
}
