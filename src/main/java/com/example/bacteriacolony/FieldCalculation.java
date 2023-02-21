package com.example.bacteriacolony;

import java.util.Arrays;

public class FieldCalculation {
    static int[][] nextStates;

    // @Override
    // public void run() {
    //     calculate();
    // }
    public static void calculate() {
        System.out.println("Start calculating...");
        int width = MainScene.mainStates[0].length;
        int height = MainScene.mainStates.length;
        nextStates = new int[height][width];
        System.out.println("Previous states:\n" + Arrays.deepToString(MainScene.mainStates));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (MainScene.mainStates[i][j] == 0) {
                    int sum = 0;
                    for (int k = (i == 0 ? i : i - 1); k <= ((i == height - 1) ? i : i + 1); k++) {
                        for (int l = (j == 0 ? j : j - 1); l <= ((j == width - 1) ? j : j + 1); l++) {
                            sum += MainScene.mainStates[k][l];
                        }
                    }
                    if (sum == 3) {
                        nextStates[i][j] = 1;
                    } else {
                        nextStates[i][j] = 0;
                    }
                } else {
                    int sum = 0;
                    for (int k = (i == 0 ? i : i - 1); k <= ((i == height - 1) ? i : i + 1); k++) {
                        for (int l = (j == 0 ? j : j - 1); l <= ((j == width - 1) ? j : j + 1); l++) {
                            sum += MainScene.mainStates[k][l];
                        }
                    }
                    if (sum - 1 < 2 || sum - 1 > 4) {
                        nextStates[i][j] = 0;
                    } else {
                        nextStates[i][j] = 1;
                    }
                }
            }
        }
        System.out.println("Next states:\n" + Arrays.deepToString(nextStates));
    }

}
