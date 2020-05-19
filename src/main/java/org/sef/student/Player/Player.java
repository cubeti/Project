package org.sef.student.Player;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.geometry.*;
import javafx.scene.paint.*;
import org.sef.student.Dev.Developer;
import org.sef.student.Model.Game;
import org.sef.student.Model.Item;
import org.sef.student.Register.AlertBox;
import org.sef.student.Services.*;

public class Player
{
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
        Button logout=new Button("Logout");
        logout.setTextFill(Color.RED);
        label1.setTextFill(Color.BLACK);
        tile.getChildren().add(label1);
        tile.getChildren().add(b1);
        tile.getChildren().add(b2);
        tile.getChildren().add(logout);
        Scene scene=new Scene(tile,800,800);

        logout.setOnAction(event -> {
            try
            {
                Parent login = FXMLLoader.load(Objects.requireNonNull(Developer.class.getClassLoader().getResource("login.fxml")));
                Scene loginScene = new Scene(login);
                stage.setScene(loginScene);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });

        EventHandler<ActionEvent>event1= actionEvent -> {
            List<String> items= Items.getItemNames();
            Label select= new Label("Win/Lose");
            select.setTextFill(Color.BLACK);
            select.setFont(Font.font("Comic Sans",15));

            Label label_champion=new Label("Champion Choice");
            label_champion.setFont(Font.font("Comic Sans",15));
            label_champion.setTextFill(Color.BLACK);
            ChoiceBox<String> choice_champ=new ChoiceBox<>(FXCollections.observableArrayList(Champions.getChampionNames()));
            //item 1
            Label label_item1= new Label("Item 1");
            label_item1.setFont(Font.font("Comic Sans",15));
            label_item1.setTextFill(Color.BLACK);
            //item 2
            Label label_item2= new Label("Item 2");
            label_item2.setFont(Font.font("Comic Sans",15));
            label_item2.setTextFill(Color.BLACK);
            //item 3
            Label label_item3= new Label("Item 3");
            label_item3.setFont(Font.font("Comic Sans",15));
            label_item3.setTextFill(Color.BLACK);
            //item 4
            Label label_item4= new Label("Item 4");
            label_item4.setFont(Font.font("Comic Sans",15));
            label_item4.setTextFill(Color.BLACK);
            //item 5
            Label label_item5= new Label("Item 5");
            label_item5.setFont(Font.font("Comic Sans",15));
            label_item5.setTextFill(Color.BLACK);
            //item 6
            Label label_item6= new Label("Item 6");
            label_item6.setFont(Font.font("Comic Sans",15));
            label_item6.setTextFill(Color.BLACK);
            //item 1 choice_box
            ChoiceBox<String> choice_item1=new ChoiceBox<>(FXCollections.observableArrayList(items));
            // choice iteem 2
            ChoiceBox<String> choice_item2=new ChoiceBox<>(FXCollections.observableArrayList(items));
            //choice item3
            ChoiceBox<String> choice_item3=new ChoiceBox<>(FXCollections.observableArrayList(items));
            //choice item4
            ChoiceBox<String> choice_item4=new ChoiceBox<>(FXCollections.observableArrayList(items));
            //item 5
            ChoiceBox<String> choice_item5=new ChoiceBox<>(FXCollections.observableArrayList(items));
            //item 6
            ChoiceBox<String> choice_item6=new ChoiceBox<>(FXCollections.observableArrayList(items));
            VBox add=new VBox(5);
            Label add_label=new Label("Game begins");
            add_label.setFont(Font.font("Comic Sans",15));
            add_label.setTextFill(Color.BLACK);
            Button back1= new Button("Back");
            back1.setTextFill(Color.BLUE);
            back1.setOnAction(e -> stage.setScene(scene));
            add.getChildren().addAll(label1,label_champion,choice_champ,label_item1,choice_item1,label_item2,choice_item2,label_item3,choice_item3,label_item4,choice_item4,label_item5,choice_item5,label_item6,choice_item6,select);
            String[] choice_win={"Win","Lose"};
            ChoiceBox<String> win_lose= new ChoiceBox<>(FXCollections.observableArrayList(choice_win));
            win_lose.setValue("Win");
            add.getChildren().add(win_lose);
            Button submit=new Button("Submit");
            submit.setTextFill(Color.BLUE);

            Label label_comm=new Label("Write a feedback!");
            label_comm.setFont(Font.font("Comic Sans",15));
            label_comm.setTextFill(Color.BLACK);

            TextField field=new TextField();

            field.maxHeightProperty();
            field.maxWidthProperty();
            field.setFont(Font.font("Comic sans",15));
            Button add_field=new Button("Submit");
            add_field.setFont(Font.font("Comic Sans",15));
            add_field.setTextFill(Color.GREEN);
            add.getChildren().addAll(label_comm,field);
            add.getChildren().add(submit);
            add.getChildren().add(back1);

            submit.setOnAction(event -> {
                if(Objects.isNull(choice_champ.getValue()))
                {
                    AlertBox.display("Error","No champ selected");
                    event.consume();
                }
                else {
                    ArrayList<Item> curentitems = new ArrayList<>();
                    curentitems.add(new Item(choice_item1.getValue()));
                    curentitems.add(new Item(choice_item2.getValue()));
                    curentitems.add(new Item(choice_item3.getValue()));
                    curentitems.add(new Item(choice_item4.getValue()));
                    curentitems.add(new Item(choice_item5.getValue()));
                    curentitems.add(new Item(choice_item6.getValue()));
                    Games.addGame(Users.getCurrentUsername(),
                            choice_champ.getValue(),
                            curentitems,
                            win_lose.getValue());
                    Messages.addMSG(Users.getCurrentUsername(), Champions.getDev(choice_champ.getValue()), field.getText());
                }
            });
            Scene scene1=new Scene(add,800,800);
            BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW,CornerRadii.EMPTY,Insets.EMPTY);
            Background backround=new Background(backround_fill);
            add.setAlignment(Pos.CENTER);
            add.setBackground(backround);
            stage.setScene(scene1);
        };
        EventHandler<ActionEvent> event2= actionEvent -> {
            VBox history=new VBox(5);
            TableView<Object> table=new TableView<>();

            TableColumn<Object, Object> Champion_column=new TableColumn<>("Champion");
            Champion_column.setCellValueFactory(new PropertyValueFactory<>("championName"));

            TableColumn<Object, Object> Item1_column=new TableColumn<>("Item1");
            Item1_column.setCellValueFactory(new PropertyValueFactory<>("item1"));

            TableColumn<Object, Object> Item2_column=new TableColumn<>("Item2");
            Item2_column.setCellValueFactory(new PropertyValueFactory<>("item2"));

            TableColumn<Object, Object> Item3_column=new TableColumn<>("Item3");
            Item3_column.setCellValueFactory(new PropertyValueFactory<>("item3"));

            TableColumn<Object, Object> Item4_column=new TableColumn<>("Item4");
            Item4_column.setCellValueFactory(new PropertyValueFactory<>("item4"));

            TableColumn<Object, Object> Item5_column=new TableColumn<>("Item5");
            Item5_column.setCellValueFactory(new PropertyValueFactory<>("item5"));

            TableColumn<Object, Object> Item6_column=new TableColumn<>("Item6");
            Item6_column.setCellValueFactory(new PropertyValueFactory<>("item6"));

            TableColumn<Object, Object> Win_Lose_column=new TableColumn<>("Win/Lose");
            Win_Lose_column.setCellValueFactory(new PropertyValueFactory<>("win"));

            table.getColumns().addAll(Champion_column,Item1_column,Item2_column,Item3_column,Item4_column,Item5_column,Item6_column,Win_Lose_column);

            List<Game> games=Games.getGames();
            for(Game g : games)
            {
                if(g.getUsername().equals(Users.getCurrentUsername()))
                    table.getItems().add(g);
            }
            label1.setText("History button selected");
            label1.setFont(Font.font("Comic Sans",15));
            label1.setTextFill(Color.BLACK);

            Label label_history=new Label("Watch previous games!");
            label_history.setFont(Font.font("Comic Sans",15));
            label_history.setTextFill(Color.BLACK);
            Button back1= new Button("Back");
            back1.setTextFill(Color.BLUE);
            back1.setOnAction(e -> stage.setScene(scene));
            history.getChildren().addAll(label1,label_history,table,back1);
            Scene scene2=new Scene(history,800,800);
            BackgroundFill backround_fill=new BackgroundFill(Color.GREENYELLOW,CornerRadii.EMPTY,Insets.EMPTY);
            Background backround=new Background(backround_fill);
            history.setAlignment(Pos.CENTER);
            history.setBackground(backround);
            stage.setScene(scene2);
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