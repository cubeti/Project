package org.sef.student.Login;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import org.sef.student.Register.Register;

import java.io.IOException;
import java.util.Objects;

public class Login extends Application{
    Button button1,button2;
    public static Stage window;
    public static Scene scene1;
    public static void run(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        window=primaryStage;
        window.setTitle("LOL app");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
        scene1 = new Scene(root);
        window.setScene(scene1);
        window.show();
        }
        public static Stage getWindow()
        {
            return window;
        }
    public static Scene getScene()
    {
        return scene1;
    }
}
