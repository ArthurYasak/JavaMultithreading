package com.example.bacteriacolony;

import com.example.bacteriacolony.GUI.StartScene;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;

public class MoleculaApplication extends Application {
    @Override
    public void start(Stage stage) {

        stage.setTitle("My first App!");

        StartScene startScene = new StartScene();
        Scene firstScene = startScene.createScene(stage);
        stage.setScene(firstScene);
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
