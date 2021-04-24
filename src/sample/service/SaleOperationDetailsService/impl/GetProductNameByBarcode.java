package sample.service.SaleOperationDetailsService.impl;

import sample.service.SaleOperationDetailsService.GetProductName;
import sample.service.database.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetProductNameByBarcode implements GetProductName {

    private String getProductName(String barcode){
        String name=null;
        try{
            Statement statement = DatabaseConnection.connection.createStatement();
            String query = "SELECT name FROM products WHERE barcode='"+barcode+"'";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                name = rs.getString("name");
            }
            rs.close();
            statement.close();
            return name;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "null";
    }

    @Override
    public String getProduct(String barcode) {
        return getProductName(barcode);
    }
}
