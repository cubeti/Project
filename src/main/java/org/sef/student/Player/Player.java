package org.sef.student.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.web.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import java.io.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class Player
{
    static Button b1;
    static Button b2;
    static VBox tile;
    public static void start(Stage stage)
    {
        stage.setTitle("Player Menu");

        Button b1= new Button();
        Button b2= new Button();
        b1.setTextFill(Color.RED);
        b2.setTextFill(Color.BLUE);
        b1.setText("Add game");
        b2.setText("Match History");
        VBox tile=new VBox(20);
        Label label1= new Label("Choose one option");
        label1.setFont(Font.font("Comic Sans",15));
        label1.setTextFill(Color.BLACK);
        tile.getChildren().add(label1);
        tile.getChildren().add(b1);
        tile.getChildren().add(b2);
        Scene scene=new Scene(tile,600,800);

        EventHandler<ActionEvent>event1= new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label1.setText("Add game button selected");
                label1.setFont(Font.font("Comic Sans",15));
                label1.setTextFill(Color.BLACK);
                VBox add=new VBox(20);
                Label add_label=new Label("Game begins");
                add_label.setFont(Font.font("Comic Sans",15));
                add_label.setTextFill(Color.BLACK);
                Button back1= new Button("Back");
                back1.setTextFill(Color.BLUE);
                back1.setOnAction(e -> stage.setScene(scene));
                add.getChildren().addAll(label1,add_label,back1);
                Scene scene1=new Scene(add,600,800);
                BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW,CornerRadii.EMPTY,Insets.EMPTY);
                Background backround=new Background(backround_fill);
                add.setAlignment(Pos.CENTER);
                add.setBackground(backround);
                stage.setScene(scene1);
            }
        };
        EventHandler<ActionEvent> event2= new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label1.setText("History button selected");
                label1.setFont(Font.font("Comic Sans",15));
                label1.setTextFill(Color.BLACK);
                VBox history=new VBox(20);
                Label label_history=new Label("Watch previous games!");
                label_history.setFont(Font.font("Comic Sans",15));
                label_history.setTextFill(Color.BLACK);
                Button back1= new Button("Back");
                back1.setTextFill(Color.BLUE);
                back1.setOnAction(e -> stage.setScene(scene));
                history.getChildren().addAll(label1,label_history,back1);
                Scene scene2=new Scene(history,600,800);
                BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW,CornerRadii.EMPTY,Insets.EMPTY);
                Background backround=new Background(backround_fill);
                history.setAlignment(Pos.CENTER);
                history.setBackground(backround);
                stage.setScene(scene2);
            }
        };
        b1.setOnAction(event1);
        b2.setOnAction(event2);
        BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW,CornerRadii.EMPTY,Insets.EMPTY);
        Background backround=new Background(backround_fill);
        tile.setAlignment(Pos.CENTER);
        tile.setBackground(backround);

        stage.setScene(scene);
        stage.show();
    }
}