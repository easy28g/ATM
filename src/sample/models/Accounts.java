package sample.models;

public class Accounts {
    private int userId;
    private String login;
    private String password;
    private int active;

    public Accounts() {
    }

    public Accounts(int userId, String login, String password, int active) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.active = active;
    }

    public int getUserId() {
        return userId;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
