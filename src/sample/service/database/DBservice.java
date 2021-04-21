package sample.service.database;

public interface DBservice {
    DBservice INSTANCE = new DatabaseConnection();
    void databaseConnection();
    void databaseClose();
}
