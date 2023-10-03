//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("../ui/ClientChat.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300.0, 275.0));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
