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
import sample.service.forUserReg.getuserId.GetUserIdFromTable;
import sample.service.forUserReg.getuserId.GetUserIdInterface;
import sample.service.forUserReg.impl.CorrectUserPasswordReg;
import sample.service.forUserReg.impl.CorrectUserLoginReg;
import sample.service.forUserReg.impl.CorrectUserNameReg;
import sample.service.forUserReg.insertIntoUserReg.InsertUserLoginPassword;
import sample.service.forUserReg.insertIntoUserReg.InsertUserLoginPasswordInterface;
import sample.service.forUserReg.insertIntoUserReg.InsertUserName;
import sample.service.forUserReg.insertIntoUserReg.InsertUserInterface;
import sample.service.forUsers.FindLogin;
import sample.service.forUsers.impl.UserServiceImpl;

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

                //Проверка на существование логина в БД
                //если нет такого логина, то создадим аккаунт
                FindLogin findLogin = new UserServiceImpl();
                if(findLogin.loginUser(newUserLogin)==false){

                    //Вводим имя пользователя в БД
                    InsertUserInterface inserUserName = new InsertUserName();
                    inserUserName.insertUserRegInterface(newUserName);

                    //Получаем ID пользователя по имени
                    GetUserIdInterface getUserId = new GetUserIdFromTable();
                    int idUser = getUserId.getUserId(newUserName);

                    //Вводим логин и пароль в БД
                    InsertUserLoginPasswordInterface insertLoginPassword = new InsertUserLoginPassword();
                    insertLoginPassword.insertUserLoginPassword(idUser,newUserLogin,newUserPassword);

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
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Такой логин уже существует!");
                    alert.show();
                }


            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Неудалось зарегистрировать! " +
                        "Введите все данные правильно!");
                alert.show();
            }

        });

    }
}