package com.example.rsa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RsaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RsaApplication.class.getResource("rsa.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("RSA Danny & Jerry");
        stage.setScene(scene);
        stage.show();

        RsaController controller = (RsaController)fxmlLoader.getController();
        controller.setCurrentStage(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}