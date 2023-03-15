package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.model.CellsFieldModel;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnterButton extends Button {
    EnterButton(Stage stage, TextField widthField, TextField heightField, TextField generationsField) {
        this.setText("Enter");
        this.setOnAction(actionEvent -> {
            stage.close();
            String textWidth = widthField.getText();
            int fieldWidth = Integer.parseInt(textWidth);
            String textHeight = heightField.getText();
            int fieldHeight = Integer.parseInt(textHeight);
            String textGenerations = generationsField.getText();
            int maxGenerations = Integer.parseInt(textGenerations);

            Stage secondStage = new Stage();
            secondStage.setTitle("Bacteria field simulations");
            secondStage.show();
            secondStage.setOnCloseRequest(windowEvent -> System.exit(0));

            CellsFieldView cellsFieldView = new CellsFieldView(fieldWidth, fieldHeight);
            CellsFieldModel cellsFieldModel = new CellsFieldModel(fieldWidth, fieldHeight, maxGenerations);
            MainScene mainScene = new MainScene(300 + (fieldWidth <= 9 ? 0 : (fieldWidth - 9) * 25),
                    80 + fieldHeight * 30, cellsFieldView, cellsFieldModel);
            mainScene.fill(secondStage);
            secondStage.setScene(mainScene);
        });
    }
}
