package com.example.bacteriacolony.threads;

import com.example.bacteriacolony.calculations.FieldCalculation;
import com.example.bacteriacolony.gui.CellsField;

import java.util.concurrent.locks.Lock;

public class StartThread extends Thread {

    private StartThread(Runnable target) {
        super(target);
    }

    public static StartThread of(CellsField cellsField, Lock lock) {

        FieldCalculation fieldCalculation = new FieldCalculation();
        int maxGenerations = cellsField.getMaxGenerations();

        return new StartThread(() -> {
            int i = 0;
            while (i < maxGenerations) {
                lock.lock();
                lock.unlock();

                cellsField.updateCellsStates(); // update states when start/stop button pushed
                int[][] nextStates = fieldCalculation.calculate(cellsField.getCellsStates()); // calculate next states using model method
                cellsField.setCellsStates(nextStates); //update cells states to next states
                cellsField.updateGUI(); // update GUI of cellsField

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }

                i++;
            }
        });
    }
}
