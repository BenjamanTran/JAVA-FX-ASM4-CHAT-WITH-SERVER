package controller;

import business.ServerThread;
import com.entity.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public final String SERVER_NAME = "localhost";
    public final int PORT = 1234;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../ui/ServerBox.fxml"));
        primaryStage.setTitle("Server Application");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        try {
            Server server = new Server(SERVER_NAME, PORT);
            ServerThread serverThread = new ServerThread(server);
            new Thread(serverThread).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //start the server and ready for client's connection

    }


    public static void main(String[] args) {
        launch(args);
    }
}
