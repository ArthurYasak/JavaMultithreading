package com.example.bacteriacolony.model;

import com.example.bacteriacolony.gui.CellButton;
import com.example.bacteriacolony.gui.CellsFieldView;

public class CellsFieldModel {
    private int fieldWidth;
    private int fieldHeight;
    private int maxGenerations;
    private int[][] cellsStates;
    public CellsFieldModel(int fieldWidth, int fieldHeight, int maxGenerations) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.maxGenerations = maxGenerations;
        this.cellsStates = new int[fieldHeight][fieldWidth];
    }
    public void updateCellsStates(CellsFieldView cellsFieldView) {
        CellButton[][] cells = cellsFieldView.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                this.cellsStates[i][j] = cells[i][j].getCellState() == CellState.EMPTY ? 0 : 1;
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

    public int getFieldWidth() {
        return this.fieldWidth;
    }
    public int getFieldHeight() {
        return this.fieldHeight;
    }

}
