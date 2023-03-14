package com.example.bacteriacolony.gui;

import javafx.scene.control.Button;

public class ExitButton extends Button {

    ExitButton() {
        this.setText("Exit");
    }

    void clickHandle() {
        this.setOnAction(actionEvent -> System.exit(0));
    }
}
