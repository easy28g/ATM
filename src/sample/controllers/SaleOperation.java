package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.models.Products;
import sample.service.SaleOperationDetailsService.GetProductName;
import sample.service.SaleOperationDetailsService.impl.GetProductNameByBarcode;
import sample.service.database.DBservice;
import sample.service.database.DatabaseConnection;

public class SaleOperation {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField barcode;

    @FXML
    private TableView<?> totalCategoryColumn;

    @FXML
    private TableColumn<Products, String> productColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TableColumn<?, ?> amountColumn;

    @FXML
    private TableColumn<?, ?> addDateColumn;

    @FXML
    private TableColumn<?, ?> categoryColumn;

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

            // Получение название продукта по штрихкоду
            GetProductName getProductName = new GetProductNameByBarcode();
            String productName = getProductName.getProduct(newBarcode);
            //System.out.println(productName);


        });
    }
}
