package com.example.bacteriacolony.gui;

import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public abstract class MyScene extends Scene {
    FlowPane flowPane;
    private double width;
    private double height;
    public MyScene() {
        this(500, 300);
    }
    public MyScene(double width, double height) {
        this(new FlowPane(10,10), width, height);
    }
    public MyScene(@NamedArg("root") FlowPane var1, @NamedArg("width") double var2, @NamedArg("height") double var4) {
        super(var1, var2, var4);
        this.flowPane = var1;
        var1.setAlignment(Pos.CENTER);
        this.width = var2;
        this.height = var4;
    }
    abstract void fill(Stage stage);

}
