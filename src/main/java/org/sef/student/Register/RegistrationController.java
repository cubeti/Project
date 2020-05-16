package org.sef.student.Register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.sef.student.Exceptions.UsernameAlreadyExistsException;
import org.sef.student.Services.Users;

import java.io.IOException;
import java.util.Objects;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox<String> role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Player", "Dev");
        role.setValue("Player");
    }

    @FXML
    public void handleRegisterAction(ActionEvent event) throws IOException {
            event.consume();

            if (usernameField.getText().isEmpty()) {
                registrationMessage.setText("Please fill the username");

            } else if (passwordField.getText().isEmpty())
                registrationMessage.setText("Please fill the password");
            else {
                try {
                    Users.addUser(usernameField.getText(), passwordField.getText(), role.getValue());
                    AlertBox.display("Registration", "Succesfull");
                    Parent login = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
                    Scene loginScene = new Scene(login);

                    //This line gets the Stage information
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    window.setScene(loginScene);
                    window.show();

                } catch (UsernameAlreadyExistsException e) {
                    AlertBox.display("Registration", "Username already take");
                }
            }
    }
}
