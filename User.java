import java.util.Scanner;
import java.io.Serializable;

public abstract class User implements HasMenu, Serializable{
    private String userName;
    private String PIN;
    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String uName = scanner.next();
        System.out.print("PIN: ");
        String uPIN = scanner.next();

        return (uName.equals(userName) && uPIN.equals(PIN));
    }
    public boolean login(String uName, String uPIN){
        return (uName.equals(userName) && uPIN.equals(PIN));
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
    public String getPIN() {
        return PIN;
    }
    abstract String getReport();
}