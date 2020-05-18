package org.sef.student.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.sef.student.Dev.Developer;
import org.sef.student.Player.Player;
import org.sef.student.Register.AlertBox;
import org.sef.student.Services.Users;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Text registrationMessage;

    @FXML
    public void goRegister(ActionEvent event) throws IOException {
        Parent register = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("register.fxml")));
        Scene registerScene = new Scene(register);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registerScene);
        window.show();
    }
    @FXML
    public void log(ActionEvent event)
    {
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            event.consume();
            if(username.getText().isEmpty())
            {
            registrationMessage.setText("Please fill the username");
            }
            else
            {
                if(password.getText().isEmpty())
                    registrationMessage.setText("Please fill the password");
                else
                {
                    String role=Users.checkAccountExist(username.getText(),password.getText());
                    if(role!=null)
                    {
                        Users.setCurrentUser(username.getText(),role);
                        if (role.equals("Dev")) Developer.start(window);
                        else
                            if (role.equals("Player")) Player.start(window);

                            else
                                System.out.println("hello " + username.getText() + " u are logged in as a " + role);
                    }

                    else {
                        AlertBox.display("error","Incorect credentials");
                    }
                }
            }

    }
}
