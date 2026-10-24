package com.mycompany.lab5;


/**
 *
 * @author sriya
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/mycompany/lab5/view/PersonForm.fxml"));

        stage.setTitle("Registration Form - JavaFX MVC");
        stage.setScene(new Scene(root));
        stage.setMinWidth(480);
        stage.setMinHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}