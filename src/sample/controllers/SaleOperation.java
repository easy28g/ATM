package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class SaleOperation {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField barcode;

    @FXML
    private TableColumn<?, ?> productColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TableColumn<?, ?> amountColumn;

    @FXML
    private TableColumn<?, ?> addDateColumn;

    @FXML
    private TextField amountProduct;

    @FXML
    private Button entryProduct;

    @FXML
    private Label totalSum;

    @FXML
    private Button finishOperaion;

    @FXML
    private Button nextPageOpDetails;

    @FXML
    private Button exitMenu;

    @FXML
    void initialize() {

    }
}
