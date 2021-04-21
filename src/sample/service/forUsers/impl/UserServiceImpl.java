package sample.service.forUsers.impl;

import sample.service.database.DBservice;
import sample.service.database.DatabaseConnection;
import sample.service.forUsers.FindLogin;
import sample.service.forUsers.FindPassword;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserServiceImpl implements FindLogin, FindPassword {

    DBservice connectionClose = new DatabaseConnection();
    Statement statement;

    @Override
    public boolean loginUser(String login) {
        try {
            statement = DatabaseConnection.connection.createStatement();
            String query = "SELECT login FROM accounts WHERE login='"+login+"'";
            ResultSet rs = statement.executeQuery(query);
            int count = 0;
            while (rs.next()){
                String log = rs.getString("login");
                count++;
            }
            if (count==0) {
                return false;
            }

            rs.close();
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean passwordUser(String password) {
        try {
            statement = DatabaseConnection.connection.createStatement();
            String query = "SELECT password FROM accounts WHERE password='"+password+"'";
            ResultSet rs = statement.executeQuery(query);
            int count = 0;
            while (rs.next()){
                String pword = rs.getString("password");
                count++;
            }
            if (count==0) {
                return false;
            }

            rs.close();
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
