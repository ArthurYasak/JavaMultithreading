package com.example.bacteriacolony;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static java.lang.Math.*;

public class Generator {
    static int width;
    static int heigh;
    int[][] field;
    Generator(int width, int heigh){
        this.width = width;
        this.heigh = heigh;
    }
    public static int[][] generate() {
        int[][] arr = new int[heigh][width];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int)(random() * 1.15);
            }
        }
        return arr;
    }
}
