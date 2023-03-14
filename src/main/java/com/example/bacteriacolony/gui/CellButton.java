package com.example.bacteriacolony.gui;

import javafx.scene.control.Button;

public class CellButton extends Button {
    private int cellState;

    void clickHandle() {
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
    int getCellState() {
        return cellState;
    }

    void setCellState(int cellState) {
        this.cellState = cellState;
    }
}
