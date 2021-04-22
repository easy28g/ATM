package sample.service.forUserReg.insertIntoUserReg;

import sample.models.Accounts;
import sample.models.Users;
import sample.service.database.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertUserLoginPassword implements InsertUserLoginPasswordInterface{

    private void inserLoginPasswordInTable(int id, String login, String password){
        try {

            Accounts account = new Accounts(id,login,password);

            String query = "INSERT INTO accounts(id,login,password,active) " +
                    "VALUES ('" +account.getUserId()+ "', '"+account.getLogin()+"', " +
                    " '"+account.getPassword()+"', '"+account.getActive()+"')";

            Statement statement = DatabaseConnection.connection.createStatement();

            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void insertUserLoginPassword(int id, String login, String password) {
        inserLoginPasswordInTable(id,login,password);
    }
}
