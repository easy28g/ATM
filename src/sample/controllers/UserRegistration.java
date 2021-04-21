package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.service.database.DBservice;
import sample.service.database.DatabaseConnection;
import sample.service.forUserReg.CorrectUserNameLoginPassword;
import sample.service.forUserReg.impl.CorrectUserPasswordReg;
import sample.service.forUserReg.impl.CorrectUserLoginReg;
import sample.service.forUserReg.impl.CorrectUserNameReg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    public Label errorInPutUserLogin;

    @FXML
    private Label errorInPutUserPassword;

    @FXML
    private Label errorCreateNewUser;

    @FXML
    void initialize() {

        DBservice connectonClose = DatabaseConnection.INSTANCE;
        connectonClose.databaseConnection();

        newUserRegistration.setOnAction(actionEvent -> {

            String newUserName = signUpUserName.getText().trim();
            String newUserLogin = signUpUserLogin.getText().trim();
            String newUserPassword = signUpUserPassword.getText().trim();

            CorrectUserNameLoginPassword correctUserNameReg = new CorrectUserNameReg();
            boolean kirillica = correctUserNameReg.nameLoginPassword(newUserName);
            if(kirillica){
                errorInPutUserName.setText("");
            }  else {
                errorInPutUserName.setText("Имя должен содержать в себе больше 3 символов кирилицы!");
                System.out.println("Не кириллица");
            }

            CorrectUserNameLoginPassword correctUserLoginReg = new CorrectUserLoginReg();
            boolean loginBoolean = correctUserLoginReg.nameLoginPassword(newUserLogin);
            if(loginBoolean){
                errorInPutUserLogin.setText("");
            } else {
                errorInPutUserLogin.setText("Логин должен содержать в себе больше 5 символов латиницы!");
            }

            CorrectUserNameLoginPassword correctUserPasswordReg = new CorrectUserPasswordReg();
            boolean passwordBoolean = correctUserPasswordReg.nameLoginPassword(newUserPassword);
            if(passwordBoolean){
                errorInPutUserPassword.setText("");
            } else {
                errorInPutUserPassword.setText("Пароль должен содержать в себе больше 6 символов латиницы!");
            }


            if(kirillica && loginBoolean && passwordBoolean){
                newUserRegistration.getScene().getWindow().hide();

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
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Неудалось зарегистрировать! " +
                        "Введите все данные правильно!");
                alert.show();
            }

//            if(Pattern.matches("^[а-яА-ЯёЁ\s]+$",newUserName) && newUserName.length()>=3){
//                System.out.println("Кириллица");
//                errorInPutUserName.setText("");
//                kirillica = true;
//            } else {
//                errorInPutUserName.setText("Имя должен содержать в себе больше 3 символов кирилицы!");
//                System.out.println("Не кириллица");
//            }

        });

    }
}