package com.example.bacteriacolony.threads;

import com.example.bacteriacolony.gui.CellsFieldView;
import com.example.bacteriacolony.model.CellsFieldModel;
import com.example.bacteriacolony.model.FieldCalculation;

import java.util.concurrent.locks.Lock;

public class StartThread extends Thread {

    private StartThread(Runnable target) {
        super(target);
    }

    public static StartThread of(CellsFieldView cellsFieldView, CellsFieldModel cellsFieldModel, Lock lock) {

        FieldCalculation fieldCalculation = new FieldCalculation();
        int maxGenerations = cellsFieldModel.getMaxGenerations();

        return new StartThread(() -> {
            int i = 0;
            while (i < maxGenerations) {
                lock.lock();

                cellsFieldModel.updateCellsStates(cellsFieldView); // update states when start/stop button pushed
                int[][] nextStates = fieldCalculation.calculate(cellsFieldModel.getCellsStates()); // calculate next states using model method
                cellsFieldModel.setCellsStates(nextStates); //update cells states to next states
                cellsFieldView.updateGUI(nextStates); // update GUI of cellsField

                lock.unlock();

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
