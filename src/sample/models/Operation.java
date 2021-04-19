package sample.models;

import java.util.Calendar;
import java.util.Date;

public class Operation {

    private int id;
    private Calendar addDate;
    private int userId;
    private double sum;

    public Operation() {
    }

    public Operation(int id, int userId, double sum) {
        this.id = id;
        this.addDate = Calendar.getInstance();
        this.userId = userId;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }


    public Date getAddDate() {
        return addDate.getTime();
    }

    public void setAddDate(Calendar addDate) {
        this.addDate = addDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
