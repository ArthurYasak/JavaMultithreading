package com.example.bacteriacolony.gui;

import javafx.scene.control.Button;

public class Cell extends Button {
    private int cellState;

    public void clickHandle() {
        this.setOnAction(actionEvent -> {

            if (getCellState() == 0) {
                setCellState(1);
                this.setStyle("-fx-background-color: red");
            } else {
                setCellState(0);

                this.setStyle("-fx-border-width: 1 1 1 1");
            }
            System.out.println(getCellState());
        });
    }
    public void stopClickHandle() {
        this.setOnAction(actionEvent -> { });
    }

    public int getCellState() {
        return cellState;
    }

    public void setCellState(int cellState) {
        this.cellState = cellState;
    }
}
