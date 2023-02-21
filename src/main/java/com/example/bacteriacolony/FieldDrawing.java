package com.example.bacteriacolony;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;

public class FieldDrawing {
    // @Override
    // public void run() {
    //     draw();
    // }
    public static void draw() {
        int width = MainScene.mainCells[0].length;
        int height = MainScene.mainCells.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                MainScene.mainStates[i][j] = FieldCalculation.nextStates[i][j];
            }
        }
        MainScene.fieldUpdating();
    }
}
