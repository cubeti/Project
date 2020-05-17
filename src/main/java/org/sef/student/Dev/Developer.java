package org.sef.student.Dev;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.sef.student.Exceptions.ChampExistsExeption;
import org.sef.student.Exceptions.ItemExistsExeption;
import org.sef.student.Model.Champion;
import org.sef.student.Services.Champions;
import org.sef.student.Services.Items;
import org.sef.student.Services.Users;

public class Developer {
    private static VBox vbox;
    public static void start(Stage stage){

        stage.setTitle("Developer menu");

        Button b1 = new Button();
        Button b2 = new Button();
        Button b3 = new Button();
        Button b4 = new Button();
        b1.setText("Add Item");
        b1.setTextFill(Color.RED);
        b2.setText("Add a champion");
        b2.setTextFill(Color.RED);
        b3.setTextFill(Color.RED);
        b3.setText("Press for feedback");
        b4.setText("See the champions stats");
        b4.setTextFill(Color.RED);
        Label label1=new Label("Choose one option");
        label1.setFont(Font.font("Comic Sans",15));
        label1.setTextFill(Color.BLACK);
        vbox=new VBox(20);
        vbox.getChildren().addAll(label1,b1,b2,b4,b3);
        Scene scene= new Scene(vbox,800,600);

        //add item
        EventHandler<ActionEvent> event1=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button add= new Button("Add");
                add.setTextFill(Color.RED);
                TextField text=new TextField();
                text.setFont(Font.font("Comic Sans",15));
                Label label_text=new Label("No text");
                label_text.setFont(Font.font("Comic Sans",15));
                EventHandler<ActionEvent>event_text=new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        try {
                            Items.addItem(text.getText());
                            label_text.setText(text.getText()+" added!");
                        } catch (ItemExistsExeption itemExistsExeption) {
                            label_text.setText("Item Exists already");
                        }
                    }
                };
                text.setOnAction(event_text);
                add.setOnAction(event_text);
                label1.setText("Items button selected");
                VBox item=new VBox(20);
                Label item_label=new Label("Add items");
                item_label.setFont(Font.font("Comic Sans",15));
                Button back1= new Button("Back");
                back1.setTextFill(Color.BLUE);
                back1.setOnAction(e -> stage.setScene(scene));
                item.getChildren().addAll(label1,item_label,label_text,text,add,back1);
                Scene scene1=new Scene(item,600,800);
                BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY);
                Background backround=new Background(backround_fill);
                item.setAlignment(Pos.CENTER);
                item.setBackground(backround);
                stage.setScene(scene1);
            }
        };
        //add champ
        EventHandler<ActionEvent>event2=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button add= new Button("Add");
                add.setTextFill(Color.RED);
                TextField text=new TextField();
                text.setFont(Font.font("Comic Sans",15));
                Label label_text=new Label("No text");
                label_text.setFont(Font.font("Comic Sans",15));
                EventHandler<ActionEvent>event_text=new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        label_text.setText(text.getText());
                        try {
                            Champions.addChampion(text.getText(),Users.getCurrentUsername());
                            label_text.setText(text.getText()+" added!");
                        } catch (ChampExistsExeption champExistsExeption) {
                            label_text.setText("Champion Exists already");
                        }
                    }
                };
                text.setOnAction(event_text);
                add.setOnAction(event_text);
                label1.setText("Champions button selected");
                label1.setFont(Font.font("Comic Sans",15));
                VBox champ=new VBox(20);
                Label champ_label=new Label("Choose one option delete/add");
                Button back1= new Button("Back");
                back1.setTextFill(Color.BLUE);
                back1.setOnAction(e -> stage.setScene(scene));
                champ.getChildren().addAll(label1,champ_label,label_text,text,add,back1);
                Scene scene2=new Scene(champ,600,800);
                BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW,CornerRadii.EMPTY,Insets.EMPTY);
                Background backround=new Background(backround_fill);
                champ.setAlignment(Pos.CENTER);
                champ.setBackground(backround);
                stage.setScene(scene2);
            }
        };
        //add comment
        EventHandler<ActionEvent>event3=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label1.setText("Add commits button selected");
                label1.setFont(Font.font("Comic Sans",15));
                VBox comm=new VBox(20);
                Label com_label=new Label("Add comm button");
                com_label.setFont(Font.font("Comic Sans",15));
                Button back1= new Button("Back");
                back1.setOnAction(e -> stage.setScene(scene));
                back1.setTextFill(Color.BLUE);
                comm.getChildren().addAll(label1,com_label,back1);
                Scene scene3=new Scene(comm,600,800);
                BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW,CornerRadii.EMPTY,Insets.EMPTY);
                Background backround=new Background(backround_fill);
                comm.setAlignment(Pos.CENTER);
                comm.setBackground(backround);
                stage.setScene(scene3);
            }
        };
        //see stats
        EventHandler<ActionEvent>event4=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label1.setText("Statistics button selected");
                label1.setFont(Font.font("Comic Sans",15));
                label1.setTextFill(Color.BLACK);
                VBox stats=new VBox(20);
                Label stats_label=new Label("Statistics");
                stats_label.setFont(Font.font("Comic Sans",15));
                stats_label.setTextFill(Color.BLACK);
                Button back1= new Button("Back");
                back1.setTextFill(Color.BLUE);
                back1.setOnAction(e -> stage.setScene(scene));
                stats.getChildren().addAll(label1,stats_label,back1);
                Scene scene4=new Scene(stats,600,800);
                BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW,CornerRadii.EMPTY,Insets.EMPTY);
                Background backround=new Background(backround_fill);
                stats.setAlignment(Pos.CENTER);
                stats.setBackground(backround);
                stage.setScene(scene4);

            }
        };
        b1.setOnAction(event1);
        b2.setOnAction(event2);
        b3.setOnAction(event3);
        b4.setOnAction(event4);
        BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW,CornerRadii.EMPTY,Insets.EMPTY);
        Background backround=new Background(backround_fill);
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(backround);
        vbox.setBackground(backround);
        stage.setScene(scene);
        stage.show();
    }
}
