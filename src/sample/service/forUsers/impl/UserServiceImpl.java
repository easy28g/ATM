package sample.service.forUsers.impl;

import sample.service.database.DBservice;
import sample.service.database.DatabaseConnection;
import sample.service.forUsers.FindLogin;
import sample.service.forUsers.FindPassword;

public class UserServiceImpl implements FindLogin, FindPassword {

    DBservice connectionClose = new DatabaseConnection();

    @Override
    public boolean loginUser(String login) {

        return true;
    }

    @Override
    public boolean passwordUser(String password) {

        return true;
    }
}
