package com.example.bacteriacolony.gui;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnterHandler {
    void handle(TextField widthField, TextField heightField, Stage stage) {
        String textWidth = widthField.getText();
        int fieldWidth = Integer.parseInt(textWidth);
        String textHeigh = heightField.getText();
        int fieldHeight = Integer.parseInt(textHeigh);
        CellsField cellsField = new CellsField(fieldWidth, fieldHeight);
        MainScene mainScene = new MainScene(cellsField);
        mainScene.fill(stage);
        stage.setScene(mainScene);
    }
}
