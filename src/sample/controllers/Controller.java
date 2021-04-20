package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.service.DatabaseConnection;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> TestTable;

    @FXML
    void initialize() {
        DatabaseConnection databaseConnection = new DatabaseConnection();

    }
}
