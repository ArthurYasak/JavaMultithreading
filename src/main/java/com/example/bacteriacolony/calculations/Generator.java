package com.example.bacteriacolony.calculations;

import static java.lang.Math.*;

public class Generator {
    public int[][] generate(int height, int width) {
        int[][] arr = new int[height][width];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int)(random() * 1.15);
            }
        }
        return arr;
    }
}
