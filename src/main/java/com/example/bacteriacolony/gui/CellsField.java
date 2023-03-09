package com.example.bacteriacolony.gui;

public class CellsField {
    private int fieldWidth;
    private int fieldHeight;
    private int[][] cellsStates;
    private ButtonCell[][] cells;
    public CellsField(int fieldWidth, int fieldHeight) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.cells = new ButtonCell[fieldHeight][fieldWidth];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                this.cells[i][j] = new ButtonCell();
                this.cells[i][j].setText("  ");
                this.cells[i][j].clickHandle();
            }
        }
        this.cellsStates = new int[fieldHeight][fieldWidth];
    }
    void updateCellsStates() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                this.cellsStates[i][j] = cells[i][j].getCellState();
            }
        }
    }
    void updateGUI() {
        for (int i = 0; i < cells.length; i++ ) {
            for (int j = 0; j < cells[0].length; j++) {
                System.out.print(cells[i][j].getCellState() + " ");
                if (cellsStates[i][j] == 0) {
                    cells[i][j].setStyle("-fx-border-width: 1 1 1 1");
                    cells[i][j].setCellState(0);
                } else {
                    cells[i][j].setStyle("-fx-background-color: red");
                    cells[i][j].setCellState(1);
                }
            }
            System.out.println();
        }
    }
    int[][] getCellsStates() {
        return cellsStates;
    }

    void setCellsStates(int[][] cellsStates) {
        this.cellsStates = cellsStates;
    }

    ButtonCell[][] getCells() {
        return cells;
    }

}
