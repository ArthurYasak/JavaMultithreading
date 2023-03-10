package com.example.bacteriacolony.calculations;

import java.util.Arrays;

public class FieldCalculation {
    // @Override
    // public void run() {
    //     calculate();
    // }
    public int[][] calculate(int[][] lastStates) {
        int width = lastStates[0].length;
        int height = lastStates.length;
        int[][] nextStates = new int[height][width];
        // System.out.println("Previous states:\n" + Arrays.deepToString(lastStates));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (lastStates[i][j] == 0) {
                    int sum = 0;
                    for (int k = (i == 0 ? i : i - 1); k <= ((i == height - 1) ? i : i + 1); k++) {
                        for (int l = (j == 0 ? j : j - 1); l <= ((j == width - 1) ? j : j + 1); l++) {
                            sum += lastStates[k][l];
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
                            sum += lastStates[k][l];
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
        // System.out.println("Next states:\n" + Arrays.deepToString(nextStates));
        return nextStates;
    }
}
