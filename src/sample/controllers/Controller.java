package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        DBservice connectionClose = DatabaseConnection.INSTANCE;
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
            //System.out.println(loginBool);
            if(loginBool==true && passwordBool==true){
                System.out.println("YEEEEEEEEEE");
                signInForUser.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/views/saleOperation.fxml"));

                try{
                    loader.load();
                }catch (IOException e){
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                connectionClose.databaseClose();

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Вход невыполнен!");
                alert.show();
                //System.out.println("NOOOOOOO");
            }
        });


        
        userReg.setOnAction(actionEvent -> {
            userReg.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/views/userRegistration.fxml"));

            try{
                loader.load();
            }catch (IOException e){
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }
}