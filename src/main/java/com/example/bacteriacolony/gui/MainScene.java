package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.model.CellsFieldModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScene extends MyScene {
    private CellsFieldView cellsFieldView;
    private CellsFieldModel cellsFieldModel;
    public MainScene(CellsFieldView cellsFieldView, CellsFieldModel cellsFieldModel) {
        this(500, 300, cellsFieldView, cellsFieldModel);
    }
    public MainScene(double width, double height, CellsFieldView cellsFieldView, CellsFieldModel cellsFieldModel) {
        super(width, height);
        this.cellsFieldView = cellsFieldView;
        this.cellsFieldModel = cellsFieldModel;
    }
    @Override
    void fill(Stage stage) {
        VBox vBox = controlPanelFill();
        bacteriaFieldFill(vBox);
    }
    private VBox controlPanelFill() {
        VBox vBox = new VBox();
        vBox.setSpacing(1.5);
        Label empty = new Label("");
        vBox.getChildren().add(empty);

        HBox controlPanel = new HBox();
        controlPanel.setSpacing(10);

        StartStopButton startStopButton = new StartStopButton(this.cellsFieldView, this.cellsFieldModel);
        GeneratorButton generatorButton = new GeneratorButton(this.cellsFieldView, this.cellsFieldModel);
        ClearButton clearButton = new ClearButton(this.cellsFieldView, this.cellsFieldModel);
        ExitButton exitButton = new ExitButton();

        controlPanel.getChildren().add(startStopButton);
        controlPanel.getChildren().add(generatorButton);
        controlPanel.getChildren().add(clearButton);
        controlPanel.getChildren().add(exitButton);

        vBox.getChildren().add(controlPanel);

        flowPane.getChildren().add(vBox);
        return vBox;
    }
    private void bacteriaFieldFill(VBox vBox) {
        Button[][] cells = cellsFieldView.getCells();
        HBox[] hBoxes = new HBox[cells.length];
        for (int i = 0; i < cells.length; i++) {
            hBoxes[i] = new HBox();
            hBoxes[i].setSpacing(1);
            for (int j = 0; j < cells[0].length; j++) {
                hBoxes[i].getChildren().add(cells[i][j]);
            }
            vBox.getChildren().add(i, hBoxes[i]);
        }
    }
}
