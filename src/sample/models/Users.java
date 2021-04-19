package sample.models;

public class Users {

    private int id;
    private String firstname;

    public Users() {
    }

    public Users(int id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
