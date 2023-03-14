package com.example.bacteriacolony.gui;

public class CellsField {
    private int fieldWidth;
    private int fieldHeight;
    private int maxGenerations;
    private int[][] cellsStates;
    private CellButton[][] cells;
    public CellsField(int fieldWidth, int fieldHeight, int maxGenerations) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.maxGenerations = maxGenerations;
        this.cells = new CellButton[fieldHeight][fieldWidth];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                this.cells[i][j] = new CellButton();
                this.cells[i][j].setText("  ");
                this.cells[i][j].clickHandle();
            }
        }
        this.cellsStates = new int[fieldHeight][fieldWidth];
    }
    public void updateCellsStates() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                this.cellsStates[i][j] = cells[i][j].getCellState();
            }
        }
    }
    public void updateGUI() {
        for (int i = 0; i < cells.length; i++ ) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cellsStates[i][j] == 0) {
                    cells[i][j].setStyle("-fx-border-width: 1 1 1 1");
                    cells[i][j].setCellState(0);
                } else {
                    cells[i][j].setStyle("-fx-background-color: red");
                    cells[i][j].setCellState(1);
                }
            }
        }
    }
    public int getMaxGenerations() {
        return this.maxGenerations;
    }
    public int[][] getCellsStates() {
        return cellsStates;
    }

    public void setCellsStates(int[][] cellsStates) {
        this.cellsStates = cellsStates;
    }

    CellButton[][] getCells() {
        return cells;
    }
    public int getFieldWidth() {
        return this.fieldWidth;
    }
    public int getFieldHeight() {
        return this.fieldHeight;
    }

}
