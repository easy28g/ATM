package sample.service.forUserReg.getuserId;

import sample.service.database.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetUserIdFromTable implements GetUserIdInterface{

    private int getUserIdFromtable(String  userName){
        int id = 0;
        try {
            Statement statement = DatabaseConnection.connection.createStatement();
            String query = "SELECT id FROM users WHERE name='"+userName+"'";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                id = rs.getInt("id");
            }
            rs.close();
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public int getUserId(String userName) {
        return getUserIdFromtable(userName);
    }
}
