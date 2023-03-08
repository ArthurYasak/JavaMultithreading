package com.example.bacteriacolony.gui;

import javafx.scene.control.Button;

import java.util.Arrays;

public class GUIUpdator {
    public Cell[][] update(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++ ) {
            for (int j = 0; j < cells[0].length; j++) {
                System.out.print(cells[i][j].getCellState() + " ");
                if (cells[i][j].getCellState() == 0) {
                    cells[i][j].setStyle("-fx-border-width: 1 1 1 1");
                } else {
                    cells[i][j].setStyle("-fx-background-color: red");
                }
            }
            System.out.println();
        }
        return cells;
    }
}
