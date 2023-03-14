package com.example.bacteriacolony.gui;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnterHandler {
    void handle(TextField widthField, TextField heightField, TextField generationsField, Stage stage) {
        String textWidth = widthField.getText();
        int fieldWidth = Integer.parseInt(textWidth);
        String textHeight = heightField.getText();
        int fieldHeight = Integer.parseInt(textHeight);
        String textGenerations = generationsField.getText();
        int maxGenerations = Integer.parseInt(textGenerations);

        CellsField cellsField = new CellsField(fieldWidth, fieldHeight, maxGenerations);
        MainScene mainScene = new MainScene(400 + (fieldWidth <= 9 ? 0 : (fieldWidth - 9) * 40),
                300 + (fieldHeight <= 7 ? 0 : (fieldHeight - 9) * 40), cellsField);
        mainScene.fill(stage);
        stage.setScene(mainScene);
    }
}
