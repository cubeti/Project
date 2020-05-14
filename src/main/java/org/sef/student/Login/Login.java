package org.sef.student.Login;
import javafx.application.Application;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import org.sef.student.Register.Register;

public class Login extends Application{
    Button button1,button2;
    Stage window;
    Scene scene1,scene2;
    public static void run(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        window=primaryStage;
        window.setTitle("LOL app");

        Label label1=new Label("Login page");
        VBox layout1 = new VBox(50);


        //button1
        button1 = new Button("New Here?Register!");
        button1.setOnAction(e -> {
            Register reg=new Register();

            Scene regscene = null;
            try {
                regscene = reg.getScene(scene1, window);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            window.setScene(regscene);
        });

        layout1.getChildren().addAll(label1,button1);
        scene1 = new Scene(layout1,1600,900);
        window.setScene(scene1);
        window.show();
        }
}
