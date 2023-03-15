package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.model.CellState;

public class CellsFieldView {
    private int fieldWidth;
    private int fieldHeight;
    private CellButton[][] cells;
    CellsFieldView(int fieldWidth, int fieldHeight) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.cells = new CellButton[fieldHeight][fieldWidth];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                this.cells[i][j] = new CellButton();
            }
        }
    }
    public void updateGUI(int[][] cellsStates) {

        for (int i = 0; i < cells.length; i++ ) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cellsStates[i][j] == 0) {
                    cells[i][j].setStyle("-fx-border-width: 1 1 1 1");
                    cells[i][j].setCellState(CellState.EMPTY);
                } else {
                    cells[i][j].setStyle("-fx-background-color: red");
                    cells[i][j].setCellState(CellState.FULL);
                }
            }
        }
    }
    public CellButton[][] getCells() {
        return this.cells;
    }
}
