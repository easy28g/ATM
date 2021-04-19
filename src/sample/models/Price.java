package sample.models;

import java.util.Calendar;
import java.util.Date;

public class Price {
    private int id;
    private double price;
    private int productId;
    private Calendar startDate;
    private Date endDate;


    public Price() {
    }

    public Price(int id, double price, int productId) {
        Calendar calendar = Calendar.getInstance();
        this.id = id;
        this.price = price;
        this.productId = productId;
        this.startDate = calendar;
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        this.endDate = calendar.getTime();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
