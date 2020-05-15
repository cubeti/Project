package org.sef.student.Login;
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
import org.sef.student.Register.Register;
import org.sef.student.Services.Users;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    public void goRegister(ActionEvent event) throws IOException {
        Parent register = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("register.fxml")));
        Scene tableViewScene = new Scene(register);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    public void log()
    {
        System.out.println("ok");
    }
}
