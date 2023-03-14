package com.example.bacteriacolony;

import com.example.bacteriacolony.gui.*;
import javafx.application.Application;
import javafx.stage.*;

public class MoleculaApp extends Application {
    @Override
    public void start(Stage stage) {

        stage.setTitle("My first App!");
        stage.setOnCloseRequest((eventHandler) -> System.exit(0));

        StartScene startScene = new StartScene(500,300, stage);
        stage.setScene(startScene);
        stage.show();

    }

    @Override
    public void init() {
        System.out.println("In init method");
    }
    @Override
    public void stop() {
        System.out.println("In stop method");
    }

    public static void main(String[] args) {
        launch();
    }


}
