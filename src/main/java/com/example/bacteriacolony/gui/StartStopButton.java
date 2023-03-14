package com.example.bacteriacolony.gui;

import com.example.bacteriacolony.threads.StartThread;
import javafx.scene.control.Button;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StartStopButton extends Button {
    private boolean startStopState;
    StartStopButton() {
        this.setText("Start");
        this.setStyle("-fx-text-fill: yellow; -fx-background-color: green");
    }
    void clickHandle(CellsField cellsField) {
        Lock lock = new ReentrantLock();

        StartThread startThread = StartThread.of(cellsField, lock);

        startThread.start();
        lock.lock();

        this.setOnAction(actionEvent -> {

            if (! startStopState) {
                startStopState = true;

                this.setText("Stop");
                this.setStyle("-fx-text-fill: blue; -fx-background-color: red");

                lock.unlock();

            } else {
                startStopState = false;

                this.setText("Start");
                this.setStyle("-fx-text-fill: yellow; -fx-background-color: green");

                lock.lock();
            }
        });
    }
}