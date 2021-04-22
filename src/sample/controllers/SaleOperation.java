package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        //Возврат в меню
        exitMenu.setOnAction(actionEvent -> {
            exitMenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/views/sample.fxml"));

            try{
                loader.load();
            }catch (IOException e){
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        entryProduct.setOnAction(actionEvent -> {
            String newBarcode = barcode.getText().trim();
            String newAmount = amountProduct.getText().trim();
        });
    }
}
