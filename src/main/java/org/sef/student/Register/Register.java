package org.sef.student.Register;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
public class Register {
    Button button2;
    Scene regscene;
    public Scene getScene(Scene s,Stage w) throws Exception
    {
        button2 = new Button("Login!");
        button2.setOnAction(e -> w.setScene(s));

        //layout 2
        Label label2=new Label("Register page");
        VBox layout2=new VBox(50);
        layout2.getChildren().addAll(label2,button2);
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        regscene = new Scene(root,1600,900);
        return regscene;
    }
}
