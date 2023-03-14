package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.calculations.Generator;
import javafx.scene.control.Button;

public class GeneratorButton extends Button {

    GeneratorButton() {
        this.setText("Generate");
    }

    void clickHandle(CellsField cellsField) {
        this.setOnAction((actionEvent) -> {
            Generator generator = new Generator();

            int fieldWidth = cellsField.getFieldWidth();
            int fieldHeight = cellsField.getFieldHeight();
            int[][] generatedStates = generator.generate(fieldWidth, fieldHeight);
            cellsField.setCellsStates(generatedStates);
            cellsField.updateGUI();
        });
    }
}
