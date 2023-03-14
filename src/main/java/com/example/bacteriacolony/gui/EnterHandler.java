package com.example.bacteriacolony.gui;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnterHandler {
    void handle(TextField widthField, TextField heightField, TextField generationsField) {
        String textWidth = widthField.getText();
        int fieldWidth = Integer.parseInt(textWidth);
        String textHeight = heightField.getText();
        int fieldHeight = Integer.parseInt(textHeight);
        String textGenerations = generationsField.getText();
        int maxGenerations = Integer.parseInt(textGenerations);

        Stage secondStage = new Stage();
        secondStage.show();
        secondStage.setOnCloseRequest(windowEvent -> System.exit(0));

        CellsField cellsField = new CellsField(fieldWidth, fieldHeight, maxGenerations);
        MainScene mainScene = new MainScene(300 + (fieldWidth <= 9 ? 0 : (fieldWidth - 9) * 25),
                80 + fieldHeight * 30, cellsField);
        mainScene.fill(secondStage);
        secondStage.setScene(mainScene);
    }
}
