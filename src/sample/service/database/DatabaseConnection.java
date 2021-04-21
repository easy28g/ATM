package sample.service.database;

import java.sql.*;

public class DatabaseConnection implements DBservice {

    public static Connection connection;
//    public static Statement statement;
//
//    public static ResultSet statementExecuteQuery(String query) throws SQLException {
//        ResultSet statementExecuteQuery =statement.executeQuery(query);
//        return statementExecuteQuery;
//    }
//
//    public static Statement createStatement() throws SQLException {
//        Statement createStatement = connection.createStatement();
//        return createStatement;
//    }
//
//    public static Statement closeStatement() throws SQLException {
//        Statement closeStatement = null;
//        closeStatement.close();
//        return closeStatement;
//    }

    private void ConnectionSQLite() {
        Connection connection = getConnection();
        System.out.println("Connection");
    }

    private Connection getConnection() {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(
                    "jdbc:sqlite:D:\\Azamat\\Javaitschool\\5month\\ATM\\sqlite3.db");
            //System.out.println("Connection");
            return connection;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void close() {
        try{
            connection.close();
            System.out.println("Close connection");
        }catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }


    @Override
    public void databaseConnection() {
        ConnectionSQLite();
    }

    @Override
    public void databaseClose() {
        close();
    }
}
