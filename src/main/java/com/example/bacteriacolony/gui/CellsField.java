package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.calculations.FieldCalculation;

public class CellsField {
    private int fieldWidth;
    private int fieldHeight;
    private int[][] cellsStates;
    private Cell[][] cells;
    CellsField(int fieldWidth, int fieldHeight) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.cells = new Cell[fieldHeight][fieldWidth];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                this.cells[i][j] = new Cell();
                this.cells[i][j].setText("  ");
                this.cells[i][j].clickHandle();
            }
        }
        this.cellsStates = new int[fieldHeight][fieldWidth];
    }
    public void updateCalculationStates() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                this.cellsStates[i][j] = cells[i][j].getCellState();
            }
        }
    }
    public void updateGUI() {
        GUIUpdator guiUpdator = new GUIUpdator();
        cells = guiUpdator.update(cells);
    }
    public int getFieldWidth() {
        return this.fieldWidth;
    }
    public int getFieldHeight() {
        return this.fieldHeight;
    }

    public int[][] getCellsStates() {
        return cellsStates;
    }

    public void setCellsStates(int[][] cellsStates) {
        this.cellsStates = cellsStates;
    }

    public Cell[][] getCells() {
        return cells;
    }
    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
