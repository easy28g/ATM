package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.service.database.DBservice;
import sample.service.database.DatabaseConnection;
import sample.service.forUsers.FindLogin;
import sample.service.forUsers.FindPassword;
import sample.service.forUsers.impl.UserServiceImpl;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signInForUser;

    @FXML
    private Button userReg;

    @FXML
    private TextField userLogin;

    @FXML
    private PasswordField userPassword;

    @FXML
    void initialize() {
        DBservice connectionClose = new DatabaseConnection();
        connectionClose.databaseConnection();

        FindLogin findLogin = new UserServiceImpl();
        //boolean loginBool = findLogin.loginUser("userLogin");

        FindPassword findPassword = new UserServiceImpl();
        //boolean passwordBool = findPassword.passwordUser("userPassword");

        signInForUser.setOnAction(actionEvent -> {

            String loginButton = userLogin.getText().trim();
            String passwordButton = userPassword.getText().trim();

            boolean loginBool = findLogin.loginUser(loginButton);
            boolean passwordBool = findPassword.passwordUser(passwordButton);

            if(loginBool==true && passwordBool==true){
                System.out.println("YEEEEEEEEEE");

            }
        });

    }
}