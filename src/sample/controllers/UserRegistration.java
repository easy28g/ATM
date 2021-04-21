package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserRegistration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpUserName;

    @FXML
    private TextField signUpUserLogin;

    @FXML
    private PasswordField signUpUserPassword;

    @FXML
    private Button newUserRegistration;

    @FXML
    private Label errorInPutUserName;

    @FXML
    private Label errorInPutUserLogin;

    @FXML
    private Label errorInPutUserPassword;

    @FXML
    private Label errorCreateNewUser;

    @FXML
    void initialize() {

    }
}