package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.model.CellState;
import javafx.scene.control.Button;

public class CellButton extends Button {
    private CellState cellState;
    CellButton() {
        this.setText("  ");
        this.setOnAction(actionEvent -> {

            if (this.cellState == CellState.EMPTY) {
                this.cellState = CellState.FULL;
                this.setStyle("-fx-background-color: red");
            } else {
                this.cellState = CellState.EMPTY;
                this.setStyle("-fx-border-width: 1 1 1 1");
            }
            System.out.println(getCellState());

        });
    }
    public CellState getCellState() {
        return this.cellState;
    }

    void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
