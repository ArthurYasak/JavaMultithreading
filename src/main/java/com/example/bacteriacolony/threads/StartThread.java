package com.example.bacteriacolony.threads;

import com.example.bacteriacolony.calculations.FieldCalculation;
import com.example.bacteriacolony.gui.CellsField;
import com.example.bacteriacolony.gui.MainScene;

import java.util.concurrent.locks.Lock;

public class StartThread extends Thread {

    private StartThread(Runnable target) {
        super(target);
    }

    public static StartThread of(MainScene mainScene, Lock lock) {
        FieldCalculation fieldCalculation = new FieldCalculation();
        CellsField cellsField = mainScene.getCellsField();
        return new StartThread(() -> {
            int i = 0;
            while (true) {
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
            }
        });
    }
}
