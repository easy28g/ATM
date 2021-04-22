package sample.service.forUserReg.insertIntoUserReg;

import sample.models.Users;
import sample.service.database.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertUserName implements InsertUserInterface {

    private void insertInTable(String userName){
        try {
            Users users = new Users(userName);

            String query = "INSERT INTO users(name) " +
                    "VALUES ('" + users.getFirstname() + "')";

            Statement statement = DatabaseConnection.connection.createStatement();

            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void insertUserRegInterface(String name) {
        insertInTable(name);
    }
}
